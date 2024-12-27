import { Link } from "react-router-dom";
import DisplayComments from "../comments/DisplayComments";

const DisplayPost = ({posts}) => {
    return (
        posts.map((post)=>(
            <div key={post.messageId}>
                <h3>{post.postedBy}</h3>
                <p>{post.messageText}</p>
                <Link to="/messages/comments">Post a Comment</Link>
                <h4>Comments</h4>
                <DisplayComments replyTo={post.messageId}/>
            </div>
        ))
    );
}

export default DisplayPost;