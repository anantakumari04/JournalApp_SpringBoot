package net.engineeringdigest.journalApp.config;
import net.engineeringdigest.journalApp.service.UserDetailsServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SpringSecurity extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServiceimpl userDetailsServiceimpl;


    @Override

   // This method defines:
    //        ➡ Which APIs are protected
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/journal/**","/user/**").authenticated() // star ka mtlb baad me kuch bhi aata rhe
                .anyRequest().permitAll()
                .and()
                .httpBasic();

       // http.csrf().disable(); //cross site request forgery// token nhi bhejna pre
// spring security session manage krti h isiliye csrf bna dete h disable abhi k liye

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
    }

    @Override
    //This defines:
    //➡ How users are verified
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceimpl).passwordEncoder(passwordEncoder()); // pass matching

        //➡ When login happens:
        //Spring calls:
        //
        //loadUserByUsername() from my custom  service which is userdetailsserviceimpl

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
