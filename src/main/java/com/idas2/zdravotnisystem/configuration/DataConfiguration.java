package com.idas2.zdravotnisystem.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.idas2.zdravotnisystem"})
@EntityScan(basePackages = {"com.idas2.zdravotnisystem.db.entity"})
@EnableJpaRepositories(basePackages = {"com.idas2.zdravotnisystem.db.repository"})
public class DataConfiguration {
}

