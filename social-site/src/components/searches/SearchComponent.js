import { Link } from "react-router-dom";

const SearchComponent = () => {
    return ( 
        <>
        <h2>What would you like to search for?</h2>
        <hr/>
        <Link to="/search/accounts">
            <button>Search for Accounts</button>
        </Link>
        <Link to="/search/messages">
            <button>Search for Messages</button>
        </Link>
        </>
     );
}
 
export default SearchComponent;