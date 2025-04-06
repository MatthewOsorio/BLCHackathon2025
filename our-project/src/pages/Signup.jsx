import NavBar from "../components/NavBar"
import { Link } from 'react-router-dom';
import './Signup.css'

function SignUp () {
    return (
        <div className = "signupPage">
            <NavBar />
            <div className = "signupBox">
                <h2>Welcome!</h2>
                <input type= "text" placeholder = "enter your name here" />
                <div className="email-container">
                <input type="email" placeholder= "enter email"/>
                <span className="info-icon" data-tooltip="Must be a school email.">?</span>
                </div>
                <input type="password" placeholder=" enter password" />
                <div className="signin-link">
                <div>Already have an account? <Link to="/signin">Click here to sign in.</Link></div>
                </div>
            </div>
            <button className = "submitBtn">
                <Link to = "/question">Submit</Link>
            </button>
        </div>
    );
}

export default SignUp