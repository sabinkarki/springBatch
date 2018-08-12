 package com.batch.spring.steps.processor;

import org.springframework.stereotype.Component;

import com.batch.spring.entity.Vechile;

@Component
public class VechileProcessor implements org.springframework.batch.item.ItemProcessor<Vechile, Vechile> {
	
	private  static long id =0;
	
	@Override
	public Vechile process(Vechile vechile) throws Exception {
		
		if(Integer.parseInt(vechile.getBuilt())>1998){
			final String model = firstIndexCapital(vechile.getModel()).toString();
			vechile = new Vechile(++id,vechile.getType(),model,vechile.getBuilt());
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
