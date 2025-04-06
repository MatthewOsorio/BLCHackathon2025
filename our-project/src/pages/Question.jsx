import React, { useState } from "react"; 
import { Link } from "react-router-dom";
import './Question.css';

function Question () {
    const [questionCounter, setQuestionCounter] = useState(1);
    const [q1Input, setq1Input] = useState('');
    const [q2Input, setq2Input] = useState(''); 
    const [q3Input, setq3Input] = useState(''); 
    const [q4Input, setq4Input] = useState(''); 
    const [q5Input, setq5Input] = useState('');  


   
    const handleChange1 = (event) => {
        setq1Input(event.target.value); 
    };
    const handleChange2 = (event) => {
        setq2Input(event.target.value); 
    };
    const handleChange3 = (event) => {
        setq3Input(event.target.value); 
    };
    const handleChange4 = (event) => {
        setq4Input(event.target.value); 
    };
    const handleChange5 = (event) => {
        setq5Input(event.target.value); 
    };

    const increment = () => {
        setQuestionCounter(questionCounter + 1);
    }

    let displayQuestion = '';

    return (
        <div>
            {questionCounter === 1 && (
                <div className="q1">
                    <p className = "questions">1. What does a "clean" space mean to you, and whats your threshold before something feels messy or unlivable? </p>  
                    <input className = "inputs" 
                        type="text"
                        value={q1Input}
                        onChange={handleChange1}
                        placeholder="Enter something"
                    />
                </div>
            )} 

            {questionCounter === 2 && (
                <div>
                    <p className = "questions">2. When you're overwhelmed or stressed, how does that usually show up in your space or behavior at home? </p>  
                    <input className = "inputs" 
                        type="text"
                        value={q2Input}
                        onChange={handleChange2}
                        placeholder="Enter something"
                    />
                </div>
            )} 

            {questionCounter === 3 && (
                <div>
                    <p className = "questions"> 3. When you're annoyed about something small a roommate does, how do you usually bring it up-or do you let it slide? </p>
                        <input  className = "inputs" 
                        type="text"
                        value={q3Input}
                        onChange={handleChange3}
                        placeholder="Enter something"
                    />
                </div>
            )}

            {questionCounter === 4 && (
                <div>
                    <p className = "questions">  4. What's a past roommate conflict you've had, and how did you handle it? </p>
                        <input  className = "inputs" 
                        type="text"
                        value={q4Input}
                        onChange={handleChange4}
                        placeholder="Enter something"
                    />
                </div>
            )}

            {questionCounter === 5 && (
                <div>
                    <p className = "questions"> 5. What are your non-negotiables in a roommate situation? What's something small that ended up being a big deal for you in the past? </p>
                        <input  className = "inputs" 
                        type="text"
                        value={q5Input}
                        onChange={handleChange5}
                        placeholder="Enter something"
                    />
                </div>
            )}
            
            <div className = "nextBtn">
                {questionCounter < 5 && (
                    <button onClick={increment}>Next Question</button>
                )}
                {questionCounter === 5 && (
                    //<button onClick={increment}>Done</button>
                    <Link to = "/userHomepage">Submit</Link>
                )}
            </div>

        </div>
       
    );
}

export default Question