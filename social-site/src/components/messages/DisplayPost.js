import { Link } from "react-router-dom";
import DisplayComments from "../comments/DisplayComments";

const DisplayPost = ({posts}) => {
    return (
        posts.map((post)=>(
            <div key={post.id}>
                <h3>{post.title}</h3>
                <p>{post.body}</p>
                <Link to="/messages/comments">Post a Comment</Link>
                <h4>Comments</h4>
                <DisplayComments/>
            </div>
        ))
    );
}

export default DisplayPost;