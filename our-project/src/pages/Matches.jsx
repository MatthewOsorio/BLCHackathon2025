import React, { useState, useRef } from 'react';
import janeDoeImage from '../assets/jane.jpg';
import johnSmith from '../assets/john.jpg';
import sarahBrown from '../assets/sarah.jpg';
import './Matches.css';

const Matches = () => {
  const [cards, setCards] = useState([
    { id: 1, name: 'Jane Doe', bio: 'Software Engineer, 28', image: janeDoeImage },
    { id: 2, name: 'John Smith', bio: 'Designer, 26', image: johnSmith },
    { id: 3, name: 'Sarah Brown', bio: 'Photographer, 30', image: sarahBrown },
  ]);
  

  const [isDragging, setIsDragging] = useState(false);
  const [startX, setStartX] = useState(0);
  const [offsetX, setOffsetX] = useState(0);
  const [rotation, setRotation] = useState(0);
  const cardRef = useRef(null);

  const getRotation = (offset) => {
    return (offset / 10) * 1;
  };

  const handleStart = (clientX) => {
    setIsDragging(true);
    setStartX(clientX);
  };

  const handleMove = (clientX) => {
    if (!isDragging) return;

    const newOffsetX = clientX - startX;
    setOffsetX(newOffsetX);
    setRotation(getRotation(newOffsetX));
  };

  const handleEnd = (card) => {
    setIsDragging(false);

    if (offsetX > 100) {
      handleSwipeRight(card);
    } else if (offsetX < -100) {
      handleSwipeLeft(card);
    }

    setOffsetX(0);
    setRotation(0);
  };

  const handleSwipeLeft = (card) => {
    console.log('Swiped left (dislike):', card);
    removeCard(card.id);
  };

  const handleSwipeRight = (card) => {
    console.log('Swiped right (like):', card);
    removeCard(card.id);
  };

  const removeCard = (id) => {
    setCards(cards.filter((card) => card.id !== id));
  };

  const renderCard = (card) => {
    return (
      <div
        ref={cardRef}
        key={card.id}
        className="matches-card"
        style={{
          transform: `translateX(${offsetX}px) rotate(${rotation}deg)`,
          transition: isDragging ? 'none' : 'transform 0.5s ease',
          position: 'absolute',
          cursor: isDragging ? 'grabbing' : 'grab',
        }}
        onMouseDown={(e) => handleStart(e.clientX)}
        onMouseMove={(e) => handleMove(e.clientX)}
        onMouseUp={() => handleEnd(card)}
        onMouseLeave={() => handleEnd(card)}
        onTouchStart={(e) => handleStart(e.touches[0].clientX)}
        onTouchMove={(e) => handleMove(e.touches[0].clientX)}
        onTouchEnd={() => handleEnd(card)}
      >

        <div className="card-content">
          <img src={card.image} alt={card.name} className="card-image" />
          <div className="card-info">
            <h2>{card.name}</h2>
            <p>{card.bio}</p>
          </div>
        </div>

        {offsetX > 50 && (
          <div className="swipe-indicator right">LIKE</div>
        )}
        {offsetX < -50 && (
          <div className="swipe-indicator left">NOPE</div>
        )}
      </div>
    );
  };

  return (
    <div className="matches-container">
      {cards.map((card) => renderCard(card))}

      <div className="swipe-buttons">
        <button
          onClick={() => cards.length > 0 && handleSwipeLeft(cards[cards.length - 1])}
          className="swipe-button dislike"
        >
          ✕
        </button>
        <button
          onClick={() => cards.length > 0 && handleSwipeRight(cards[cards.length - 1])}
          className="swipe-button like"
        >
          ♥
        </button>
      </div>
    </div>
  );
};

export default Matches;

