package com.tcs.problem3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		Path incoming = Paths.get("/home/labuser/Desktop/UseCase 3/Incoming_claims/");
		Path processing = Paths.get("/home/labuser/Desktop/UseCase 3/Processing_Claims/");
		Path processed = Paths.get("/home/labuser/Desktop/UseCase 3/Processed_Claims/");
		Path error = Paths.get("/home/labuser/Desktop/UseCase 3/Error_Claims/");
		Path success = Paths.get("/home/labuser/Desktop/UseCase 3/Success_Claims/");
		
		if (Files.notExists(incoming)) {
            Files.createDirectories(incoming); 
            System.out.println("Folder incoming created");
        } else {
            System.out.println("Folder incoming already exists");
        }
		if (Files.notExists(processing)) {
            Files.createDirectories(processing); 
            System.out.println("Folder processing created");
        } else {
            System.out.println("Folder processing already exists");
        }
		if (Files.notExists(processed)) {
            Files.createDirectories(processed); 
            System.out.println("Folder processed created");
        } else {
            System.out.println("Folder processed already exists");
        }
		if (Files.notExists(error)) {
            Files.createDirectories(error); 
            System.out.println("Folder error created");
        } else {
            System.out.println("Folder error already exists");
        }
		if (Files.notExists(success)) {
            Files.createDirectories(success); 
            System.out.println("Folder success created");
        } else {
            System.out.println("Folder success already exists");
        }
		
		WatchService watchService = FileSystems.getDefault().newWatchService();

		incoming.register(
			    watchService,
			    StandardWatchEventKinds.ENTRY_CREATE
			);

//		processing.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
//		processed.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
//		error.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
//		success.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);

		System.out.println("Watching incoming directory...");

		while (true) {
			WatchKey key = watchService.take(); // blocks

			for (WatchEvent<?> event : key.pollEvents()) {

			    if (event.kind() != StandardWatchEventKinds.ENTRY_CREATE) {
			        continue; // ignore MODIFY, DELETE
			    }

			    Path fileName = (Path) event.context();
			    System.out.println("New file: " + fileName);

			    if (verify(fileName.toString())) {
			        proceedIncomingSuccess(fileName, incoming, processing, processed, success);
			    } else {
			        proceedIncomingFailure(fileName, incoming, error);
			    }
			}

			boolean valid = key.reset();
			if (!valid)
				break;
		}

	}

	private static void proceedIncomingSuccess(Path fileName, Path incoming, Path processing, Path processed, Path success) throws IOException {
		Files.move(incoming.resolve(fileName), processing.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
		Files.move(processing.resolve(fileName), processed.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
		Files.move(processed.resolve(fileName), success.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
		
		
	}
	
	private static void proceedIncomingFailure(Path fileName,Path incoming, Path error) throws IOException {
		Files.move(incoming.resolve(fileName), error.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("File moved successfully to error");
		
	}


	


	private static boolean verify(String string) {
		if(string.startsWith("claim"))return true;
		return false;
	}

}
