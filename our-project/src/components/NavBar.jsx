import { Link } from "react-router-dom";
import React, { useState } from "react"; 
import './NavBar.css';

function NavBar() {
    const [isAuthenticated, setAuthenticated] = useState(true);
    
    const toggleAuthentication = () => {
        setAuthenticated(!isAuthenticated);
    };

    let navBarContent;
    if (isAuthenticated) {
        navBarContent = (
            <nav className="navBar">
                <div className="navbar-left">
                    <Link to="/" className="nav-link"><h3>ROOMIFY</h3></Link>
                </div>
                <div className="navbar-links">
                    <Link to="/" className="nav-link">Home</Link>
                    <button onClick={toggleAuthentication}>
                        <Link to="/login" className="nav-link">Login</Link>
                    </button>
                    
                </div>
            </nav>
        );
    } else {
        navBarContent = (
            <nav className="navBar">
                <div className="navbar-left">
                    <Link to="/" className="nav-link">Roomify</Link>
                </div>
                <div className="navbar-links">
                    <Link to="/matches" className="nav-link">Matches</Link>
                    <Link to="/signup" className="nav-link">Profile</Link>
                    <button>Notifications</button>
                </div>
            </nav>
        );
    }

    return <div>{navBarContent}</div>;
}

export default NavBar;
