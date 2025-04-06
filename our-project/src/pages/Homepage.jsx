import { Link } from 'react-router-dom';
import homepageImage from '../assets/homepage_image.jpg';
import NavBar from '../components/NavBar';


function Homepage() {
    console.log("test")
    return <div className = "homepage">
        <NavBar/>
        <img src = {homepageImage} alt = "Homepage Image"/>
        <div>
            <p>Insert team name here</p>
        </div>
        <div>
            <p>A fun way to find roommates who are also students</p>
        </div>
        <button className = "signupbtn">
            <Link to = "/signup" className = "nav-link">Sign Up</Link>
        </button>     
    </div>
}

export default Homepage