import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/";

class AuthService {
    login(credentials) {
        return axios.post(`${API_BASE_URL}/login`, credentials);
    }
    register(credentials) {
        return axios.post(`${API_BASE_URL}/register`, credentials)
    }
}

export default new AuthService();