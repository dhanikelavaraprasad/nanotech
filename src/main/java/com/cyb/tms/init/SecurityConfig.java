package com.cyb.tms.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cyb.tms.security.AuthenticationTokenFilter;
import com.cyb.tms.security.EntryPointUnauthorizedHandler;
import com.cyb.tms.security.service.SecurityService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	  private EntryPointUnauthorizedHandler unauthorizedHandler;

	  @Autowired
	  private UserDetailsService userDetailsService;

	  @Autowired
	  private SecurityService securityService;

	  @Autowired
	  public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	    authenticationManagerBuilder
	      .userDetailsService(this.userDetailsService)
	        .passwordEncoder(passwordEncoder());
	  }
	  
	  @Bean
	  public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
	   return new PropertySourcesPlaceholderConfigurer();
	  }
	  
	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }

	  @Bean
	  public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
	    AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
	    authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
	    return authenticationTokenFilter;
	  }

	  @Bean
	  public SecurityService securityService() {
	    return this.securityService;
	  }

	  @Override
	  protected void configure(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity
	      .csrf()
	        .disable()
	      .exceptionHandling()
	        .authenticationEntryPoint(this.unauthorizedHandler)
	        .and()
	      .sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	      .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        .antMatchers("/api/auth/**").permitAll()
	        .anyRequest().authenticated();

	    // Custom JWT based authentication
	    httpSecurity
	      .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	  }

}
