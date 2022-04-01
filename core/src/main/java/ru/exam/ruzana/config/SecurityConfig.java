package ru.exam.ruzana.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.exam.ruzana.config.handler.LoginSuccessHandler;
import ru.exam.ruzana.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasAnyRole("OWNER", "ADMIN")
                .antMatchers("/api/owner/**").hasRole("OWNER")
                .antMatchers("/user/**").hasAnyRole("OWNER", "ADMIN", "USER")

                .antMatchers("/api/storage/admin/**").hasAnyRole("OWNER", "ADMIN")
                .antMatchers("/api/storage/user/**").hasAnyRole("OWNER", "ADMIN", "USER")

                .antMatchers("/api/producer/admin/**").hasAnyRole("OWNER", "ADMIN")
                .antMatchers("/api/producer/user/**").hasAnyRole("OWNER", "ADMIN", "USER")

                .antMatchers("/api/categories/admin/**").hasAnyRole("OWNER", "ADMIN")
                .antMatchers("/api/categories/user/**").hasAnyRole("OWNER", "ADMIN", "USER")
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .permitAll();
        http.logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout");
        http.exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
