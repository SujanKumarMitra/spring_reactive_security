package com.github.skmitra.reactivesecurity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@Service
@RequiredArgsConstructor
public class MongoDbUserDetailsService implements ReactiveUserDetailsService {

    private final AppUserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findById(username)
                .map(user -> toUserDetails(user));
    }

    private UserDetails toUserDetails(AppUser user) {
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
}
