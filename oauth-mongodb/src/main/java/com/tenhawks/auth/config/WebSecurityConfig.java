package com.tenhawks.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenhawks.auth.bean.AuthHelper;
import com.tenhawks.auth.security.CustomAuthenticationManager;
import com.tenhawks.auth.security.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Mukhtiar
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomAuthenticationProvider customAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/users/signup").permitAll()
            .anyRequest().authenticated()
        .and()
        .logout().permitAll()
        .and()
        .csrf().disable();

    http.exceptionHandling()
            .accessDeniedHandler((request, response, accessDeniedException) -> {
              response.sendError(HttpStatus.FORBIDDEN.value());
              AuthHelper.sendJsonErrorResponse(accessDeniedException, HttpStatus.FORBIDDEN, response);
            })
            .authenticationEntryPoint((request, response, authException) -> {
              response.sendError(HttpStatus.UNAUTHORIZED.value());
              AuthHelper.sendJsonErrorResponse(authException, HttpStatus.UNAUTHORIZED, response);
            });
  }  

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return new CustomAuthenticationManager(customAuthenticationProvider);
  }
}
