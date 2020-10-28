package com.madhuram.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.madhuram.web.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityServiceConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Bean
    BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	            .antMatchers("/admin/**").hasRole("admin")
	            .antMatchers("/user/**").hasAnyRole("admin","user")
	            .antMatchers("/logout/**").hasAnyRole("admin","user")
	            .antMatchers("/**").permitAll()
            .and()
            .formLogin()
            	.loginPage("/login")
            	.loginProcessingUrl("/login")
            	.defaultSuccessUrl("/", true).permitAll()
            .and()
            	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
            .and().csrf().disable();
            	
//            .and()
            
    }
	
	public SecurityServiceConfig() {
		// TODO Auto-generated constructor stub
	}

}
