import {gql} from "apollo-boost";

export const LOCATIONS_QUERY = gql`
    {
        locations {
            name
            reservations {
                id
                name
            }
        }
    }
`;
