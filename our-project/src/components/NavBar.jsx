import { Link, useLocation } from "react-router-dom";
import React, { useState } from "react"; 
import './NavBar.css';

function NavBar() {
    const [isAuthenticated, setAuthenticated] = useState(true);
    
    // Hook to get current location (page URL)
    const location = useLocation();
    
    const toggleAuthentication = () => {
        setAuthenticated(!isAuthenticated);
    };

    // Conditionally render navbar content based on authentication state
    let navBarContent;
    if (isAuthenticated) {
        // User is authenticated
        navBarContent = (
            <nav className="navBar">
                <div className="navbar-left">
                    <Link to="/" className="nav-link"><h3>ROOMIFY</h3></Link>
                </div>
                <div className="navbar-links">
                    <Link to="/" className="nav-link">Home</Link>
                    <Link to="/matches" className="nav-link">Matches</Link>
                    <Link to="/userHomepage" className="nav-link">User Homepage</Link>
                    {/* Add more links as per the authenticated user */}
                    <button onClick={toggleAuthentication}>
                        <Link to="/login" className="nav-link">Logout</Link>
                    </button>
                </div>
            </nav>
        );
    } else {
        // User is not authenticated
        navBarContent = (
            <nav className="navBar">
                <div className="navbar-left">
                    <Link to="/" className="nav-link">Roomify</Link>
                </div>
                <div className="navbar-links">
                    <Link to="/matches" className="nav-link">Matches</Link>
                    <Link to="/signup" className="nav-link">Profile</Link>
                    <button onClick={toggleAuthentication}>Login</button>
                </div>
            </nav>
        );
    }

    // Render navbar content conditionally based on the current page
    if (location.pathname === "/userHomepage" || location.pathname === "/matches") {
        return (
            <nav className="navBar">
                <div className="navbar-left">
                    <Link to="/" className="nav-link"><h3>ROOMIFY</h3></Link>
                </div>
                <div className="navbar-links">
                    <Link to="/matches" className="nav-link">Matches</Link>
                    <Link to="/userHomepage" className="nav-link">User Homepage</Link>
                    <button onClick={toggleAuthentication}>
                        <Link to="/login" className="nav-link">Logout</Link>
                    </button>
                </div>
            </nav>
        );
    }

    return <div>{navBarContent}</div>;
}

export default NavBar;
