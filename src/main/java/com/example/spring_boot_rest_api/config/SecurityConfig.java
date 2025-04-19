package com.example.spring_boot_rest_api.config;

import com.example.spring_boot_rest_api.repositories.CustomCsrfTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Slf4j
@Configuration
public class SecurityConfig {

//    private AuthFilter authFilter;
//    private StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;
//    private LoggingFilter loggingFilter;
////
//    public SecurityConfig(StaticKeyAuthenticationFilter staticKeyAuthenticationFilter, AuthFilter authFilter, LoggingFilter loggingFilter) {
//        this.authFilter = authFilter;
//        this.staticKeyAuthenticationFilter = staticKeyAuthenticationFilter;
//        this.loggingFilter = loggingFilter;
//    }

    @Bean
    public CsrfTokenRepository customTokenRepository() {
        return new CustomCsrfTokenRepository();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomCsrfTokenRepository customCsrfTokenRepository) throws Exception {
        http
//                .csrf(c -> {
//                    c.csrfTokenRepository(customTokenRepository());
//                    c.ignoringRequestMatchers("/all");
//                })
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/users/*").hasRole("ADMIN")
//                        .requestMatchers("/users/all").hasRole("USER")
                        .anyRequest().authenticated()
                )
//                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(staticKeyAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(loggingFilter, UsernamePasswordAuthenticationFilter.class)

                .httpBasic(withDefaults());
//                .and()
//                .formLogin(withDefaults())
//                .logout(logout -> logout.logoutSuccessUrl("/login?logout"))
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
        return http.build();
    }

//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new ProviderManager(List.of(customAuthProvider()));
//    }

//    @Bean
//    public AuthenticationProvider customAuthProvider() {
//        return new CustomAuthProvider(userDetailsService, passwordEncoder);
//    }

}

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("12345")
//                .authorities("read")
//                .roles("USER")
//                .build();
//
//        var userDetailsService = new InMemoryUserDetailsManager();
//
//        userDetailsService.createUser(user);
//        return userDetailsService;
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return customUserDetailsService;
//    }
