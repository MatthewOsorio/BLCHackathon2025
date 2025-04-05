import NavBar from "../components/NavBar"
import { Link } from 'react-router-dom';

function SignUp () {
    return (
        <div className = "signupPage">
            <NavBar />
            <div className = "signupBox">
                <h2>Welcome!</h2>
                <input type= "text" placeholder = "enter your name here" />
                <input type="email" placeholder= "enter email"/>
                <input type="password" placeholder=" enter password" />
            </div>
            <button className = "submitBtn">
                <Link to = "/question">Submit</Link>
            </button>
        </div>
    );
}

export default SignUp