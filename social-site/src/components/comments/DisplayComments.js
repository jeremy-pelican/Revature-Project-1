import {useState, useEffect} from 'react';
import axios from "axios";

const DisplayComments = ({replyTo}) => {
    const[comments, setComments]=useState([]);
    axios.get(`http://localhost:8080/messages/${replyTo}/comments`)
    .then(res=>{
        setComments(res.data)
    })
    .catch((error)=>{
        console.log("Failed to retrieve comments")
    })

    return ( 
        comments.map((comment)=>(
            <div key={comment.commentId}>
                <h5>{comment.sentBy}</h5>
                <p>{comment.commentText}</p>
            </div>
        ))
     );
}
 
export default DisplayComments;