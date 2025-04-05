import React, { useState, useEffect } from 'react';
import { getListing } from '../services/rentcast_api';
function MicroView() {
  const [listings, setListings] = useState([]); // Ensure it's initialized as an empty array

  useEffect(() => {
    const getCurrentListing = async() =>{
        const newListings = await getListing();
        setListings(newListings)
    }

    getCurrentListing();
  }, []); // Empty dependency array ensures this runs only once

  return (
    <div>
      <h2>Apartment Listings</h2>
      {listings.length > 0 ? (
        <ul>
          {listings.map((listing, index) => (
            <li key={index}>
              <h3>{listing.addressLine1}</h3>
              <p>Price: {listing.price}</p>
            </li>
          ))}
        </ul>
      ) : (
        <p>No listings found.</p> // If listings are empty
      )}
    </div>
  );
}

export default MicroView;
