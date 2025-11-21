package com.sisko.exam.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    public SpringSecurityConfig() {
        super();
    }


    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http
                // form login — allow everyone to access the login pages
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login-error.html")
                        .permitAll()
                )
                // logout — allow everyone to perform logout
                .logout(logout -> logout
                        .logoutSuccessUrl("/index.html")
                        .permitAll()
                )
                // authorize requests — permit public pages/static assets, authenticate the rest
                .authorizeHttpRequests(authorize -> authorize
                        // public pages / static resources
                        .requestMatchers(
                                "/audio/**", "/css/**", "/img/**", "/js/**",
                                "/json/**", "/svg.icons/**", "/vendor/**","/images/**",
                                "/index.html", "/login.html",
                                "/login-error.html",
                                "/403.html",
                                "/webjars/**"
                        ).permitAll()
                        // uncomment / adjust these lines if you want role-based access
                        //.requestMatchers("/admin/**").hasRole("ADMIN")
                        //.requestMatchers("/user/**").hasRole("USER")
                        //.requestMatchers("/shared/**").hasAnyRole("USER", "ADMIN")
                        // rest must be authenticated
                        //.anyRequest().authenticated()
                        .anyRequest().permitAll()
                )
                // access denied page
                .exceptionHandling(handling -> handling
                        .accessDeniedPage("/403.html")
                );

        return http.build();
    }
}
