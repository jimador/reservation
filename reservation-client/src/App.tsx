import React from 'react';
import {useQuery} from '@apollo/react-hooks';
import {LOCATIONS_QUERY} from "./config/queries";
import Locations from "./components/Locations";


const App: React.FC = () => {

    const {loading, error, data} = useQuery(LOCATIONS_QUERY);

    if (loading) {
        return <p>Loading...</p>;
    }
    if (error) {
        return <p>Error :(</p>;
    }

    return (
        <>
            <Locations locations={data.locations}/>
        </>
    );
};

export default App;
