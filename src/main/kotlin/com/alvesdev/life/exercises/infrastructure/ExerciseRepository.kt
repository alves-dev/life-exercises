package com.alvesdev.life.exercises.infrastructure

import com.alvesdev.life.exercises.model.Exercise
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExerciseRepository : JpaRepository<Exercise, UUID> {
}