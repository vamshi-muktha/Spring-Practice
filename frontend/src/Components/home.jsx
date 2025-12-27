import React, { useState } from "react";
import { bookTicket, pnrTicket } from "../Service/service";

export default function Home() {
	const [mode, setMode] = useState(null); // 'book' | 'view' | null

	// Book form state
	const [name, setName] = useState("");
	const [tno, setTno] = useState("");
	const [from, setFrom] = useState("");
	const [to, setTo] = useState("");
	const [jdate, setJdate] = useState("");
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
			const payload = { name, tno, from, to , jdate};
			const data = await bookTicket(payload);
			setBookResult(data);
		} catch (err) {
			setBookError(err?.response?.data || err.message || String(err));
		}
	};

	const submitPnr = async (e) => {
		e.preventDefault();
		setPnrResult(null);
		setPnrError(null);

		if (!pnr) {
			setPnrError("Please enter a PNR");
			return;
		}
		const pnrNumber = parseInt(pnr, 10);
		if (Number.isNaN(pnrNumber)) {
			setPnrError("PNR must be a number");
			return;
		}

		try {
			const data = await pnrTicket(pnrNumber);
			console.log(data);
			setPnrResult(data);
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
						<label>Tno: </label>
						<input type="text" value={tno} onChange={(e) => setTno(e.target.value)} required />
					</div>
					<div>
						<label>From: </label>
						<input value={from} onChange={(e) => setFrom(e.target.value)} required />
					</div>
					<div>
						<label>To: </label>
						<input value={to} onChange={(e) => setTo(e.target.value)} required />
					</div>
					<div>
						<label>jdate: </label>
						<input value={jdate} onChange={(e) => setJdate(e.target.value)} required />
					</div>
					<button type="submit">Submit Booking</button>
					{bookResult && (
						<pre style={{padding: 8 }}>{JSON.stringify(bookResult, null, 2)}</pre>
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
						<pre style={{  padding: 8 }}>{JSON.stringify(pnrResult, null, 2)}</pre>
					)}
					{pnrError && <div style={{ color: "red" }}>{String(pnrError)}</div>}
				</form>
			)}
		</>
	);
}