package net.yorksolutions.auth;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepo extends CrudRepository<UserAccount, UUID> {

    Optional<UserAccount> findByUsername(String username);
}
