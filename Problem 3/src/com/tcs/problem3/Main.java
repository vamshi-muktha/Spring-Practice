
package com.tcs.problem3;

import com.tcs.problem3.configuration.DirectoryConfig;
import com.tcs.problem3.service.ClaimProcessingService;
import com.tcs.problem3.service.DirectoryWatcher;
import com.tcs.problem3.service.FileMoveService;
import com.tcs.problem3.service.LogService;
import com.tcs.problem3.service.ValidationService;

public class Main {

	public static void main(String[] args) {

		try {
			// Config
			DirectoryConfig config = new DirectoryConfig();

			// Services
			LogService logService = new LogService(config.getLogFile());
			ValidationService validationService = new ValidationService();
			FileMoveService fileMoveService = new FileMoveService();

			// Processor
			ClaimProcessingService processor = new ClaimProcessingService(config, validationService, fileMoveService,
					logService);

			// Watcher
			DirectoryWatcher watcher = new DirectoryWatcher(config, processor);

			logService.info("Application started");
			watcher.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
