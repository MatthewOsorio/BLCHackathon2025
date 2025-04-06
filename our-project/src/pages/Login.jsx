import NavBar from "../components/NavBar"
import { Link } from 'react-router-dom';

function Login () {
    return (
        <div className = "loginPage">
            <NavBar />
            <div className = "loginBox">
                <h2>Login</h2>
                <input type="email" placeholder= "enter email"/>
                <input type="password" placeholder=" enter password" />
            </div>
            <button className = "submitBtn">
                <Link to = "/question">Submit</Link>
            </button>
        </div>
    );
}

export default Login