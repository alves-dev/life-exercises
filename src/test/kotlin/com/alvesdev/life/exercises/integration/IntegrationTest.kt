package com.alvesdev.life.exercises.integration

import com.alvesdev.life.exercises.infrastructure.Service
import com.rabbitmq.client.ConnectionFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.containers.RabbitMQContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.function.Supplier


@Testcontainers
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IntegrationTest {

    companion object {

        @JvmStatic
        @Container
        private var rabbitMQContainer: RabbitMQContainer =
            RabbitMQContainer("rabbitmq:3-management-alpine")
                .withQueue("exercises")
                .withQueue("person_tracking")

        @JvmStatic
        @Container
        private var mySQLContainer: MySQLContainer<*> = MySQLContainer("mysql:8")
            .withDatabaseName("db")
            .withUsername("user")
            .withPassword("pass")

        @JvmStatic
        @DynamicPropertySource
        fun configureProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl)
            registry.add("spring.datasource.username", mySQLContainer::getUsername)
            registry.add("spring.datasource.password", mySQLContainer::getPassword)

            registry.add("spring.rabbitmq.host", rabbitMQContainer::getHost)
            registry.add("spring.rabbitmq.port", Supplier { rabbitMQContainer.getMappedPort(5672) })
            registry.add("spring.rabbitmq.username", rabbitMQContainer::getAdminUsername)
            registry.add("spring.rabbitmq.password", rabbitMQContainer::getAdminPassword)
            registry.add("spring.rabbitmq.ssl.enabled", Supplier { false })
            registry.add(
                "spring.rabbitmq.listener.simple.default-requeue-rejected",
                Supplier { true })
        }
    }

    @Autowired
    private lateinit var service: Service

    @Test
    fun containersIsRunning() {
        assert(rabbitMQContainer.isRunning)
        assert(mySQLContainer.isRunning)
    }

    @Test
    fun testPersonTracking() {
        val rabbit = ConnectionFactory()
        rabbit.host = rabbitMQContainer.host
        rabbit.port = rabbitMQContainer.getMappedPort(5672)

        val connection = rabbit.newConnection()
        val channel = connection.createChannel()

        val message = """
            {
                "type": "PERSON_TRACKING",
                "person_id": "7a898991-d3b3-4200-947d-ad8bff55ccba",
                "datetime": "2024-01-23T14:45-03:00",
                "action": "REMAINED",
                "local": "ACADEMY",
                "minutes": 45.6,
                "origin": "Home assistant"
            }
            """.trimIndent()
        channel.basicPublish("", "person_tracking", null, message.toByteArray())

        channel.close()
        connection.close()

        Thread.sleep(1000L * 1L) // seconds

        val list = service.getAll()

        Assertions.assertNotNull(list)
        Assertions.assertTrue(list.isNotEmpty())
        Assertions.assertEquals(1, list.size)

        Assertions.assertEquals("7a898991-d3b3-4200-947d-ad8bff55ccba", list[0].personId.toString())
        Assertions.assertEquals("2024-01-23T17:45Z", list[0].datetime.toString())
        Assertions.assertEquals("ACADEMY", list[0].type)
        Assertions.assertEquals(45.6, list[0].minutes)
    }
}