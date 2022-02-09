package com.casper.financially.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.casper.financially.domain")
@EnableJpaRepositories("com.casper.financially.repos")
@EnableTransactionManagement
public class DomainConfig {
}
