import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sky.aop.ApplicationService;

public class TestSping {

	public static void main(String[] args) {
		
		ApplicationContext beanFactory= new ClassPathXmlApplicationContext("spring.xml");
		
		ApplicationService annoservice=(ApplicationService) beanFactory.getBean(ApplicationService.class);
		
		System.out.println(annoservice);
		
		annoservice.processApplication();
		ApplicationService annoservice2=(ApplicationService) beanFactory.getBean(ApplicationService.class);
		annoservice2.processApplicationWithAudit();
		System.out.println(annoservice2);
		
		
	}
}
