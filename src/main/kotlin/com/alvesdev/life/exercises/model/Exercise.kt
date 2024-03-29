package com.alvesdev.life.exercises.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "exercise")
class Exercise(

    @Id
    @Column(name = "exercise_id", columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    var id: UUID,

    @Column(name = "person_id", columnDefinition = "char(36)", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    var personId: UUID,

    @Column(name = "datetime", nullable = false)
    var datetime: ZonedDateTime,

    @Column(name = "type", length = 20, nullable = false)
    var type: String,

    @Column(name = "minutes", nullable = false)
    var minutes: Double
) {
    constructor(personId: UUID, datetime: ZonedDateTime, type: String, minutes: Double) : this(
        id = UUID.randomUUID(),
        personId = personId,
        datetime = datetime,
        type = type,
        minutes = minutes
    )

    constructor() : this(
        id = UUID.randomUUID(),
        personId = UUID.randomUUID(),
        datetime = ZonedDateTime.now(),
        type = "",
        minutes = 0.0
    )

    override fun toString(): String {
        return "Exercise(personId=$personId, datetime=$datetime, type='$type', minutes=$minutes)"
    }
}
