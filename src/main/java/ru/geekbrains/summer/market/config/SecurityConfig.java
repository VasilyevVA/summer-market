package ru.geekbrains.summer.market.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class.getName());

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("In-Memory Security Configuration");
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2/**").authenticated()
                .antMatchers("/set.html/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers("/users.html/**").hasRole("ADMIN")
                .and()
                .logout()
                .and()
                .formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public JdbcUserDetailsManager users(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
}