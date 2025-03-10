package pe.company.security;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig {
 
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User.withUsername("anthony")
                .password(passwordEncoder.encode("a123"))
                .roles("ADMIN")
                .build();
 
        UserDetails user = User.withUsername("walter")
                .password(passwordEncoder.encode("w123"))
                .roles("USER")
                .build();
 
        return new InMemoryUserDetailsManager(admin, user);
    }
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/listar_public").permitAll()
                .requestMatchers("/listar_admin").hasRole("ADMIN")
                .requestMatchers("/listar_user").hasRole("USER")
                .anyRequest().authenticated() // Cualquier otra petición requiere autenticación
            )
            .csrf(csrf -> csrf.disable());
 
        return http.build();
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}