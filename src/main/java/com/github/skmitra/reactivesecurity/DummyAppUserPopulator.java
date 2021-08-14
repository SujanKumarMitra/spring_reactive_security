package com.github.skmitra.reactivesecurity;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@Component
@RequiredArgsConstructor
@Profile("dummy")
public class DummyAppUserPopulator implements CommandLineRunner {

    private final AppUserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Flux<String> usernames = Flux
                .just("user1", "user2", "user3");

        Flux<String> passwords = Flux
                .just("password1", "password2", "password3")
                .map(p -> "{noop}" + p);

        repository.deleteAll()
                .doOnRequest(v -> System.out.println("flushed repository"))
                .thenMany(usernames)
                .zipWith(passwords, AppUser::new)
                .flatMap(repository::save)
                .doOnNext(user -> System.out.println("Saved: " + user))
                .blockLast();
    }
}
