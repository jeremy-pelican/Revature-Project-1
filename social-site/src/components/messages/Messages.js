import {useState, useEffect} from 'react';
import axios from "axios";
import DisplayPost from './DisplayPost';

const Messages = () => {
    const[posts, setPosts]=useState([]);
    useEffect(()=>{
        axios.get("http://localhost/8080/messages")
        .then(res=>{
            setPosts(res.data)
        })
    }, [posts])
    return ( 
        <>
        <DisplayPost posts={posts}/>
        </>
     );
}
 
export default Messages;