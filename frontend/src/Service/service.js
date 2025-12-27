import axios from "axios";

const BASE = "http://localhost:8084/irctc";
export let bookTicket = (payload) => axios.post(`${BASE}/book`, payload).then(res => res.data);
export let pnrTicket = (pnr) => axios.get(`${BASE}/get?pnr=${pnr || ""}`).then(res => { console.log('pnr axios response:', res); return res.data; });