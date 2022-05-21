package com.sky.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class AnnoSecurityAspect {

	
	@Before("execution(* com.sky.aop.ApplicationService.*(..))")
	public void VerifyApplicationForm() {
		System.out.println("Ina anno before call");
	}
	
	
	@After ("execution(* com.sky.aop.ApplicationService.*(..))")
	public void processResults() {
		
		System.out.println("processResult");
	}
	
	@Before("@annotation(auditable)")
	public void doAccessCheck(Auditable auditable) {
		System.out.println("do acess check 4"+""+auditable.value());
		
	}
}
