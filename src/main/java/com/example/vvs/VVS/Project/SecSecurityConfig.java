package com.example.vvs.VVS.Project;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("romulo")
                .password(encoder.encode("romulo"))
                .roles("romulo")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // http builder configurations for authorize requests and form login (see below)

        http    .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


}
