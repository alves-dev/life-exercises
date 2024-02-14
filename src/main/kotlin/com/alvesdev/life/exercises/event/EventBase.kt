package com.alvesdev.life.exercises.event

import com.fasterxml.jackson.annotation.JsonAlias
import java.time.ZonedDateTime
import java.util.*

// https://github.com/alves-dev/life/blob/main/events/README.md#todos-os-eventos-vao-ter-os-seguintes-campos
open class EventBase() {
    lateinit var type: EventType

    @JsonAlias("person_id")
    lateinit var personId: UUID

    lateinit var datetime: ZonedDateTime

    override fun toString(): String {
        return "Event(type=$type, personId='$personId', datetime='$datetime')"
    }
}
