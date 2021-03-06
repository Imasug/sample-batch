package jp.imanaga.sample.batch.config;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.apache.commons.dbcp2.managed.BasicManagedDataSource;
import org.postgresql.xa.PGXADataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.marklogic.xcc.ContentSource;
import com.marklogic.xcc.ContentSourceFactory;
import com.marklogic.xcc.exceptions.XccConfigException;

@Configuration
@ComponentScan("jp.imanaga.sample.batch")
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public ContentSource contentSource(@Value("${marklogic.uri}") String uri)
			throws XccConfigException, URISyntaxException {
		return ContentSourceFactory.newContentSource(new URI(uri));
	}

	// test
	// TODO pooling
//	@Bean
//	public PGXADataSource pgXaDataSource(@Value("${postgresql.url}") String url,
//			@Value("${postgresql.user}") String user, @Value("${postgresql.password}") String password) {
//		PGXADataSource pgXaDataSource = new PGXADataSource();
//		pgXaDataSource.setUrl(url);
//		pgXaDataSource.setUser(user);
//		pgXaDataSource.setPassword(password);
//		return pgXaDataSource;
//	}
}
