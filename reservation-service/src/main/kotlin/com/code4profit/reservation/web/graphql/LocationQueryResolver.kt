package com.code4profit.reservation.web.graphql

import com.code4profit.reservation.domain.Location
import com.code4profit.reservation.repository.LocationRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class LocationQueryResolver(private val locationRepository: LocationRepository) : GraphQLQueryResolver {

    fun locations(): List<Location> {
        return locationRepository.findAll()
    }

}
