package com.saitej.springsecurity_02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    protected SecurityConfiguration() {
        super();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication().withUser("joe").password("joe").authorities("USER")
                 .and().withUser("leo").password("leo").authorities("ADMIN")
                 .and().withUser("sam").password("sam").authorities("STUDENT");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers("/welcome").authenticated()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/std").authenticated()
                .and().formLogin().defaultSuccessUrl("/welcome",true)
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
