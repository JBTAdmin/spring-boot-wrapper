package com.jbt.manager;

import java.util.Properties;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
//@AllArgsConstructor
@Configuration
@Component
@ConfigurationProperties(prefix = "jpa.config")
public class BaseJpaConfig {

	private String batchSize;

	private String schema;

	protected Properties jpaProperties(String dialect){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("batch_size", batchSize);
		properties.put("hibernate.default_schema", schema);
		return properties;
	}
}

//public class BaseJpaConfig {
//    private String jpaProperties;
//    private String jpaPackagesToScan;
//}
