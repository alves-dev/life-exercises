package com.alvesdev.life.exercises.infrastructure

import com.alvesdev.life.exercises.event.EventBase
import com.alvesdev.life.exercises.event.EventExerciseBasic
import com.alvesdev.life.exercises.model.Exercise
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.*

@Service
class Service {

    @Autowired
    private lateinit var exerciseRepository: ExerciseRepository

//    @Autowired
//    private lateinit var applicationRepository: ApplicationRepository

    @Async
    @EventListener
    fun processEventExerciseBasic(event: EventExerciseBasic) {
        val uuid = UUID.randomUUID()
        exerciseRepository.save(Exercise(uuid, event.personId, event.datetime, event.typeExercise))
    }

    @Async
    @EventListener
    fun processEventBase(event: EventBase) {
        println(event)
    }
}

