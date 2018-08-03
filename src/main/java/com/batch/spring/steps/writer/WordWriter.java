package com.batch.spring.steps.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class WordWriter implements ItemWriter<String> {

	public void write(List<? extends String> items) throws Exception {
		items.stream().forEach(item -> {
			System.out.println("Writing from ItemWriter" + item);
		});

	}

	
}
