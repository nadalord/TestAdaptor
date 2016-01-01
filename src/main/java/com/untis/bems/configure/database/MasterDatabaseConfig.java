package com.untis.bems.configure.database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(MasterDatabaseProperties.class)
class MasterDatabaseConfig extends DatabaseConfig {
	
	@Autowired
	private MasterDatabaseProperties masterDatabaseProperties;
	
	@Primary
	@Bean(name = "masterDataSource", destroyMethod = "close")
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource masterDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		configureDataSource(masterDataSource, masterDatabaseProperties);
		return masterDataSource;
	}
	
	@Bean
    public PlatformTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource masterDataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(masterDataSource);
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
    }
}