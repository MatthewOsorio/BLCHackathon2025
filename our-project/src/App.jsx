import { Route, Routes } from 'react-router-dom';
import './App.css'
import Homepage from './pages/homepage';
import Signup from './pages/signup';
import Question from './pages/Question';
import UserHomepage from './pages/userHomepage';
import Login from './pages/Login'

function App() {

  return (
      <Routes>
        <Route path = '/' element={<Homepage />}/>
        <Route path = '/signup' element={<Signup />}/> 
        <Route path = '/question' element={<Question />}/> 
        <Route path = '/userHomepage' element={<UserHomepage />}/> 
        <Route path = '/Login' element={<Login />}/> 
      </Routes>
  );
}

export default App
