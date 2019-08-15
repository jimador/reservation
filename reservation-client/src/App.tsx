import React, { useEffect, useState } from 'react';
import axios from 'axios';
import log from 'loglevel';

interface IReservation {
  id: number;
  name: string;
}

const App: React.FC = () => {
      const [state, setState] = useState<IReservation[]>([]);

      useEffect(() => {
        axios.get('http://localhost:8080/api/reservations')
            .then(response => setState(response.data))
            .catch(err => log.error(err));
      });

      return (
          <div className="App">
            <h1>
              <strong>Hello World</strong>
              {state.map((item: IReservation, index: number) => (
                      <li key={item.id}>{item.name}</li>
                  )
              )}
            </h1>
          </div>
      );
    }
;

export default App;
