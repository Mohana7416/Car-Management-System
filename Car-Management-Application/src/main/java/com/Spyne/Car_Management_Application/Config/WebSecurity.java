package com.Spyne.Car_Management_Application.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class WebSecurity {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        request ->request
                                .requestMatchers("user/signUp","user/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
   // @Bean
   public UserDetailsService userDetailsService()
   {
       UserDetails Mohana
               = User.withUsername("Mohana")
               .password("{noop}MohanaKrishna@7416")
               .roles("USER")
               .build();
       UserDetails Jithendra
               = User.withUsername("Jithendra")
               .password("{noop}Jithendra@7416")
               .roles("USER")
               .build();
       UserDetails Hemanth
               = User.withUsername("Hemanth")
               .password("{noop}Hemanth@7416")
               .roles("USER")
               .build();
       return new InMemoryUserDetailsManager(Mohana,Jithendra,Hemanth);

   }

}
