package com.github.skmitra.reactivesecurity;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Service;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@Service
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }


}
