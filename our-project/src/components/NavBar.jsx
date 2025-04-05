import { Link } from "react-router-dom";
import React, { useState } from "react"; 

function NavBar (){
    const [isAuthenticated, setAuthenticated] = useState(true);
    
    const authenticatedNavBar = () => {

        setAuthenticated(!isAuthenticated);
    };

    console.log("test")
    let navBarContent;
    if (isAuthenticated) {
        navBarContent = (<nav className = "navBar">
            <div className = "navbar-brand">
                <Link to = "/" className = "nav-link">Team Name</Link>
            </div>
            <div className = "navbar-links">
                <Link to = "/" className = "nav-link">Home</Link>
                <Link to = "/login" className="nav-link">Login</Link>
            </div>
        </nav>
        );
    }else {
        navBarContent = (<nav className = "navBar">
            <div className = "navbar-brand">
                <Link to = "/" className = "nav-link">Team Name</Link>
            </div>
            <div className = "navbar-links">
                <Link to = "/matches" className = "nav-link">Matches</Link>
                <Link to = "/signup" className="nav-link">Profile</Link>
                <button>Messages</button>
                <button>Notifications</button>
            </div>
        </nav>
        );
    }

    return <div>{navBarContent}</div>;
}

export default NavBar