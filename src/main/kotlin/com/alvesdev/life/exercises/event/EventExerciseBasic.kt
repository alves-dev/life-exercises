package com.alvesdev.life.exercises.event

import java.time.ZonedDateTime

class EventExerciseBasic() : EventBase() {
    lateinit var datetime: ZonedDateTime
    lateinit var typeExercise: String
    lateinit var detail: Detail

    override fun toString(): String {
        return "EventExerciseBasic(type=$type, personId='$personId', datetime='$datetime', " +
                "typeExercise=$typeExercise, detail=$detail)"
    }
}

class Detail() {
    lateinit var origin: String
    var externalId: String = ""

    override fun toString(): String {
        return "(origin='$origin', externalId='$externalId')"
    }
}