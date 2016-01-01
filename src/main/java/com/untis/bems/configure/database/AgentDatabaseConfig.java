/**
 * 
 */
package com.untis.bems.configure.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AgentDatabaseProperties.class)
class AgentDatabaseConfig extends DatabaseConfig {
	
	@Autowired
	private AgentDatabaseProperties agentDatabaseProperties;
	
	@Bean(name = "agentDataSource", destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource agentDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(agentDataSource, agentDatabaseProperties);
		return agentDataSource;
	}
}