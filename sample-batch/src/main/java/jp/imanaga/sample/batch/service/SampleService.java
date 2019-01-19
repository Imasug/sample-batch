package jp.imanaga.sample.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import jp.imanaga.sample.batch.batchbase.BatchService;

@Component("sample")
public class SampleService implements BatchService {

//	@Autowired
//	private PGXADataSource pgXaDataSource;
//
//	@Autowired
//	private ContentSource contentSource;
//
	@Override
	public void exec() throws Exception {
//
//		// test
//		TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
//
//		XAConnection xaConnection = pgXaDataSource.getXAConnection();
//		try (Session session = this.contentSource.newSession();
//				Connection pgConnection = xaConnection.getConnection();) {
//
//			tm.begin();
//
//			tm.getTransaction().enlistResource(session.getXAResource());
//			tm.getTransaction().enlistResource((XAResource) xaConnection);
//
//			session.submitRequest(session.newAdhocQuery("xdmp:document-insert('test.txt', <test/>)"));
//			pgConnection.createStatement().executeUpdate("insert into test values(0, 'test');");
//
//			tm.commit();
//
//		} finally {
//			if (tm.getTransaction() != null) {
//				tm.rollback();
//			}
//		}
//
//		// Use lapper object has the message infomation
//		// throw new BatchErrorException(new ErrorInfo("test1"));
	}

}
