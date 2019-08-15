package com.code4profit.reservation.web.graphql

import com.code4profit.reservation.domain.Reservation
import com.code4profit.reservation.repository.LocationRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class ReservationQueryResolver(private val locationRepository: LocationRepository) : GraphQLQueryResolver {

    fun reservations(locationId: Long): List<Reservation> {
        return locationRepository.findById(locationId)
            .map { it.reservations }
            .orElse(emptyList())
    }
}
