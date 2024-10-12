package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.example.demo.mapper") // 매퍼 패키지 설정
public class PostgresDataSourceConfig {

	private final DataSource postgresDataSource;

    public PostgresDataSourceConfig(DataSource postgresDataSource) {
        this.postgresDataSource = postgresDataSource;
    }

    @Bean(name = "postgresTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(postgresDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(postgresDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml")); // 매퍼 XML 파일 경로
        return sessionFactory.getObject();
    }

}

