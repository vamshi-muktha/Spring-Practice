package com.tcs.problem3.service;

import java.nio.file.Path;

import com.tcs.problem3.configuration.DirectoryConfig;

public class ClaimProcessingService {

	private final DirectoryConfig config;
	private final ValidationService validationService;
	private final FileMoveService fileMoveService;
	private final LogService logService;

	public ClaimProcessingService(DirectoryConfig config, ValidationService validationService,
			FileMoveService fileMoveService, LogService logService) {
		this.config = config;
		this.validationService = validationService;
		this.fileMoveService = fileMoveService;
		this.logService = logService;
	}

	public void process(Path fileName) {

		try {
			if (validationService.isValidClaim(fileName.toString())) {

				fileMoveService.move(config.getIncoming(), config.getProcessing(), fileName);
				logService.info("VALID → moved to Processing | " + fileName);

				fileMoveService.move(config.getProcessing(), config.getProcessed(), fileName);
				logService.info("VALID → moved to Processed | " + fileName);

				fileMoveService.move(config.getProcessed(), config.getSuccess(), fileName);
				logService.info("VALID → moved to Success | " + fileName);

			} else {

				fileMoveService.move(config.getIncoming(), config.getError(), fileName);
				logService.info("INVALID → moved to Error | " + fileName);
			}

		} catch (Exception e) {
			logService.error("Processing failed for " + fileName + " : " + e.getMessage());
		}
	}
}
