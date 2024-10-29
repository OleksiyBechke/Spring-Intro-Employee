package org.example.app.config;

import org.example.app.controller.EmployeeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.app")
public class AppConfig {

    @Bean
    public EmployeeController getEmployeeController() {
        return new EmployeeController();
    }
}
