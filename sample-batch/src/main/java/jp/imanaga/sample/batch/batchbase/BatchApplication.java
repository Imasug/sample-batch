package jp.imanaga.sample.batch.batchbase;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jp.imanaga.sample.batch.config.AppConfig;

public class BatchApplication {

	public static void main(String[] args) throws Exception {

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			context.getBean(BatchRunner.class).exec(args);
		}

	}
}
