import React, { useState } from "react";
import { bookTicket, pnrTicket } from "../Service/service";

export default function Home() {
	const [mode, setMode] = useState(null); // 'book' | 'view' | null

	// Book form state
	const [name, setName] = useState("");
	const [age, setAge] = useState("");
	const [from, setFrom] = useState("");
	const [to, setTo] = useState("");
	const [bookResult, setBookResult] = useState(null);
	const [bookError, setBookError] = useState(null);

	// View (PNR) state
	const [pnr, setPnr] = useState("");
	const [pnrResult, setPnrResult] = useState(null);
	const [pnrError, setPnrError] = useState(null);

	const submitBook = async (e) => {
		e.preventDefault();
		setBookResult(null);
		setBookError(null);
		try {
			const payload = { name, age, from, to };
			const resp = await bookTicket(payload);
			setBookResult(resp.data || resp);
		} catch (err) {
			setBookError(err?.response?.data || err.message || String(err));
		}
	};

	const submitPnr = async (e) => {
		e.preventDefault();
		setPnrResult(null);
		setPnrError(null);
		try {
			const resp = await pnrTicket(pnr);
			setPnrResult(resp.data || resp);
		} catch (err) {
			setPnrError(err?.response?.data || err.message || String(err));
		}
	};

	return (
		<>
			<div style={{ marginBottom: 12 }}>
				<button onClick={() => setMode("book")}>Book Ticket</button>
				<button onClick={() => setMode("view")} style={{ marginLeft: 8 }}>
					View Ticket
				</button>
				<button onClick={() => setMode(null)} style={{ marginLeft: 8 }}>
					Close
				</button>
			</div>

			{mode === "book" && (
				<form onSubmit={submitBook} style={{ maxWidth: 420 }}>
					<div>
						<label>Name: </label>
						<input value={name} onChange={(e) => setName(e.target.value)} required />
					</div>
					<div>
						<label>Age: </label>
						<input type="number" value={age} onChange={(e) => setAge(e.target.value)} required />
					</div>
					<div>
						<label>From: </label>
						<input value={from} onChange={(e) => setFrom(e.target.value)} required />
					</div>
					<div>
						<label>To: </label>
						<input value={to} onChange={(e) => setTo(e.target.value)} required />
					</div>
					<button type="submit">Submit Booking</button>
					{bookResult && (
						<pre style={{ background: "#f6f6f6", padding: 8 }}>{JSON.stringify(bookResult, null, 2)}</pre>
					)}
					{bookError && <div style={{ color: "red" }}>{String(bookError)}</div>}
				</form>
			)}

			{mode === "view" && (
				<form onSubmit={submitPnr} style={{ maxWidth: 420 }}>
					<div>
						<label>PNR: </label>
						<input value={pnr} onChange={(e) => setPnr(e.target.value)} required />
					</div>
					<button type="submit">Get Ticket</button>
					{pnrResult && (
						<pre style={{ background: "#f6f6f6", padding: 8 }}>{JSON.stringify(pnrResult, null, 2)}</pre>
					)}
					{pnrError && <div style={{ color: "red" }}>{String(pnrError)}</div>}
				</form>
			)}
		</>
	);
}