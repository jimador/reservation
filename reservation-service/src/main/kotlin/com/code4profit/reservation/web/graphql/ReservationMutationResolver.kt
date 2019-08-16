package com.code4profit.reservation.web.graphql

import com.code4profit.reservation.domain.Reservation
import com.code4profit.reservation.repository.LocationRepository
import com.code4profit.reservation.repository.ReservationRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class ReservationMutationResolver(private val locationRepository: LocationRepository,
                                  private val reservationRepository: ReservationRepository) : GraphQLMutationResolver {

    fun newReservation(name: String, locationId: Long): Reservation {
        val location = locationRepository.findById(locationId)
            .orElseThrow { throw RuntimeException("No Location found with id: $locationId") }

        val reservation = reservationRepository.save(Reservation(null, name))

        locationRepository.save(location.addReservation(reservation))

        return reservation
    }

    fun deleteReservation(id: Long): Boolean {
        reservationRepository.deleteById(id)
        return true
    }

    fun updateReservation(id: Long, locationId: Long): Reservation {
        val location = locationRepository.findById(locationId).orElseThrow { throw NullPointerException("Location with ID: $locationId not found") }

        val reservation = reservationRepository.findById(id)
            .orElseThrow { throw NullPointerException("Reservation with ID: $id not found") }

        location.addReservation(reservation)

        return reservation

    }
}
