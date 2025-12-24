import axios from "axios";

const BASE = "http://localhost:8084/irctc";
export let bookTicket = (payload) => axios.post(`${BASE}/book`, payload);
export let pnrTicket = (pnr) => axios.get(`${BASE}/get?q=${pnr || ""}`);