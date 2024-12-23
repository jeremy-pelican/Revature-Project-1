import {useState, useEffect} from 'react';
import axios from "axios";

const PostComment = () => {
    const [comments, setComments]=useState([]);
    useEffect(()=>{
        axios.get("http://localhost/8080/messages/comments")
        .then(res=>{
            console.log(res.data);
            setComments(res.data);
        })
    }, [comments])

    const commentHandler=(e)=>{
        e.preventDefault();
        const comment = document.getElementById('comment');
        axios.post("http://localhost:8080/messages/comments", comment)
        .then((res)=>{
            console.log(res.data);
            setComments((prevComments)=>{return[res.data, ...prevComments]});
        })
    }
    return ( 
        <>
        <form onSubmit={commentHandler}>
            <label>Type your message here</label><br/>
                <textarea id="comment" rows="5" cols="30"></textarea>
            <br/>
            <button type="submit">Post Comment</button>
        </form>
        </>
     );
}
 
export default PostComment;