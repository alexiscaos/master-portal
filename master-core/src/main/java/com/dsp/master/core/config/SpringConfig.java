package com.dsp.master.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dsp.master.data.config.DataBaseConfig;

@Configuration
@ComponentScan(basePackages = { "com.dsp.master.core.service", "com.dsp.master.data.repository" })
@EnableJpaRepositories(basePackages = "com.dsp.master.data.repository")
@Import(DataBaseConfig.class)
public class SpringConfig {

}