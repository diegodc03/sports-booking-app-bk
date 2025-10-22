package com.sport.sports_reservations.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import com.sport.sports_reservations.mapper.UserMapper;

@Configuration
@MapperScan("com.sport.sports_reservations.mapper")
public class MyBatisConfig {
	

}
