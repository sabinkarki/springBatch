package com.batch.spring.steps.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.batch.spring.entity.Vechile;
import com.batch.spring.repository.VechileRepository;

@Component
public class VechileWriter implements ItemWriter<Vechile>{
	
	@Autowired
	private VechileRepository vechileRepository;

	@Override
	public void write(List<? extends Vechile> vechiles) throws Exception {
		this.vechileRepository.saveAll(vechiles);
		
	}

}
