package com.code4profit.reservation.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Location(@Id @GeneratedValue var id: Long?,
                    @NotBlank val name: String,
                    @OneToMany(fetch = FetchType.EAGER,
                        mappedBy = "location",
                        cascade = [CascadeType.ALL])
                    val reservations: MutableList<Reservation> = mutableListOf()) {

    fun addReservation(reservation: Reservation) : Location {
        reservation.location = this
        this.reservations.add(reservation)
        return this
    }

    fun addReservations(reservations: Iterable<Reservation>): Location {
        this.reservations.addAll(reservations.map { Reservation(null, it.name, this) })
        return this
    }
}
