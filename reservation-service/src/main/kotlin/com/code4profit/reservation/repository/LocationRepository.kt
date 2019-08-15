package com.code4profit.reservation.repository

import com.code4profit.reservation.domain.Location
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<Location, Long>
