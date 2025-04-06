import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import "leaflet/dist/leaflet.css";

import { useState, useEffect } from "react";
import { getListing } from '../services/rentcast_api';

function MyMap() {
  const [listings, setListings] = useState([]); // Ensure it's initialized as an empty array
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null); // State for error handling

  useEffect(() => {
    const getCurrentListing = async () => {
      setLoading(true);
      setError(null); // Reset error on new fetch attempt
      try {
        const newListings = await getListing();
        console.log(newListings); // Log the listings to inspect their structure
        setListings(newListings);
      } catch (error) {
        console.error("Error fetching listings:", error);
        setError("Error fetching listings. Please try again later.");
      } finally {
        setLoading(false);
      }
    };

    getCurrentListing();
  }, []);

  const position = [39.5299, -119.8143]; // Use the dynamic props for map center
  const zoomLevel = 13;
