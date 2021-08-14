package com.github.skmitra.reactivesecurity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@Repository
public interface AppUserRepository extends ReactiveCrudRepository<AppUser,String> {
}
