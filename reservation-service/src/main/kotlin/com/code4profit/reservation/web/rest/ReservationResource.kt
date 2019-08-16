package com.code4profit.reservation.web.rest

import com.code4profit.reservation.domain.Reservation
import com.code4profit.reservation.repository.ReservationRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ReservationResource(private val repository: ReservationRepository) {

    @GetMapping("/reservations")
    fun findAll(): Collection<Reservation> = repository.findAll()

    @GetMapping("/reservations/{id}")
    fun findOne(@PathVariable id: Long): Reservation = repository.findById(id).orElse(null)

    @PostMapping("/reservations")
    fun save(@RequestBody reservation: Reservation): Reservation = repository.save(reservation)

}
