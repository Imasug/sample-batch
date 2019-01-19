package jp.imanaga.sample.batch.common.messages;

public class ErrorInfo extends ResourceInfo {

	public ErrorInfo(String code, Object... parameters) {
		super(code, parameters);
	}

}
