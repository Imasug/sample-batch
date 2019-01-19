package jp.imanaga.sample.batch.service;

import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marklogic.xcc.ContentSource;
import com.marklogic.xcc.Session;

import jp.imanaga.sample.batch.batchbase.BatchService;
import jp.imanaga.sample.batch.common.exceptions.BatchErrorException;
import jp.imanaga.sample.batch.common.messages.ErrorInfo;

@Component("sample")
public class SampleService implements BatchService {

	@Autowired
	private ContentSource contentSource;

	@Override
	public void exec() throws Exception {

		// test
		TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
		try (Session session = this.contentSource.newSession()) {
			tm.begin();
			tm.getTransaction().enlistResource(session.getXAResource());
			session.submitRequest(session.newAdhocQuery("xdmp:document-insert('test.txt', <test/>)"));
			tm.commit();
		}

		// Use lapper object has the message infomation
		// throw new BatchErrorException(new ErrorInfo("test1"));
	}

}
