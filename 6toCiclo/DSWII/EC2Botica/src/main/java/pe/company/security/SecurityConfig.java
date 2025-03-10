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
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
 
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
	    UserDetails admin = User.withUsername("gustavo")
	            .password(passwordEncoder.encode("777"))
	            .roles("ADMIN") // NO uses "ROLE_ADMIN"
	            .build();

	    UserDetails user = User.withUsername("luana")
	            .password(passwordEncoder.encode("444"))
	            .roles("USER") // NO uses "ROLE_USER"
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
	            .anyRequest().authenticated()
	        )
	        .csrf(csrf -> csrf.disable())  // Deshabilita CSRF
	        .httpBasic();  // Habilita autenticación básica

	    return http.build();
	}



 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}