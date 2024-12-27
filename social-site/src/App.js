import './App.css';
import React, { createContext, useState } from 'react';
import Navbar from './Navbar';
import Login from './components/accounts/Login';
import Register from './components/accounts/Register';
import AccountComponent from './components/accounts/AccountComponent';
import Messages from './components/messages/Messages';
import PostMessage from './components/messages/PostMessage';
import PostComment from './components/comments/PostComment';
import HomePage from './HomePage';
import SearchComponent from './components/searches/SearchComponent';
import SearchAccounts from './components/searches/SearchAccounts';
import SearchMessages from './components/searches/SearchMessages';
import {BrowserRouter as Router, Routes, Route, Navigate} from 'react-router-dom';

export const MyContext = createContext();

function App() {
  const userData={
    username: "",
    password: ""
  }
  const [context, setContext] = useState(userData);
  return (
    <MyContext.Provider value={[context, setContext]}>
    <Router>
    <div className="App">
      <Navbar/>
    </div>
    <Routes>
      <Route index element={<Navigate to="home" replace/>}/>
      <Route path='/home' element={<HomePage/>}/>
      <Route path='/messages' element={<Messages/>}/>
      <Route path='/messages/post' element={<PostMessage/>}/>
      <Route path='/messages/comments' element={<PostComment/>}/>
      <Route path='/account' element={<AccountComponent/>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/register' element={<Register/>}/>
      <Route path='/search' element={<SearchComponent/>}/>
      <Route path='/seacrh/accounts' element={<SearchAccounts/>}/>
      <Route path='/search/messages' element={<SearchMessages/>}/>
    </Routes>
    </Router>
    </MyContext.Provider>
  );
}

export default App;