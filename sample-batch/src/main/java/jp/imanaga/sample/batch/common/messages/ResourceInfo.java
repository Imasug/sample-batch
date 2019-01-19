package jp.imanaga.sample.batch.common.messages;

public abstract class ResourceInfo {

	private String code;

	private Object[] parameters;

	public ResourceInfo(String code, Object... parameters) {
		this.code = code;
		this.parameters = parameters;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}
