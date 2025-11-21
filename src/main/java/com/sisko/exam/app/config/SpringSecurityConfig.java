package com.sisko.exam.app.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.app.model.JsonUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    public SpringSecurityConfig() {
        super();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<JsonUser>> typeReference = new TypeReference<>() {};
        try {
            InputStream inputStream = new ClassPathResource("static/json/user.json").getInputStream();
            List<JsonUser> users = objectMapper.readValue(inputStream, typeReference);
            List<UserDetails> userDetailsList = new ArrayList<>();
            for (JsonUser user : users) {
                userDetailsList.add(User.builder()
                        .username(user.getUsername())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(user.getRole())
                        .build());
            }
            return new InMemoryUserDetailsManager(userDetailsList);
        } catch (IOException e) {
            e.printStackTrace();
            return new InMemoryUserDetailsManager();
        }
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
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )
                // remember me
                .rememberMe(rememberMe -> rememberMe
                    .key("uniqueAndSecret")
                    .tokenValiditySeconds(3600)
                )
                // authorize requests — permit public pages/static assets, authenticate the rest
                .authorizeHttpRequests(authorize -> authorize
                        // public pages / static resources
                        .requestMatchers(
                                "/audio/**", "/css/**", "/img/**", "/js/**",
                                "/json/**", "/svg.icons/**", "/vendor/**","/images/**",
                                "/login", "/401", "/403","/404","/500",
                                "/webjars/**"
                        ).permitAll()
                        // uncomment / adjust these lines if you want role-based access
                        //.requestMatchers("/admin/**").hasRole("ADMIN")
                        //.requestMatchers("/user/**").hasRole("USER")
                        //.requestMatchers("/shared/**").hasAnyRole("USER", "ADMIN")
                        // rest must be authenticated
                        .anyRequest().authenticated()
                )
                // access denied page
                .exceptionHandling(handling -> handling
                        .accessDeniedPage("/403.html")
                );

        return http.build();
    }
}
