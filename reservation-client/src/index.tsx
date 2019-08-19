import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './App.css'
import App from './App';
import ApolloClient from 'apollo-boost'


import {ApolloProvider} from '@apollo/react-hooks';
import Helmet from "react-helmet";

const apolloClient = new ApolloClient({
    uri: "http://localhost:8080/graphql"
});

ReactDOM.render(
    <ApolloProvider client={apolloClient}>
        <Helmet title={"Reservations for fun and profit"}>
            <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
        </Helmet>
        <div className="container">
            <App/>
        </div>
    </ApolloProvider>
    , document.getElementById('root'));

