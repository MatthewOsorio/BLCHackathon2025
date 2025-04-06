import React from 'react';
import { APIProvider, Map } from '@vis.gl/react-google-maps';

const apiKey = import.meta.env.VITE_GOOGLE_MAPS_API_KEY;

const MyMap = () => {
  const handleCameraChanged = (event) => {
    console.log('Camera change event:', event);
    console.log('Camera center:', event.detail ? event.detail.center : event.center);
    console.log('Zoom level:', event.detail ? event.detail.zoom : event.zoom);
  };
  console.log(apiKey)

  return (
    <APIProvider apiKey={apiKey} onLoad={() => console.log('Maps API has loaded.')}>
      <Map
        defaultZoom={13}
        defaultCenter={{ lat: -33.860664, lng: 151.208138 }}
        onCameraChanged={handleCameraChanged}
      />
    </APIProvider>
  );
};

export default MyMap;
