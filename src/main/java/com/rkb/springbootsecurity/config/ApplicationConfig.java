package com.rkb.springbootsecurity.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    /// For In memory users
    /*@Bean
    UserDetailsManager inMemoryUserDetails() {
        return new InMemoryUserDetailsManager();
    }*/

    //For Jdbc configuration
    @Bean
    UserDetailsManager inDatabaseUserDetails(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        return jdbcUserDetailsManager;
    }

    @Bean
    InitializingBean initializer(UserDetailsManager userDetailsManager){
        return () -> {
            UserDetails ranjeet = User.withDefaultPasswordEncoder().username("ranjeet").password("password").roles("USER").build();
            userDetailsManager.createUser(ranjeet);
            ///UserDetails kumar = User.withDefaultPasswordEncoder().username("kumar").password("password").roles("USER").build();
            UserDetails kumar = User.withUserDetails(ranjeet).username("kumar").password("password").build();
            userDetailsManager.createUser(kumar);
        };
    }




}
