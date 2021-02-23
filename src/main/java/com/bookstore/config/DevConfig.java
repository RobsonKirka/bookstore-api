/**
 * 
 */
package com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bookstore.service.DBService;

/**
 * @author robson.kirka
 *
 */
@Configuration
@Profile("dev")
public class DevConfig {

	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean createDataBase() {
		if("create".equals(strategy)) {
			this.dbService.createDataBase();
			return true;
		}
		return false;
	}
}
