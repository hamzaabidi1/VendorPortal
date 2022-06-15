package com.smartech.vendorportal.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import com.smartech.vendorportal.utils.TaskException;


@Aspect  
@Configuration  
public class LoggingConfig {
	
Logger log = LoggerFactory.getLogger(LoggingConfig.class);
	
	@Before(value="execution(* com.smartech.vendorportal.*.*.*(..) )")
	public void logBefore(JoinPoint joinPoint) {
		log.info("executing {}",joinPoint);
		
	}
	
	@After(value="execution(* com.smartech.vendorportal.*.*.*(..) )")
	public void logAfter(JoinPoint joinPoint) {
		log.info("Complete execution of {}",joinPoint);
	}
	
	@Around(value="execution(* com.smartech.vendorportal.Services.*.*(..) )")
	public Object taskHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		long stratTime=System.currentTimeMillis();
		try {
			long timeTaken=System.currentTimeMillis()-stratTime;
			log.info("time taken by {} is {}",proceedingJoinPoint,timeTaken);
			return proceedingJoinPoint.proceed();
			
		}catch(TaskException e) {
			log.info("StatusCode {}",e.getHttpSatatus().value());
			log.info("Message {}",e.getMessage());
			throw new ResponseStatusException(e.getHttpSatatus(),e.getMessage());
		}
		
	}
	
	
	
	
	

}
