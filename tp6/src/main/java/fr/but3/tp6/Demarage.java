package fr.but3.tp6;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Demarage implements ApplicationRunner
{
	@Autowired
	private ApplicationContext applicationContext;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		Arrays.stream(applicationContext.getBeanDefinitionNames())
				.forEach(bean -> System.out.println(bean));
	}

}
