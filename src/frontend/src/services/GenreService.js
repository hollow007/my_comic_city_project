import axios from 'axios';

const API_URL = 'http://localhost:8080/comiccity/genres';

export const create = (genre) => {
    return axios.post(`${API_URL}/create`, genre);
};

export const geGenre = (id) => {
    return axios.get(`${API_URL}/read/${id}`);
};

export const update = (genre) => {
    return axios.post(`${API_URL}/update`, genre);
};

export const deleteGenre = (id) => {
    return axios.delete(`${API_URL}/delete/${id}`);
};
export const getAllGenre = () => {
    return axios.get(`${API_URL}/getAll`);
};
