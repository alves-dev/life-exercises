package com.alvesdev.life.exercises.infrastructure.listener

import com.alvesdev.life.exercises.event.EventBase
import com.alvesdev.life.exercises.event.EventType
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class RabbitMqListener {

    private val log: Logger = LoggerFactory.getLogger(RabbitMqListener::class.java)

    @Autowired
    private lateinit var eventPublisher: ApplicationEventPublisher

    private val jsonMapper: JsonMapper = JsonMapper.builder().findAndAddModules()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .build()

    @RabbitListener(queues = ["\${application.rabbit.queues.exercises}", "\${application.rabbit.queues.tracking}"])
    fun handleEvent(message: String?) {
        try {
            val node = jsonMapper.readTree(message)
            val eventTypeValue = node.get("type").asText()

            val eventClass = EventType.valueOf(eventTypeValue).eventBase.java
            val event: EventBase = jsonMapper.readValue(message, eventClass)

            eventPublisher.publishEvent(event)
        } catch (e: Exception) {
            log.warn("[RabbitMqListener] Error parsing: $message")
            log.warn(e.toString())
        }
    }
}