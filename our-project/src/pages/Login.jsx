import NavBar from "../components/NavBar"
import { Link } from 'react-router-dom';
import './Signup.css'

function Login () {
    return (
        <div className = "signupPage">
            <NavBar />
            <div className = "signupBox">
                <h2>Login</h2>
                <div className="email-container">
                    <input type="email" placeholder= "enter email"/>
                </div>
                <input type="password" placeholder=" enter password" />
            </div>
            <button className = "submitBtn">
                <Link to = "/question">Submit</Link>
            </button>
        </div>
    );
}

export default Login

