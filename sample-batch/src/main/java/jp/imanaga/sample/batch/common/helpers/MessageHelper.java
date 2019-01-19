package jp.imanaga.sample.batch.common.helpers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import jp.imanaga.sample.batch.common.messages.ResourceInfo;

@Component
public class MessageHelper {

	@Autowired
	private MessageSource messageSource;

	public String toText(ResourceInfo info) {
		return this.messageSource.getMessage(info.getCode(), info.getParameters(), Locale.getDefault());
	}

}
