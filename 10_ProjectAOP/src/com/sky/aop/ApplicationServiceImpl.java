package com.sky.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	
	@Override
	public void processApplication() {

		System.out.println("Process ApplicationForm");
	}

	@Auditable(value="check")
	@Transactional
	public String processApplicationWithAudit() {
System.out.println("process applicationform in");
		
		return "sucess";
	}
	

}
