package com.github.skmitra.reactivesecurity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@DataMongoTest
@EnableMongoRepositories
class AppUserRepositoryTest {

    public static final String VALID_USERNAME = "valid_id";
    @Autowired
    private AppUserRepository repository;
    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        mongoTemplate
                .insert(new AppUser(VALID_USERNAME,"{noop}valid_password"))
                .block();
    }

    @Test
    void givenValidId_whenFetched_shouldFetchUser() {
        Mono<AppUser> appUserMono = repository.findById(VALID_USERNAME);

        StepVerifier.create(appUserMono)
                .expectNextCount(1)
                .expectComplete();
    }
}