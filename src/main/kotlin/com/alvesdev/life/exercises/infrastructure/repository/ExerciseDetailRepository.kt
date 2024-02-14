package com.alvesdev.life.exercises.infrastructure.repository

import com.alvesdev.life.exercises.model.ExerciseDetail
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExerciseDetailRepository : JpaRepository<ExerciseDetail, UUID> {
}