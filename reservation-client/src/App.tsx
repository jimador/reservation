import React from 'react';
import {useQuery} from '@apollo/react-hooks';
import {gql} from 'apollo-boost';


interface ILocation {
    id: number;
    name: string;
    reservations: IReservation[];
}

interface IReservation {
    id: number;
    name: string;
}

const LOCATIONS_QUERY = gql`
    {
        locations {
            name
            reservations {
                name
            }
        }
    }
`;

const App: React.FC = () => {

    const {loading, error, data} = useQuery(LOCATIONS_QUERY);

    if (loading) {
        return <p>Loading...</p>;
    }
    if (error) {
        return <p>Error :(</p>;
    }

    const locs = data.locations;
    return (
        <div>
            {locs.map((location: ILocation, locIdx: number) => {
                return (
                    <div key={locIdx}>
                        <h2>{location.name}</h2>
                        <ul>
                            {location.reservations.map((res: IReservation, resIdx: number) => {
                                return <div key={resIdx}>{res.name}</div>;
                            })}
                        </ul>
                    </div>
                );
            })}
        </div>
    );
};

export default App;
