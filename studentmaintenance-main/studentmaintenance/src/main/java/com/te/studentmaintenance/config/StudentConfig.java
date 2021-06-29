package com.te.studentmaintenance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class StudentConfig {
	@Bean
	public LocalEntityManagerFactoryBean getFactory() {

		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("student_info");
		return bean;
	}

}
