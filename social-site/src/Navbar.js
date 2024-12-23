import {Link} from 'react-router-dom';

const Navbar = () => {
    return ( 
        <div className="navbar">
            <h1>Socialer</h1>
            <div className="links"> 
                <Link to="/home">Home</Link>
                <Link to="/login">Login</Link>
                <Link to="/messages">Messages</Link>
                <Link to="/search">Search</Link>
            </div>
        </div>
     );
}
 
export default Navbar;