package com.batch.spring.steps.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class WordReader implements ItemReader<String> {
	
	String [] words ={"Laptop","Pamtop","Watch"};
	
	int count=0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if (count < words.length) {
			return words[count++];
		} else {
			count = 0;
		}
		return null;
		
	}

}
