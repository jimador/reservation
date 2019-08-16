package com.code4profit.reservation.web.graphql

import com.code4profit.reservation.domain.Location
import com.code4profit.reservation.repository.LocationRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class LocationMutationResolver(private val locationRepository: LocationRepository) : GraphQLMutationResolver {

    fun newLocation(name: String) = locationRepository.save(Location(null, name, mutableListOf()))

}
