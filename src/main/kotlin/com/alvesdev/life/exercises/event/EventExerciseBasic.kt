package com.alvesdev.life.exercises.event

import com.fasterxml.jackson.annotation.JsonAlias

class EventExerciseBasic() : EventBase() {
    @JsonAlias("type_exercise")
    lateinit var typeExercise: String

    var minutes: Double = 0.0

    lateinit var detail: Detail

    override fun toString(): String {
        return "EventExerciseBasic(type=$type, personId='$personId', datetime='$datetime', " +
                "typeExercise=$typeExercise, minutes=$minutes, detail=$detail)"
    }
}

class Detail() {
    lateinit var origin: String

    @JsonAlias("external_id")
    var externalId: String? = null

    override fun toString(): String {
        return "(origin='$origin', externalId='$externalId')"
    }
}