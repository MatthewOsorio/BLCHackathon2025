import { Route, Routes } from 'react-router-dom';
import './App.css'
import Homepage from './pages/homepage';
import Signup from './pages/Signup';
import Question from './pages/Question';
import UserHomepage from './pages/userHomepage';
<<<<<<< HEAD
import Matches from './pages/matches';
=======
import Login from './pages/Login'
>>>>>>> refs/remotes/origin/main

function App() {

  return (
      <Routes>
        <Route path = '/' element={<Homepage />}/>
        <Route path = '/signup' element={<Signup />}/> 
        <Route path = '/question' element={<Question />}/> 
<<<<<<< HEAD
        <Route path = '/userHomepage' element={<UserHomepage />}/>
        <Route path = '/userHomepage' element={<UserHomepage />}/>
        <Route path = '/matches' element={<Matches />}/>
=======
        <Route path = '/userHomepage' element={<UserHomepage />}/> 
        <Route path = '/Login' element={<Login />}/> 
>>>>>>> refs/remotes/origin/main
      </Routes>
  );
}

export default App
