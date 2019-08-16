package com.code4profit.reservation.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Reservation(@Id @GeneratedValue var id: Long?,
                       @NotBlank val name: String) {
    @ManyToOne(fetch = FetchType.LAZY)
    var location: Location? = null
}

