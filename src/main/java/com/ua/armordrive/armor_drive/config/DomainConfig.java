package com.ua.armordrive.armor_drive.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.ua.armordrive.armor_drive.domain")
@EnableJpaRepositories("com.ua.armordrive.armor_drive.repos")
@EnableTransactionManagement
public class DomainConfig {
}
