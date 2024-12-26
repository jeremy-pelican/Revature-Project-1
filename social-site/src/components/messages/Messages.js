import {useState, useEffect} from 'react';
import axios from "axios";
import DisplayPost from './DisplayPost';
import { Link } from 'react-router-dom';

const Messages = () => {
    const[posts, setPosts]=useState([]);
    useEffect(()=>{
        axios.get("http://localhost:8080/messages")
        .then(res=>{
            setPosts(res.data)
        })
        .catch((error)=>{
            console.log("Failed to retreive messages")
        })
    }, [posts])
    return ( 
        <>
        <Link to="/messages">Post a new Message</Link>
        <DisplayPost posts={posts}/>
        </>
     );
}
 
export default Messages;