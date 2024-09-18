package com.spring.security.security.config;

import com.spring.security.exception.CustomAccessDeniedHandler;
import com.spring.security.exception.CustomBasicAuthenticationEntryPoint;
import com.spring.security.security.filter.CsrfCookieFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {


//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
//
//        http.securityContext(contextConfig -> contextConfig.requireExplicitSave(false))
//                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
////                . csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
//
//                .cors(corsConfig -> corsConfig.configurationSource(new CorsConfigurationSource() {
//                    @Override
//                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                        CorsConfiguration config = new CorsConfiguration();
//                        config.setAllowedOrigins(Collections.singletonList("*"));
//                        config.setAllowedMethods(Collections.singletonList("*"));
//                        config.setAllowCredentials(true);
//                        config.setAllowedHeaders(Collections.singletonList("*"));
//                        config.setMaxAge(3600L);
//                        return config;
//                    }
//                }))
//
//                .csrf(csrfConfig -> csrfConfig.csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
//                        .ignoringRequestMatchers( "/contact","/register")
//                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
//                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
//                //maximum session is used to handle  concurrent sessions.
//                .sessionManagement(smc -> smc.invalidSessionUrl("/invalidSession").maximumSessions(3).maxSessionsPreventsLogin(true))
//
//                .requiresChannel(rcc -> rcc.anyRequest().requiresInsecure()); // Only HTTP
////        http.requiresChannel(rcc -> rcc.anyRequest().requiresSecure()) // Only HTTPs
//
//        http.authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/accounts", "/balance", "/loans", "/cards").authenticated()
//                .requestMatchers("/notice", "/contact", "/error", "/actuator/**", "/swagger-ui/**", "/v3/api-docs/**",
//                        "/actuator/health","/register","/invalidSession").permitAll());
////        http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.disable());
////        http.httpBasic(withDefaults());
//        http.formLogin(withDefaults());
//        http.httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
//        http.exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
//        return http.build();
//    }


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();

        http.securityContext(contextConfig -> contextConfig.requireExplicitSave(false))
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))

                .cors(corsConfig -> corsConfig.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("*"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }))

                .csrf(csrfConfig -> csrfConfig.csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                        .ignoringRequestMatchers("/contact", "/register/**")
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)

                .sessionManagement(smc -> smc.invalidSessionUrl("/invalidSession").maximumSessions(3).maxSessionsPreventsLogin(true))

                .requiresChannel(rcc -> rcc.anyRequest().requiresInsecure()) // Only HTTP

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/accounts").hasRole("USER")
                        .requestMatchers("/balance").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/loans").hasRole("USER")
                        .requestMatchers("/cards").hasRole("USER")
                        .requestMatchers("/notice", "/contact", "/error", "/actuator/**", "/swagger-ui/**", "/v3/api-docs/**",
                                "/actuator/health", "/register/**", "/invalidSession").permitAll());

        http.formLogin(withDefaults());
        http.httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * From Spring Security 6.3 version
     *
     * @return
     */
//    @Bean
//    public CompromisedPasswordChecker compromisedPasswordChecker() {
//        return new HaveIBeenPwnedRestApiPasswordChecker();
//    }
}
