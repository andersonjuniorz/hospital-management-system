package br.com.hospitalmanagementsystem.hospitalmanagementsystem.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
 * CLASSE RESPONSAVEL PELA SEGURANCA E AUTORIZACOES DE ROTAS
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        /*.requestMatchers("/static/**", "/layout/**").permitAll()*/

                        //Authentication rotes
                        .requestMatchers(HttpMethod.POST,"api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"api/auth/cadastrar-paciente").permitAll()
                        .requestMatchers(HttpMethod.POST,"api/auth/cadastrar-usuario").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/usuarios").hasRole("ADMIN")


                        .anyRequest().authenticated()
                )

                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
