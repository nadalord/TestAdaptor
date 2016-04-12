package com.untis.bems.configure.mybatis.ddc;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.untis.bems.configure.mybatis.MyBatisConfig;
import com.untis.bems.mapper.support.ShinYoungDDCMapper;

@Configuration
@MapperScan(basePackages = MyBatisConfig.BASE_PACKAGE, annotationClass = ShinYoungDDCMapper.class, sqlSessionFactoryRef = "shinYoungDDCSqlSessionFactory")
class ShinYoungDDCMyBatisConfig extends MyBatisConfig {
	
	@Bean
	public SqlSessionFactory shinYoungDDCSqlSessionFactory(@Qualifier("shinYoungDDCDataSource") DataSource agentDataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		configureSqlSessionFactory(sessionFactoryBean, agentDataSource);
		return sessionFactoryBean.getObject();
	}
}