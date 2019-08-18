import React from 'react';
import {IReservation} from "./Reservation";
import Reservations from "./Reservations";

export interface LocationProps {
    readonly index?: number;
    readonly location: ILocation
}

export interface ILocation {
    id: number;
    name: string;
    reservations: IReservation[];
}

const Location: React.FC<LocationProps> = (props) => {
    return (
        <>
            <div className="location">
                {`The Reservation Location is: ${props.location.name}`}
            </div>
            <Reservations reservations={props.location.reservations}/>
        </>
    )
};

export default Location;
