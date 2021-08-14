package com.github.skmitra.reactivesecurity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@RestController
public class PingRestController {

    @GetMapping("/ping")
    public Mono<String> ping() {
        return Mono.just("pong");
    }

    @GetMapping("/ping/self")
    public Mono<User> pingSelf(@AuthenticationPrincipal User user) {
        return Mono.just(user);
    }
}
