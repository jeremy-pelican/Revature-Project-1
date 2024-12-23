import axios from "axios";

const PostMessage = ({posts, setPosts}) => {
    const postHandler=(e)=>{
        e.preventDefault();
        const message = document.getElementById('message');
        axios.post("http://localhost:8080/messages", message)
        .then((res)=>{
            setPosts((prevPosts)=>{return[res.data, ...prevPosts]});
        })
    }
    return ( 
        <>
        <form onSubmit={postHandler}>
            <label>Type your message here</label><br/>
                <textarea id="message" rows="5" cols="30"></textarea>
            <br/>
            <button type="submit">Post Message</button>
        </form>
        </>
     );
}
 
export default PostMessage;