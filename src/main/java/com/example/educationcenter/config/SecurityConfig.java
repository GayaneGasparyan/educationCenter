package com.example.educationcenter.config;

import com.example.educationcenter.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService)
                .passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/admin/**")
                .hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/showmassage/**")
                .hasAnyAuthority("LECTURER", "ADMIN", "STUDENT")
                .antMatchers(HttpMethod.GET, "/massage/**")
                .hasAnyAuthority("LECTURER", "ADMIN", "STUDENT")
                .antMatchers(HttpMethod.GET, "/lecturer/**")
                .hasAnyAuthority("LECTURER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/student/**")
                .hasAnyAuthority("STUDENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/addUser")
//                .hasAnyAuthority("ADMIN")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/courses/**")
                .hasAnyAuthority("LECTURER", "ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/loginSuccess")
                .and()
                .csrf()
                .disable()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
