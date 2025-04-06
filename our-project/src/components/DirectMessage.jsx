import { useState } from 'react';
import './DirectMessage.css';


function ChatMessage({ message, isCurrentUser }) {
    const messageClass = isCurrentUser ? 'my-message' : 'other-message'; // Change class based on sender
    return (
        <div className={`message ${messageClass}`}>
            <p>{message.text}</p>
        </div>
    );
}


function DirectMessage({ user }) {
    const [messages, setMessages] = useState([
        { id: 1, text: 'Hello, how are you?', uid: 'user1' },
        { id: 2, text: 'I am good, thanks! How about you?', uid: 'user2' },
        { id: 3, text: 'I am doing great, working on a project.', uid: 'user1' },
        { id: 4, text: 'That sounds awesome!', uid: 'user2' },
    ]);

    const currentUserUid = 'user1'; 

    return (
        <div className="directMessage">
            <h2>Direct Messages</h2>
            <div className = "chatBox">
                <section>
                    {user ? (
                        <div className="chat-room">
                            {messages.map((msg) => {
                                const isCurrentUser = msg.uid === currentUserUid;
                                return <ChatMessage key={msg.id} message={msg} isCurrentUser={isCurrentUser} />;
                            })}
                        </div>
                    ) : (
                        <div className="no-friends">
                            <p>No Friends</p>
                        </div>
                    )}
                </section>
                <div className="message-input">
                    <input type="text" placeholder="Type a message..." />
                    <button>Send</button>
                </div>
            </div>
        </div>
    );
}

export default DirectMessage;
