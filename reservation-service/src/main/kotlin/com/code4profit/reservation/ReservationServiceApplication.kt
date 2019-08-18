package com.code4profit.reservation

import com.code4profit.reservation.domain.Location
import com.code4profit.reservation.domain.Reservation
import com.code4profit.reservation.repository.LocationRepository
import com.code4profit.reservation.repository.ReservationRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.beans
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [LocationRepository::class])
class ReservationServiceApplication {
    @Configuration
    @EnableWebMvc
    class WebConfig : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ReservationServiceApplication>(*args) {
        val config = beans {
            bean {
                ApplicationListener<ApplicationReadyEvent> {
                    val resRepository = ref<ReservationRepository>()
                    val locationRepository = ref<LocationRepository>()
                    listOf("James", "John", "Steve", "Frank", "Dooof", "Jax")
                        .map { Reservation(null, it) }
                        .map { resRepository.save(it) }

                    listOf("McDonalds")
                        .map { Location(null, it, resRepository.findAll()) }
                        .map { locationRepository.save(it) }

                }
            }
        }

        //Application Initializers
        addInitializers(config)

    }
}
