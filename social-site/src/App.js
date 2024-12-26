import './App.css';
import React from 'react';
import Navbar from './Navbar';
import Login from './components/accounts/Login';
import Register from './components/accounts/Register';
import AccountComponent from './components/accounts/AccountComponent';
import Messages from './components/messages/Messages';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import HomePage from './HomePage';
import SearchComponent from './components/SearchComponent';

function App() {
  return (
    <Router>
    <div className="App">
      <Navbar/>
    </div>
    <Routes>
      <Route path='/home' element={<HomePage/>}/>
      <Route path='/messages' element={<Messages/>}/>
      <Route path='/account' element={<AccountComponent/>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/register' element={<Register/>}/>
      <Route path='/search' element={<SearchComponent/>}/>
    </Routes>
    </Router>
  );
}

export default App;
