import React from 'react';
import './App.css';

import {Container, Row, Col} from 'react-bootstrap';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import NavigationBar from './components/NavigationBar';
import Standing from './components/Standing';
import Footer from './components/Footer';

function App() {
  const marginTop = {
    marginTop:"20px"
  };

  return (
    <Router>
        <NavigationBar/>
        <Standing/>
        <Footer/>
    </Router>
  );
}

export default App;
