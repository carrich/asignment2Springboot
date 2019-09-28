package fpt.asignmentspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
//                .authorizeRequests()
//                .antMatchers("/accounts/*","/accounts/**").permitAll()
//                .antMatchers("/api/v1/books/*").permitAll()
//                .antMatchers("/admin/**").authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/accounts/login")
//                .permitAll()
//                .loginProcessingUrl("/process-login")
//                .and()
//                .logout()
//                .permitAll();

    }
}
