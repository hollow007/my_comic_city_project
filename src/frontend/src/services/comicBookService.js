import axios from 'axios';

const API_URL = 'http://localhost:8080/comiccity/comic_book'; // Adjust the base URL as needed

export const createComicBook = (comicBook) => {
    return axios.post(`${API_URL}/create`, comicBook);
};

export const getComicBook = (sku) => {
    return axios.get(`${API_URL}/read/${sku}`);
};

export const updateComicBook = (comicBook) => {
    return axios.post(`${API_URL}/update`, comicBook);
};

export const deleteComicBook = (sku) => {
    return axios.delete(`${API_URL}/delete/${sku}`);
};

export const getAllComicBooks = () => {
    return axios.get(`${API_URL}/getAll`);
};
export const searchComicBooksByName = (name) => {
    return axios.get(`${API_URL}/search/name/${name}`);
};
export const getBooksByPlublisher= (publisher) => {
    return axios.get(`${API_URL}/filter/publisher/${publisher}`);
};
export const getBooksByPriceLessThanEqual= (price) => {
    return axios.get(`${API_URL}/filter/price/${price}`);

};
export const getBooksByGenres = (genres) => {
    const params = new URLSearchParams();
    genres.forEach(genre => params.append('genres', genre));

    return axios.get(`${API_URL}/search/genres`, { params });
};

export const getBooksByDateInBetween= (fromDate,toDate) => {
    return axios.get(`${API_URL}/search/releaseDates/${fromDate}/${toDate}`);

};
