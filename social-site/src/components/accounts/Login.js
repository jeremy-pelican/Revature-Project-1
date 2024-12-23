import React, {useState} from 'react';
import {useNavigate, Link} from 'react-router-dom';
import AuthService from '../../AuthService';
import axios from "axios";

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();
    const loginHandler=async(e)=>{
        e.preventDefault();
        try {
            const response = await AuthService.login({username, password});
            if (response.data !== 'Invalid Login Credentials') {
                localStorage.setItem('token', response.data);
                console.log(response.data);
                navigate('/account');
            }
            else {
                setMessage('Invalid Login Credentials');
            }
        }
        catch(error) {
            setMessage('Invalid Login Credentials');
        }
        // const userData={
        //     username: "username",
        //     password: "password"
        // };
        // axios.post("http://localhost/8080/login", userData)
        // .then((res)=>{
        //     console.log(res.data);
        // })
    }
    return ( 
        <>
        <form onSubmit={loginHandler}>
            <label>Username:</label>
                <input type="text" id="name" value={username} onChange={(e)=>setUsername(e.target.value)}/><br/>
            <label>Password:</label>
                <input type="passowrd" id="password" value={password} onChange={(e)=>setPassword(e.target.value)}/><br/>
            <button type="submit" value="Login">Login</button>
        </form>
        <span>Not registered? <Link to="/register">Register here</Link></span>
        </>
     );
}
 
export default Login;