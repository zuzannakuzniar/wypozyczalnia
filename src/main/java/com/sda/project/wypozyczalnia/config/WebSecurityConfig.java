package com.sda.project.wypozyczalnia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pass")).roles("USER")
        .and()
        .withUser("admin").password(encoder.encode("pass")).roles("ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                // allows swagger public access
                .authorizeRequests()
                .antMatchers("/", "/csrf", "/swagger-ui.html", "/webjars/**", "/v2/controllers-docs**", "/swagger-resources/**").permitAll()
                .and()
                // allows h2 public access
                .authorizeRequests()
                .antMatchers("/wypozyczalnia/**", "/").permitAll()
                .and().headers().frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/addresses/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/addresses/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/addresses/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/addresses/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/orders/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/orders/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/orders/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/orders/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rentals/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/rentals/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/rentals/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rentals/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/reservations/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/reservations/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/reservations/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/reservations/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/returnCars/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/returnCars/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/returnCars/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/returnCars/*").hasRole("ADMIN")
                .and()
                // back to app endpoints configuration
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/users/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/users/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/cars/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/cars/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/cars/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/cars/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/departments/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/departments/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/departments/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/departments/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/employee/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/employee/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/employee/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/employee/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/equipments/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/equipments/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/equipments/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/equipments/*").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/hire/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/hire/*").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/hire/").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/hire/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                // allows POST, PUT, DELETE requests from outside (postman)
                .csrf().disable()
                // selects basic (header) authentication and prevents session from being created
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
