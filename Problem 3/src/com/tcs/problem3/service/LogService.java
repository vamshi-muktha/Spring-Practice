package com.tcs.problem3.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class LogService {

	private final Path logFile;

	public LogService(Path logFile) {
		this.logFile = logFile;
	}

	public void info(String message) {
		write("INFO", message);
	}

	public void error(String message) {
		write("ERROR", message);
	}

	private void write(String level, String message) {
		String logLine = LocalDateTime.now() + " | " + level + " | " + message + System.lineSeparator();

		try {
			Files.write(logFile, logLine.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
