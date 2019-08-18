import React from "react";

export interface IReservation {
    id?: number;
    name: string;
}

export interface ReservationProps {
    readonly reservation: IReservation;
}

const Reservation: React.FC<ReservationProps> = (props) => {

    return (
        <>
            <div className="reservation">{`Reservation for: ${props.reservation.name}`}</div>
        </>
    )
};

export default Reservation;
