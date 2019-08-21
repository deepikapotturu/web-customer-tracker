package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	 
	//do the same for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
	private void forAppFlow() {}
	
	//add @before addvice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display method we are calling
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("=========>> in @before : calling method: "+theMethod);
		
		//display the arguments to he method
		
		//get the arguments
		Object[] args=theJoinPoint.getArgs();
		//loop through arg and display
		for(Object tempArg:args) {
			myLogger.info("====>> argument: "+tempArg);
		}
	}
	
	//add @afterreturning
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint,Object theResult) {
		
		//display method we are returning from 
		String theMethod=theJoinPoint.getSignature().toShortString();
		myLogger.info("=========>> in @afterReturning : calling method: "+theMethod);
		
		//display data returned
		myLogger.info("====>>> result: "+theResult);
	}
	
}



















