package com.code4profit.reservation.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Reservation(@Id @GeneratedValue var id: Long?,
                       @NotBlank val name: String) {

}

