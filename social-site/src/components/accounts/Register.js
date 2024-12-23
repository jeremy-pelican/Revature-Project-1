import React, {useState} from 'react';
import {useNavigate, Link} from 'react-router-dom';
import AuthService from '../../AuthService';

const Register = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();
    const registerHandler=async(e)=>{
        e.preventDefault();
        try {
            const response = await AuthService.register({username, password});
            if (response.data !== 'Invalid Registration Credentials') {
                localStorage.setItem('token', response.data);
                navigate('/account');
            }
            else {
                setMessage('Invalid Registration Credentials');
            }
        }
        catch(error) {
            setMessage('Invalid Registration Credentials');
        }
    }
    return ( 
        <>
        <form onSubmit={registerHandler}>
            <label>Username:</label>
                <input type="text" id="name" value={username} onChange={(e)=>setUsername(e.target.value)}/><br/>
            <label>Password:</label>
                <input type="passowrd" id="password" value={password} onChange={(e)=>setPassword(e.target.value)}/><br/>
            <button type="submit" value="Register">Register</button>
        </form>
        </>
     );
}
 
export default Register;