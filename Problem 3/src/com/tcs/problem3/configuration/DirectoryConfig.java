package com.tcs.problem3.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryConfig {
	private final Path root;
	private final Path incoming;
	private final Path processing;
	private final Path processed;
	private final Path success;
	private final Path error;
	private final Path logFile;

	public DirectoryConfig() throws IOException {

//	    this.root = Paths.get("/home/labuser/Desktop/UseCase 3");
		this.root = Paths.get("C:\\Users\\mukth\\Documents\\UseCase 3");
		this.incoming = root.resolve("Incoming_claims");
		this.processing = root.resolve("Processing_Claims");
		this.processed = root.resolve("Processed_Claims");
		this.success = root.resolve("Success_Claims");
		this.error = root.resolve("Error_Claims");
		this.logFile = root.resolve("usecase3.log");

		createDirectories();
	}

	private void createDirectories() throws IOException {
		Files.createDirectories(incoming);
		Files.createDirectories(processing);
		Files.createDirectories(processed);
		Files.createDirectories(success);
		Files.createDirectories(error);
		if (Files.notExists(logFile)) {
			Files.createFile(logFile);
		}
	}

	public Path getRoot() {
		return root;
	}

	public Path getIncoming() {
		return incoming;
	}

	public Path getProcessing() {
		return processing;
	}

	public Path getProcessed() {
		return processed;
	}

	public Path getSuccess() {
		return success;
	}

	public Path getError() {
		return error;
	}

	public Path getLogFile() {
		return logFile;
	}

}
