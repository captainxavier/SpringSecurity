package com.xavier.springsecurity2.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.xavier.springsecurity2.Security.ApplicationUserPermission.EMPLOYEE_WRITE;
import static com.xavier.springsecurity2.Security.ApplicationUserRole.*;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(USER.name())
//                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.name())
//                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.name())
//                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(EMPLOYEE_WRITE.name())
//                .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ADMIN.name(),TRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails xavier = User.builder()
                .username("xavier")
                .password(passwordEncoder.encode("password"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails tom= User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails asher= User.builder()
                .username("asher")
                .password(passwordEncoder.encode("password123"))
                .authorities(TRAINEE.getGrantedAuthorities())
                .build();



        return new InMemoryUserDetailsManager(
                xavier,tom,asher
        );
    }
}
