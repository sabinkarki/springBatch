package com.batch.spring.steps.processor;

import org.springframework.batch.item.ItemProcessor;

public class WordProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		return item.toLowerCase();
	}

}
