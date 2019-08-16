package com.code4profit.reservation.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Location(@Id @GeneratedValue var id: Long?,
                    @NotBlank val name: String,
                    @OneToMany(fetch = FetchType.EAGER) val reservations: MutableList<Reservation>) {

    fun addReservation(reservation: Reservation) : Location {
        this.reservations.add(reservation)
        reservation.location = this
        return this
    }
}
