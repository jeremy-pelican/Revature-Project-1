import React, {useState} from 'react';
import {useNavigate, Link} from 'react-router-dom';
import AuthService from '../../AuthService';
import axios from "axios";

const Register = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();
    const registerHandler=async(e)=>{
        e.preventDefault();
        // try {
        //     const response = await AuthService.register({username, password});
        //     if (response.data !== 'Invalid Registration Credentials') {
        //         localStorage.setItem('token', response.data);
        //         navigate('/account');
        //     }
        //     else {
        //         setMessage('Invalid Registration Credentials');
        //     }
        // }
        // catch(error) {
        //     setMessage('Invalid Registration Credentials');
        // }
        const userData={
            username: username,
            password: password
        }
        axios.post("http://localhost:8080/register", userData)
        .then((res)=>{
            console.log(res.data);
            alert("Registration successful!");
        })
        .catch((error)=>{
            console.log(`Registration credentials invalid: username "${username}" already exists`);
            alert("Registration UNsuccessful!");
        })
    }
    return ( 
        <>
        <form onSubmit={registerHandler}>
            <label>Username:</label>
                <input type="text" id="name" value={username} onChange={(e)=>setUsername(e.target.value)}/><br/>
            <label>Password:</label>
                <input type="password" id="password" value={password} onChange={(e)=>setPassword(e.target.value)}/><br/>
            <button type="submit" value="Register">Register</button>
        </form>
        <span>Already have an account? <Link to="/login">Login</Link></span>
        </>
     );
}
 
export default Register;