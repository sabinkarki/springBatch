package com.batch.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.batch.spring.repository.VechileRepository;

@Service
@Transactional
public class VechileServiceImpl implements VehileService{
	
	@Autowired
	private VechileRepository VechileRepository;

	
	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		try{
			this.VechileRepository.deleteAll();
			return true;
			
		}catch(Exception e){
			return false;
		}
		
	}

}
