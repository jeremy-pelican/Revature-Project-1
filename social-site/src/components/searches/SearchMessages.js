import axios from "axios";
import {useState} from "react";
import DisplayPost from "../messages/DisplayPost";

const SearchMessages = () => {
    const[search, setSearch] = useState("");
    const searchHandler=(e)=>{
        e.preventDefault();
        axios.get(`http://localhost:8080/search/accounts/${search}`)
        .then((res)=>{
            console.log(res.data);
            alert("Search successful!");
            <DisplayPost posts={res.data}/>
        })
        .catch((error)=>{
            console.log("Search failed");
            alert("Search UNsuccessful!");
        })
    }
    return ( 
        <>
        <form onSubmit={searchHandler}>
            <label>Looking for messages:</label>
            <input type="text" value={search} onChange={(e)=>setSearch(e.target.value)}/>
            <button type="search">Search</button>
        </form>
        </>
     );
}
 
export default SearchMessages;