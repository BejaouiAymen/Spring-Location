package org.location;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;






@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource datasource;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	
	
	@Autowired
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		

		
		auth
		.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
	
		  auth.jdbcAuthentication().dataSource(datasource)
		  .usersByUsernameQuery("select username as principal , password as credentials, true from client where username=?")
		  .authoritiesByUsernameQuery("select username , role as role from client where username=?").rolePrefix("Role_").passwordEncoder(encoder);
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/consulter", "/registration", "/login", "/signup").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")  
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/consulter")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and().headers().frameOptions().disable();
		
	}

}
