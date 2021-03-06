package com.batch.spring.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.batch.spring.entity.Vechile;
import com.batch.spring.steps.listener.JobCompletionNotificationListener1;
import com.batch.spring.steps.listener.JobCompletionNotificationListner2;
import com.batch.spring.steps.processor.VechileProcessor;
import com.batch.spring.steps.processor.WordProcessor;
import com.batch.spring.steps.reader.WordReader;
import com.batch.spring.steps.writer.VechileWriter;
import com.batch.spring.steps.writer.WordWriter;

@Configuration
public class BatchConfig {
	
	@Autowired
	private JobBuilderFactory jobs;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private VechileProcessor vechileProcessor;
	
	@Autowired
	private VechileWriter vechileWriter;
	
	@Autowired
	private WordReader wordReader;
	
	@Autowired
	private WordProcessor wordProcessor;
	
	@Autowired
	private WordWriter wordWriter;
	
	
	@Bean(name ="job1")
	public Job job1(JobCompletionNotificationListener1 listner){
		return jobs.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listner)
				.flow(step1()) //execute a step or sequence of steps
				.next(step2())
				.end()
				.build();
	}
	
	@Bean(name ="job2")
	public Job job2(JobCompletionNotificationListner2 listner){
		return jobs.get("job2")
				.incrementer(new RunIdIncrementer())
				.listener(listner)
				.start(step2())   //for only one step
				.build();
	}
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1")
				.<Vechile,Vechile>chunk(10)
				.reader(reader())
				.processor(vechileProcessor)
				.writer(vechileWriter)
				.build();
	}
	
	@Bean
	public Step step2(){
		return stepBuilderFactory.get("step2")
				.<String, String> chunk(3)
				.reader(wordReader)
				.processor(wordProcessor)
				.writer(wordWriter)
				.build();
	}

	
	@Bean
	public FlatFileItemReader<Vechile> reader() {
		return new FlatFileItemReaderBuilder<Vechile>().name("vechileItemReader").resource(new ClassPathResource("vechiles.csv"))
				.delimited().names(new String[] {"type","model","built" })
				.linesToSkip(1)  //skipping row one from csv file
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Vechile>(){
					
					{
						setTargetType(Vechile.class);
					}
				}).build();
	}
			
}
