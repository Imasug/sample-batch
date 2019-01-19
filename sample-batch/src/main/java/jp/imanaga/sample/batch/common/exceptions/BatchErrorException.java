package jp.imanaga.sample.batch.common.exceptions;

import jp.imanaga.sample.batch.common.messages.ErrorInfo;

public class BatchErrorException extends RuntimeException {

	private static final long serialVersionUID = -5511556408914604365L;

	private ErrorInfo errorInfo;

	// The follow way is also effective
	// 1. Add argument for a list of errorInfo.
	// 2. Add argument for a parent message.

	public BatchErrorException(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public BatchErrorException(ErrorInfo errorInfo, Throwable e) {
		super(e);
		this.errorInfo = errorInfo;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

}
