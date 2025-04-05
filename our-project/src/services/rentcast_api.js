const API_KEY = '22ac3881668d44dfbbff3cd33ab5e3f2';
const BASE_URL = "https://api.rentcast.io/v1/listings/rental/long-term"

export const getListing = async() => {
    console.log(API_KEY)
    const url = `${BASE_URL}?city=Reno&state=NV&status=Active&limit=5`;
    const response = await fetch(url, {
        method: "GET",
        headers:{
            'X-Api-Key': API_KEY,
            Accept: "application/json"
        }
    });

    const data = await response.json()
    console.log(data)
};