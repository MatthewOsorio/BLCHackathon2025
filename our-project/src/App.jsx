import { Route, Routes } from 'react-router-dom';
import './App.css'
import Homepage from './pages/homepage';
import Signup from './pages/Signup';
import Question from './pages/Question';
import UserHomepage from './pages/userHomepage';
import Matches from './pages/matches';

function App() {

  return (
      <Routes>
        <Route path = '/' element={<Homepage />}/>
        <Route path = '/signup' element={<Signup />}/> 
        <Route path = '/question' element={<Question />}/> 
        <Route path = '/userHomepage' element={<UserHomepage />}/>
        <Route path = '/userHomepage' element={<UserHomepage />}/>
        <Route path = '/matches' element={<Matches />}/>
      </Routes>
  );
}

export default App
