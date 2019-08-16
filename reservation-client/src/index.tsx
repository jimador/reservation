import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import ApolloClient from 'apollo-boost'

import {ApolloProvider} from '@apollo/react-hooks';


const apolloClient = new ApolloClient({
    uri: "http://localhost:8080/graphql",
    headers: {"Access-Control-Allow-Origin": "*"},
});

ReactDOM.render(
    <ApolloProvider client={apolloClient}>
        <App/>
    </ApolloProvider>
    , document.getElementById('root'));

