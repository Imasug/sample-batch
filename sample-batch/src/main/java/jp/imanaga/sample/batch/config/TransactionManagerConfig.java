package jp.imanaga.sample.batch.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;
import org.springframework.transaction.jta.JtaTransactionManager;

import bitronix.tm.BitronixTransactionManager;
import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import jp.imanaga.sample.batch.service.TestService;

@Configuration
@EnableTransactionManagement
public class TransactionManagerConfig {

	// test
	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration configuration = TransactionManagerServices.getConfiguration();
		configuration.setDisableJmx(true);
		configuration.setServerId("spring-btm");
		return configuration;
	}

	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public BitronixTransactionManager BitronixTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	@Bean
	public PlatformTransactionManager JtaTransactionManager() {
		JtaTransactionManager transactionManager = new JtaTransactionManager();
		transactionManager.setTransactionManager(BitronixTransactionManager());
		transactionManager.setUserTransaction(BitronixTransactionManager());
		transactionManager.setAllowCustomIsolationLevels(true);
		return transactionManager;
	}

	@Bean
	public Properties driverProperties() {
		Properties driverProperties = new Properties();
		driverProperties.put("url", "jdbc:postgresql://localhost/testdb");
		driverProperties.put("user", "test");
		driverProperties.put("password", "test");
		return driverProperties;
	}

	@Bean(initMethod = "init", destroyMethod = "close")
	public PoolingDataSource xaDataSource1() {
		PoolingDataSource poolingDataSource = new PoolingDataSource();
		poolingDataSource.setClassName("org.postgresql.xa.PGXADataSource");
		poolingDataSource.setUniqueName("xaDataSource1");
		poolingDataSource.setMinPoolSize(1);
		poolingDataSource.setMaxPoolSize(4);
		poolingDataSource.setTestQuery("SELECT * FROM test");
		poolingDataSource.setDriverProperties(driverProperties());
		poolingDataSource.setAllowLocalTransactions(true);
		return poolingDataSource;
	}

//	@Bean
//	public Properties transactionAttributes() {
//		Properties transactionAttributes = new Properties();
//		transactionAttributes.put("*", "PROPAGATION_REQUIRED, -Exception");
//		return transactionAttributes;
//	}
//
//	@Bean
//	public TestService target() {
//		TestService testService = new TestService();
//		testService.setDataSource1(xaDataSource1());
//		return testService;
//	}
//
//	@Bean
//	public TransactionProxyFactoryBean testService() {
//		TransactionProxyFactoryBean transactionProxyFactoryBean = new TransactionProxyFactoryBean();
//		transactionProxyFactoryBean.setTransactionManager(JtaTransactionManager());
//		transactionProxyFactoryBean.setTransactionAttributes(transactionAttributes());
//		transactionProxyFactoryBean.setTarget(target());
//		return transactionProxyFactoryBean;
//	}

}
