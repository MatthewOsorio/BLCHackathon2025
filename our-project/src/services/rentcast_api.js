const BASE_URL = "https://api.rentcast.io/v1/listings/rental/long-term"
//const RENTAL_API_KEY = import.meta.env.VITE_RENTAL_API_KEY

export const getListing = async() => {
    console.log(RENTAL_API_KEY);
    const url = `${BASE_URL}?city=Reno&state=NV&status=Active&limit=5`;
    const response = await fetch(url, {
        method: "GET",
        headers:{
            'X-Api-Key': RENTAL_API_KEY,
            Accept: "application/json"
        }
    });

    const data = await response.json()
    console.log(data)
    return data
};