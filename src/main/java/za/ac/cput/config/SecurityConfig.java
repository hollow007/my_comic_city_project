package za.ac.cput.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import za.ac.cput.service.UserService.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler successHandler; // Inject the custom success handler

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Public routes
                        .requestMatchers("/", "/auth/login", "/login", "/signUp").permitAll() // Public routes
                        .requestMatchers(HttpMethod.POST, "/Customer/create", "/Contact/create").permitAll() // Allow customer sign-up
                        .requestMatchers(HttpMethod.POST, "/cart/assignCartToCustomer/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cart/assignCartToCustomer/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/wishList/assignWishListToCustomer/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/wishList/assignWishListToCustomer/**").permitAll()

                        // Expose only the read method
                        .requestMatchers(HttpMethod.GET, "/comic_book/read/**").permitAll() // Public access to read
                        .requestMatchers(HttpMethod.GET, "/comic_book/getAll").permitAll()

                        // Admin routes
                        .requestMatchers("/admin/**", "/genres/**",
                                "/comic_book/**", "/author/**",
                                "/Publisher/**").
                        hasRole("ADMIN")

                        // Customer routes

                        .requestMatchers("/customer/**").hasRole("CUSTOMER")

                        // Any other requests must be authenticated
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}




