package com.untis.bems.configure.mybatis.ddc;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.untis.bems.configure.mybatis.MyBatisConfig;
import com.untis.bems.mapper.support.OmniMeterMapper;

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE, annotationClass = OmniMeterMapper.class, sqlSessionFactoryRef = "omniMeterSqlSessionFactory")
class OmniMeterMyBatisConfig extends MyBatisConfig {
	
	@Bean
	public SqlSessionFactory omniMeterSqlSessionFactory(@Qualifier("omniMeterDataSource") DataSource agentDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		configureSqlSessionFactory(sessionFactoryBean, agentDataSource);
		return sessionFactoryBean.getObject();
	}
}