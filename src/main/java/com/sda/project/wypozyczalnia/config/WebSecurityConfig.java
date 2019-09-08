package com.sda.project.wypozyczalnia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("robert")
                .password("{noop}haslo123")
                .roles("USER");

        auth
                .inMemoryAuthentication()
                .withUser("piotr")
                .password("{noop}haslo123")
                .roles("ADMIN");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v2/**", "/csrf/**", "/h2-console").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/posts/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/posts/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/posts/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/posts/**").hasAnyRole("USER", "ADMIN");
    }
}