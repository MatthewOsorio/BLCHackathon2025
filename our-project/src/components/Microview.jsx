import React, { useState } from 'react';
import './ListingCard.css';

function MicroView() {
  // Hardcoded listings instead of API call
  const listings = [
    { addressLine1: '123 Main St', price: 1200 },
    { addressLine1: '456 Oak St', price: 1500 },
    { addressLine1: '789 Pine St', price: 1100 },
    { addressLine1: '101 Maple St', price: 1300 },
    { addressLine1: '202 Birch St', price: 1400 },
  ];

  const [loading, setLoading] = useState(false); // Keep the loading state for any future use

  return (
    <div className="aptCard">
      <h2>Apartment Listings</h2>
      <div className="listingCard">
        {listings.length > 0 ? (
          listings.map((listing, index) => (
            <div className="listingCards" key={index}>
              <h3>Address: {listing.addressLine1}</h3>
              <p>Matt liked this!</p>
              <div className="priceHeart">
                <p>Price: ${listing.price}</p>
                <button className="heartBtn">♡</button>
              </div>
            </div>
          ))
        ) : (
          <div>No listings available</div>
        )}
      </div>
      {loading && <div>loading</div>}
    </div>
  );
}

export default MicroView;
