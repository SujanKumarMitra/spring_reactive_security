package com.github.skmitra.reactivesecurity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@Repository
public interface AppUserRepository extends ReactiveCrudRepository<AppUser, String> {
}
