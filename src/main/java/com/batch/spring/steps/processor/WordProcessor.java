package com.batch.spring.steps.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class WordProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		return item.toLowerCase();
	}

}
