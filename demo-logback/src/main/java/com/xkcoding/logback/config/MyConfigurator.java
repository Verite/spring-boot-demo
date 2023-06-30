package com.xkcoding.logback.config;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.util.StatusPrinter;

public class MyConfigurator extends ContextAwareBase implements Configurator {

	public MyConfigurator() {
	}

	@Override
	public void configure(LoggerContext lc) {
		addInfo("Setting up default MyConfigurator.");

		ConsoleAppender<ILoggingEvent> ca = new ConsoleAppender<>();
		lc.setPackagingDataEnabled(true);
		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
		StatusPrinter.print(lc);

		ca.setContext(lc);
		ca.setName("console");
		LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<ILoggingEvent>();
		encoder.setContext(lc);


		// same as
		PatternLayout layout = new PatternLayout();
		layout.setPattern("MyConfigurator %d{yyyy-mm-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
		layout.setContext(lc);
		layout.start();
		encoder.setLayout(layout);

		ca.setEncoder(encoder);
		ca.start();

		Logger rootLogger = lc.getLogger(Logger.ROOT_LOGGER_NAME);
		rootLogger.addAppender(ca);
	}


}
