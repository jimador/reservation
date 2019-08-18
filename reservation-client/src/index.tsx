import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import ApolloClient from 'apollo-boost'


import {ApolloProvider} from '@apollo/react-hooks';
import 'bootstrap/dist/css/bootstrap.css';
import {Card} from 'react-bootstrap';

const apolloClient = new ApolloClient({
    uri: "http://localhost:8080/graphql",
    headers: {"Access-Control-Allow-Origin": "*"},
});

ReactDOM.render(
    <ApolloProvider client={apolloClient}>
        <Card style={{width: '18rem', justifyContent: 'center'}}>
            <Card.Body className='text-center'>
                <App/>
            </Card.Body>
        </Card>
    </ApolloProvider>
    , document.getElementById('root'));

