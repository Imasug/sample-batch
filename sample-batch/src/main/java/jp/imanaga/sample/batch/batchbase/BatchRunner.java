package jp.imanaga.sample.batch.batchbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import jp.imanaga.sample.batch.common.exceptions.BatchErrorException;
import jp.imanaga.sample.batch.common.helpers.MessageHelper;

@Component
public class BatchRunner {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private MessageHelper messageHelper;

	public void exec(String... args) {

		try {

			// TODO check
			String batchId = args[0];

			BatchService service = this.context.getBean(batchId, BatchService.class);
			service.exec();

		} catch (BatchErrorException e) {
			// Use a message lapper
			// You can also use a code generator for creating message lapper object
			System.out.println(this.messageHelper.toText(e.getErrorInfo()));
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
