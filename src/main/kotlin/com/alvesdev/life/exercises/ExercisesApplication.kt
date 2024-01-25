package com.alvesdev.life.exercises

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ExercisesApplication

fun main(args: Array<String>) {
	runApplication<ExercisesApplication>(*args)

	@PostConstruct
	fun started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))
	}
}
