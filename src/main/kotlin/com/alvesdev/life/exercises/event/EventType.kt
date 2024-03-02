package com.alvesdev.life.exercises.event

import kotlin.reflect.KClass

enum class EventType(val eventBase: KClass<out EventBase>) {
    EXERCISE(EventExerciseBasic::class), // https://github.com/alves-dev/life/tree/main/events#exercise-routing_key---exercises
    PERSON_TRACKING(EventExerciseAcademy::class) // https://github.com/alves-dev/life/tree/main/events#person_tracking-routing_key---person_tracking
}