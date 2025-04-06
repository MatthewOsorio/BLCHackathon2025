import { Link } from 'react-router-dom';
import homepageImage from '../assets/house.png';
import NavBar from '../components/NavBar';
import './Homepage.css'; 

function Homepage() {
    console.log("test");
    return (
        <div className="homepage">
            <NavBar />
            <div className="roomify-header">
                <h1>ROOMIFY</h1>           
                
            </div>
            <img src={homepageImage} alt="Homepage Image" />
            <div>
            <p>A fun way to find roommates who are also students</p>
            </div>
            <button className="signupbtn">
                <Link to="/signup" className="nav-link">Sign Up</Link>
            </button>
        </div>
    );
}

export default Homepage;
