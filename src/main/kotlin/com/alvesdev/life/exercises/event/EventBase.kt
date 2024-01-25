package com.alvesdev.life.exercises.event

import java.util.*

open class EventBase() {
    lateinit var type: EventType
    lateinit var personId: UUID

    override fun toString(): String {
        return "Event(type=$type, personId='$personId')"
    }
}
