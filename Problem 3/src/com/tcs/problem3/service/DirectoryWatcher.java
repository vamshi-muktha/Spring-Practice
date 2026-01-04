package com.tcs.problem3.service;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import com.tcs.problem3.configuration.DirectoryConfig;

public class DirectoryWatcher {

	private final DirectoryConfig config;
	private final ClaimProcessingService processor;

	public DirectoryWatcher(DirectoryConfig config, ClaimProcessingService processor) {
		this.config = config;
		this.processor = processor;
	}

	public void start() throws Exception {

		WatchService watchService = FileSystems.getDefault().newWatchService();

		config.getIncoming().register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

		System.out.println("Watching Incoming_claims..........");

		while (true) {

			WatchKey wk = watchService.take();

			for (WatchEvent<?> event : wk.pollEvents()) {

				if (event.kind() != StandardWatchEventKinds.ENTRY_CREATE) {
					continue;
				}

				Path fileName = (Path) event.context();

//				Path fullPath = config.getIncoming().resolve(fileName);
//				waitUntilFileIsStable(fullPath);
				
				Thread.sleep(2000);

				processor.process(fileName);
			}

			wk.reset();
		}
	}

//	private void waitUntilFileIsStable(Path file) {
//		try {
//			long size1 = -1;
//			long size2 = Files.size(file);
//
//			while (size1 != size2) {
//				size1 = size2;
//				Thread.sleep(300);
//				size2 = Files.size(file);
//			}
//		} catch (Exception ignored) {
//		}
//	}
}
