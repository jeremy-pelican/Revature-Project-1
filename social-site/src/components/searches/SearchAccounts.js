import axios from "axios";
import { useState } from "react";

const SearchAccounts = () => {
    const[search, setSearch] = useState("");
    const searchHandler=(e)=>{
        e.preventDefault();
        axios.get(`http://localhost:8080/search/accounts/${search}`)
        .then((res)=>{
            console.log(res.data);
            alert("Search successful!");
        })
        .catch((error)=>{
            console.log("Search failed");
            alert("Search UNsuccessful!");
        })
    }
    return ( 
        <>
        <form onSubmit={searchHandler}>
            <label>Looking for accounts:</label>
            <input type="text" value={search} onChange={(e)=>setSearch(e.target.value)}/>
            <button type="search">Search</button>
        </form>
        </>
     );
}
 
export default SearchAccounts;