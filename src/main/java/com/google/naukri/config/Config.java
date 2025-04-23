package com.google.naukri.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Config {

	@Bean
	public JavaMailSender javaMailSender() {
		
JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
		
		jmsi.setHost("smtp.gmail.com");
		jmsi.setPort(587);
		jmsi.setUsername("litetencent5@gmail.com");
		jmsi.setPassword("puki heeg xfiz yieb"); 
				
		Properties props = jmsi.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		return jmsi;

	}
}
