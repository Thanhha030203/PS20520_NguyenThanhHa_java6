package com.ps20520;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ResourceConfig {
		@Bean("messageSource")
		public MessageSource getMesssageSource() { 
			ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
			ms.setDefaultEncoding("utf-8");
			ms.setBasename("classpath:menu");
			return ms;
		}
		
}
