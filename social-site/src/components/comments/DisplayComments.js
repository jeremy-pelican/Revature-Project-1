const DisplayComments = ({comments}) => {
    return ( 
        comments.map((comment)=>(
            <div key={comment.id}>
                <h5>{comment.title}</h5>
                <p>{comment.body}</p>
            </div>
        ))
     );
}
 
export default DisplayComments;