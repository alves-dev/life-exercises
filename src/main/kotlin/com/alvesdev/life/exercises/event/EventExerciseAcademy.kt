package com.alvesdev.life.exercises.event

// https://github.com/alves-dev/life/tree/main/events#person_tracking
class EventExerciseAcademy() : EventBase() {
    lateinit var action: String
    lateinit var local: String
    var minutes: Double = 0.0
    lateinit var origin: String

    override fun toString(): String {
        return "EventExerciseBasic(type=$type, personId='$personId', datetime='$datetime', " +
                "action=$action, local=$local, minutes=$minutes, origin=$origin)"
    }
}