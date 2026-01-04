package com.tcs.problem3.service;

import java.io.IOException;
import java.nio.file.*;

public class FileMoveService {

	public void move(Path sourceDir, Path targetDir, Path fileName) throws IOException {

		Path source = sourceDir.resolve(fileName);
		Path target = targetDir.resolve(fileName);

		if (Files.notExists(source)) {
			return;
		}

		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
	}
}
