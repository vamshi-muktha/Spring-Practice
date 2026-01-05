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
		Path logFile = Paths.get("/home/labuser/Desktop/UseCase 3/").resolve("logs");
		
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
			    StandardWatchEventKinds.ENTRY_CREATE,
			    StandardWatchEventKinds.ENTRY_MODIFY,
			    StandardWatchEventKinds.ENTRY_DELETE
			);

//		processing.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
//		processed.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
//		error.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
//		success.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
//				StandardWatchEventKinds.ENTRY_DELETE);
		WatchService watchService2 = FileSystems.getDefault().newWatchService();

		Path rootDir = Paths.get("/home/labuser/Desktop/UseCase 3");
		rootDir .register(
		    watchService,
		    StandardWatchEventKinds.ENTRY_CREATE,
		    StandardWatchEventKinds.ENTRY_MODIFY,
		    StandardWatchEventKinds.ENTRY_DELETE
		);

		System.out.println("Watching UseCase 3 directory...");

		System.out.println("Watching incoming directory...");

//		while (true) {
//			WatchKey key = watchService.take(); // blocks
//
//			for (WatchEvent<?> event : key.pollEvents()) {
//
//			    if (event.kind() != StandardWatchEventKinds.ENTRY_CREATE) {
//			        continue; // ignore MODIFY, DELETE
//			    }
//
//			    Path fileName = (Path) event.context();
//			    System.out.println("New file: " + fileName);
//			    
//			    
//			    
//			    if (verify(fileName.toString())) {
//			        proceedIncomingSuccess(fileName, incoming, processing, processed, success);
//			    } else {
//			        proceedIncomingFailure(fileName, incoming, error);
//			    }
//			}
//
//			boolean valid = key.reset();
//			if (!valid)
//				break;
//		}
		
		while (true) {
		    WatchKey key = watchService.take(); // blocks

		    for (WatchEvent<?> event : key.pollEvents()) {

		        if (event.kind() != StandardWatchEventKinds.ENTRY_CREATE) {
		            continue;
		        }

		        Path fileName = (Path) event.context();

		        if (fileName.toString().equals("logs")) {
		            continue;
		        }

		        System.out.println("New file: " + fileName);

		        log(logFile, "ENTRY_CREATE : " + fileName);

		        if (verify(fileName.toString())) {
		            log(logFile, "VALID FILE → moving to processing : " + fileName);
		            proceedIncomingSuccess(fileName, incoming, processing, processed, success);
		        } else {
		            log(logFile, "INVALID FILE → moving to error : " + fileName);
		            proceedIncomingFailure(fileName, incoming, error);
		        }
		    }

		    boolean valid = key.reset();
		    if (!valid) break;
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
	
	private static void log(Path logFile, String message) {
	    try {
	        String entry = java.time.LocalDateTime.now()
	                + " | " + message + System.lineSeparator();

	        Files.write(
	                logFile,
	                entry.getBytes(),
	                java.nio.file.StandardOpenOption.APPEND
	        );
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}



//
//
//package com.tcs.problem3;
//
//import java.io.IOException;
//import java.nio.file.*;
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//
//    private static final Path ROOT =
//            Paths.get("/home/labuser/Desktop/UseCase 3");
//
//    private static final Path INCOMING = ROOT.resolve("Incoming_claims");
//    private static final Path PROCESSING = ROOT.resolve("Processing_Claims");
//    private static final Path PROCESSED = ROOT.resolve("Processed_Claims");
//    private static final Path SUCCESS = ROOT.resolve("Success_Claims");
//    private static final Path ERROR = ROOT.resolve("Error_Claims");
//
//    private static final Path LOG_FILE = ROOT.resolve("usecase3.log");
//
//    public static void main(String[] args) throws Exception {
//
//        Files.createDirectories(INCOMING);
//        Files.createDirectories(PROCESSING);
//        Files.createDirectories(ERROR);
//
//        if (Files.notExists(LOG_FILE)) {
//            Files.createFile(LOG_FILE);
//        }
//
//        WatchService watchService = FileSystems.getDefault().newWatchService();
//        Map<WatchKey, Path> keyDirMap = new HashMap<>();
//
//        Files.walk(ROOT)
//                .filter(Files::isDirectory)
//                .forEach(dir -> {
//                    try {
//                        WatchKey key = dir.register(
//                                watchService,
//                                StandardWatchEventKinds.ENTRY_CREATE,
//                                StandardWatchEventKinds.ENTRY_MODIFY,
//                                StandardWatchEventKinds.ENTRY_DELETE
//                        );
//                        keyDirMap.put(key, dir);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
//
//        System.out.println("Watching entire UseCase 3 directory...");
//
//        while (true) {
//
//            WatchKey key = watchService.take();
//            Path watchedDir = keyDirMap.get(key);
//
//            for (WatchEvent<?> event : key.pollEvents()) {
//
//                WatchEvent.Kind<?> kind = event.kind();
//                Path name = (Path) event.context();
//                Path fullPath = watchedDir.resolve(name);
//
//                if (fullPath.equals(LOG_FILE)) continue;
//
//                log(kind.name() + " | " + fullPath);
//
//                if (watchedDir.equals(INCOMING)
//                        && kind == StandardWatchEventKinds.ENTRY_CREATE
//                        && Files.isRegularFile(fullPath)) {
//
//                    if (verify(name.toString())) {
//                        move(INCOMING, PROCESSING, name);
//                        log("VALID → moved to Processing | " + name);
//                        move(PROCESSING, PROCESSED, name);
//                        log("VALID → moved to Processing | " + name);
//                        move(PROCESSED, SUCCESS, name);
//                        log("VALID → moved to Processing | " + name);
//                    } else {
//                        move(INCOMING, ERROR, name);
//                        log("INVALID → moved to Error | " + name);
//                    }
//                }
//            }
//
//            boolean valid = key.reset();
//            if (!valid) {
//                keyDirMap.remove(key);
//                if (keyDirMap.isEmpty()) break;
//            }
//        }
//    }
//
//    private static void move(Path fromDir, Path toDir, Path fileName) throws IOException {
//        Files.move(
//                fromDir.resolve(fileName),
//                toDir.resolve(fileName),
//                StandardCopyOption.REPLACE_EXISTING
//        );
//    }
//
//    private static boolean verify(String name) {
//        return name.startsWith("claim");
//    }
//
//    private static void log(String message) {
//        try {
//            Files.write(
//                    LOG_FILE,
//                    (LocalDateTime.now() + " | " + message + System.lineSeparator()).getBytes(),
//                    StandardOpenOption.APPEND
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
