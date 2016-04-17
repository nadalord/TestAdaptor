/**
 * 
 */
package com.untis.bems.configure.database.ddc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.untis.bems.configure.database.DatabaseConfig;

@Configuration
@EnableConfigurationProperties(ShinyoungDDCDatabaseProperties.class)
class ShinyoungDDCDatabaseConfig extends DatabaseConfig {
	
	@Autowired
	private ShinyoungDDCDatabaseProperties shinyoungDDCDatabaseProperties;
	
	@Bean(name = "shinyoungDDCDataSource", destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource agentDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(agentDataSource, shinyoungDDCDatabaseProperties);
		return agentDataSource;
	}
}