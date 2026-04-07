package net.engineeringdigest.journalApp.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SpringSecurity extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/journal/**").authenticated() // star ka mtlb baad me kuch bhi aata rhe
                .anyRequest().permitAll()
                .and()
                .httpBasic();

    }
}
