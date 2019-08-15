package com.code4profit.reservation

import com.code4profit.reservation.domain.Reservation
import com.code4profit.reservation.repository.ReservationRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.context.support.beans

@SpringBootApplication
class ReservationServiceApplication

fun main(args: Array<String>) {
    runApplication<ReservationServiceApplication>(*args) {
        val config = beans {
            bean {
                ApplicationListener<ApplicationReadyEvent> {
                    val repository = ref<ReservationRepository>()
                    listOf("James", "John", "Steve", "Frank", "Dooof", "Jax")
                            .map { Reservation(null, it) }
                            .map { repository.save(it) }
                            .forEach { println(it) }
                }
            }
        }

        //Application Initializers
        addInitializers(config)
    }
}