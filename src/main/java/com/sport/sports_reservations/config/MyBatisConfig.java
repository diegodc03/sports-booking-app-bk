package com.sport.sports_reservations.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.sport.sports_reservations.mapper")
public class MyBatisConfig {}
