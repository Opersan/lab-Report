package com.example.labreport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("authDataSource")
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource);

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/reports/list*").hasAnyRole("ADMIN","USER")
                .antMatchers("/reports/save*").hasAnyRole("ADMIN")
                .antMatchers("/reports/delete*").hasAnyRole("ADMIN")
                .antMatchers("/reports/download*").hasAnyRole("ADMIN","USER")
                .antMatchers("/reports/download/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/reports/**").hasAnyRole("ADMIN")
                .antMatchers("/resource/**").permitAll()
                .and()
                .formLogin().loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout()
                .permitAll().and()
                .exceptionHandling().accessDeniedPage("/access-denied");


        http.headers().frameOptions().disable();
    }
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/h2-console/**");
    }
}
