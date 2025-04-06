import React, { useState, useEffect, use } from 'react';
import { getListing } from '../services/rentcast_api';
import './ListingCard.css'

function MicroView() {
  const [listings, setListings] = useState([]); // Ensure it's initialized as an empty array
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    const getCurrentListing = async() =>{
        setLoading(true)
        const newListings = await getListing();
        console.log(newListings)
        setListings(newListings)
        setLoading(false)
    }

    getCurrentListing();
  }, []); // Empty dependency array ensures this runs only once

  useEffect(()=>{console.log(listings)}, [listings])
  return (
    <div className = "aptCard">
      <h2>Apartment Listings</h2>
        <div className = "listingCard">
            {listings && (
              
              listings.map((listing, index) => (
                <div className = "listingCards"key={index}>
                  <h3>Address: {listing.addressLine1}</h3>
                  <div className = "priceHeart">
                    <p>Price: ${listing.price}</p>
                    <button>♡</button>
                  </div>
                </div>
              ))
          )}
        </div>
      {loading && <div>loading</div>}
    </div>
  );
}

export default MicroView;
