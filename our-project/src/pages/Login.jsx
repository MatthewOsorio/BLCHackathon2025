import NavBar from "../components/NavBar"
import { Link } from 'react-router-dom';

function Login () {
    return (
<<<<<<< HEAD
        <div>
            
=======
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
>>>>>>> refs/remotes/origin/main
        </div>
    );
}

export default Login