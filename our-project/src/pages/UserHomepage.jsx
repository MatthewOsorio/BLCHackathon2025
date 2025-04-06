import NavBar from '../components/NavBar';
import MicroView from '../components/microview';
import MyMap from '../components/MyMap';
import DirectMessage from '../components/DirectMessage';
import './UserHomepage.css';

function UserHomepage () {
    return (
        <div>
            <NavBar />
            <div className="homepage-container">
                <MicroView />
                <MyMap />
                <DirectMessage />
            </div>
        </div>
    );
}

export default UserHomepage 
