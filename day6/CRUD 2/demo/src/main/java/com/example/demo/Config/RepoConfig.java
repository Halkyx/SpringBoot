package com.example.demo.config;

import com.example.demo.repository.EmployeeDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
    public class RepoConfig {
    
      @Bean
      public EmployeeDao employeeDao() {
        return new EmployeeDao("employee_data.csv");
      }
    
       
}
