import React from "react";
import Location, {ILocation} from "./Location";

export interface LocationProps {
    readonly locations: ILocation[]
}

const Locations: React.FC<LocationProps> = (props) => {
    return (
        <>
            {props.locations.map((location: ILocation, locIdx: number) => {
                return (
                    <div key={locIdx}>
                        <Location location={location}/>
                    </div>
                );
            })}
        </>
    );
};

export default Locations;
