package com.untis.bems.configure.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.untis.bems.mapper.support.AgentMapper;

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE, annotationClass = AgentMapper.class, sqlSessionFactoryRef = "agentSqlSessionFactory")
class AgentMyBatisConfig extends MyBatisConfig {
	
	@Bean
	public SqlSessionFactory agentSqlSessionFactory(@Qualifier("agentDataSource") DataSource agentDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		configureSqlSessionFactory(sessionFactoryBean, agentDataSource);
		return sessionFactoryBean.getObject();
	}
}