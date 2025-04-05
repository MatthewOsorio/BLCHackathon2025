import React, { useState, useEffect, use } from 'react';
import { getListing } from '../services/rentcast_api';


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
    <div>
      <h2>Apartment Listings</h2>
      {listings && (
        <ul>
          {listings.map((listing, index) => (
            <li key={index}>
              <h3>{listing.addressLine1}</h3>
              <p>Price: {listing.price}</p>
            </li>
          ))}
        </ul>
      )}

      {loading && <div>loading</div>}
    </div>
  );
}

export default MicroView;
