package com.block5logging.block5logging;
import java.util.logging.*;

import ch.qos.logback.classic.filter.ThresholdFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class BlockLoggingApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlockLoggingApplication.class, args);


	}
	Logger logger = LoggerFactory.getLogger(BlockLoggingApplication.class);

	@RequestMapping("/")
	public String index() {
		logger.trace("Mensaje a nivel de TRACE");
		logger.debug("Mensaje a nivel de DEBUG");
		logger.info("Mensaje a nivel de INFO");
		logger.warn("Mensaje a nivel de WARNING");
		logger.error("Mensaje a nivel de ERROR");

		return "Hola! Mira los logs para ver los resultados";
	}
}

