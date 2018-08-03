 package com.batch.spring.steps.processor;

import com.batch.spring.entity.Vechile;


public class VechileProcessor implements org.springframework.batch.item.ItemProcessor<Vechile, Vechile> {
	
	
	@Override
	public Vechile process(Vechile vechile) throws Exception {
		
		if(Integer.parseInt(vechile.getBuilt())<1998){
			final String model = firstIndexCapital(vechile.getModel()).toString();
			vechile = new Vechile(vechile.getId(),vechile.getType(),model,vechile.getBuilt());
		}
		
		return vechile;
	}
	
	public StringBuilder firstIndexCapital(String word){
		StringBuilder sb = new StringBuilder();
		sb.append(word.charAt(0)+"".toUpperCase());
		sb.append(word.subSequence(1, word.length()));
		return sb;
	}
	
}
