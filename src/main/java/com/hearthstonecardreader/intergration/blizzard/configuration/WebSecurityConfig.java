package com.hearthstonecardreader.intergration.blizzard.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
//used to override spring security allowing all incoming requests
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll();

    }
}