import React from "react";
import Reservation, {IReservation} from "./Reservation";

export interface ReservationsProps {
    readonly reservations: IReservation[];
}

const Reservations: React.FC<ReservationsProps> = (props) => {

    return (
        <>
            <ul className="reservationsList">
                {props.reservations.map((reservation, idx) => {
                    return <Reservation key={idx} reservation={reservation}/>;
                })}
            </ul>
        </>
    );
};

export default Reservations;
