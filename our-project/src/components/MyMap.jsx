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

  return (
    <div>
      {loading && <div>Loading...</div>} {/* Loading state indication */}
      {error && <div style={{ color: "red" }}>{error}</div>} {/* Display error message */}
      
      <MapContainer className="mapContainer" center={position} zoom={zoomLevel} style={{ height: '500px', width: '100%' }}>
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        {/* Render a Marker for each listing */}
        {listings.map((listing, index) => {
          const lat = listing.latitude;
          const lng = listing.longitude;

          // Check if latitude and longitude are valid
          if (lat && lng) {
            return (
              <Marker key={index} position={[lat, lng]}>
                <Popup>
                  <div>
                    <h4>{listing.title}</h4>
                    <p>{listing.description}</p>
                  </div>
                </Popup>
              </Marker>
            );
          }
          return null; // Skip rendering the marker if lat/lng are invalid
        })}
      </MapContainer>
    </div>
  );
}

export default MyMap;
