package com.idas2.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.idas2"})
@EntityScan(basePackages = {"com.idas2.db.entity"})
@EnableJpaRepositories(basePackages = {"com.idas2.db.repository"})
public class DataConfiguration {
}

