package com.alvesdev.life.exercises.event

import kotlin.reflect.KClass

enum class EventType(val eventBase: KClass<out EventBase>) {
    EXERCISE(EventExerciseBasic::class),
    PERSON_TRACKING(EventExerciseAcademy::class)
}