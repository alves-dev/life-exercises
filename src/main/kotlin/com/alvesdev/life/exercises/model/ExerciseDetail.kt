package com.alvesdev.life.exercises.model

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(name = "exercise_detail")
class ExerciseDetail(

    @Id
    @Column(name = "exercise_id", columnDefinition = "char(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    var exerciseId: UUID,

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    var exercise: Exercise,

    @Column(name = "created_at", nullable = false)
    var createdAt: ZonedDateTime,

    @Column(name = "origin", length = 20, nullable = false)
    var origin: String,

    @Column(name = "external_id", length = 20)
    var externalId: String
) {
    constructor() : this(
        exerciseId = UUID.randomUUID(),
        exercise = Exercise(),
        createdAt = ZonedDateTime.now(),
        origin = "",
        externalId = ""
    )

    constructor(exe: Exercise, origin: String) : this(
        exerciseId = exe.id,
        exercise = exe,
        createdAt = ZonedDateTime.now(),
        origin = origin,
        externalId = "ttt"
    )
}
