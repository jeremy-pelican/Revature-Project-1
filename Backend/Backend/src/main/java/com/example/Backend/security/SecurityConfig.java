package com.example.Backend.security;

import com.example.Backend.entity.Account;
import com.example.Backend.repository.AccountRepository;
import com.example.Backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    private final AccountService accountService;
    private final JWTFilter jwtFilter;

    public SecurityConfig(AccountService accountService, JWTFilter jwtFilter) {
        this.accountService = accountService;
        this.jwtFilter = jwtFilter;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            Optional<Account> account = accountRepository.findByUsername(username);
//            if (account == null) {
//                throw new UsernameNotFoundException("User not found");
//            }
//            return org.springframework.security.core.userdetails.User
//                    .withUsername(account.get().getUsername())
//                    .password(account.get().getPassword())
//                    .build();
//        };
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults())
//                .authenticationManager(new AuthenticationManager() {
//                    @Override
//                    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                        return null;
//                    }
//                });
//        return http.build();
//    }

    @Autowired private AccountRepository accountRepository;
    @Autowired private JWTFilter filter;
    @Autowired private MyAccountService acts;


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .httpBasic().disable()
//                .cors()
//                .and()
//                .authorizeHttpRequests()
//                .
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf((csrf -> csrf.disable()))
//                .authorizeHttpRequests((authorizeRequests -> authorizeRequests.requestMatchers("/login").permitAll()
//                        .anyRequest().authenticated()
//                ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//    }
}
