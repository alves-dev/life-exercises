package com.alvesdev.life.exercises.infrastructure

import com.alvesdev.life.exercises.event.EventBase
import com.alvesdev.life.exercises.event.EventExerciseAcademy
import com.alvesdev.life.exercises.event.EventExerciseBasic
import com.alvesdev.life.exercises.infrastructure.repository.ExerciseDetailRepository
import com.alvesdev.life.exercises.infrastructure.repository.ExerciseRepository
import com.alvesdev.life.exercises.model.Exercise
import com.alvesdev.life.exercises.model.ExerciseDetail
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.*

@Service
class Service {

    private val log: Logger = LoggerFactory.getLogger(Service::class.java)

    @Autowired
    private lateinit var exerciseRepository: ExerciseRepository

    @Autowired
    private lateinit var exerciseDetailRepository: ExerciseDetailRepository

    private final val local = "ACADEMY"
    private final val action = "REMAINED"

    @Value("\${application.academy.minimum.minutes}")
    private var minutes: Int = 0

    @Async
    @EventListener
    fun processEventExerciseBasic(event: EventExerciseBasic) {
        val uuid = UUID.randomUUID()
        exerciseRepository.save(
            Exercise(
                uuid,
                event.personId,
                event.datetime,
                event.typeExercise,
                event.minutes
            )
        )
    }

    @Async
    @EventListener
    fun processEventExerciseAcademy(event: EventExerciseAcademy) {
        if (!event.local.equals(this.local, ignoreCase = true)
            || event.action != this.action
            || event.minutes < this.minutes
        ) {
            log.warn("Event not processed: $event")
            return
        }

        try {
            val exercise = exerciseRepository.save(
                Exercise(
                    event.personId,
                    event.datetime,
                    "ACADEMY",
                    event.minutes
                )
            )
            exerciseDetailRepository.save(
                ExerciseDetail(
                    exercise,
                    event.origin
                )
            )
            log.info("Saved: $exercise")
        } catch (e: Exception) {
            log.error(e.message)
        }
    }

    @Async
    @EventListener
    fun processEventBase(event: EventBase) {
        log.info(event.toString())
    }

    fun getAll(): List<Exercise> {
        return exerciseRepository.findAll()
    }
}

