package br.com.saimon.javatodo.UsersConfig;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository {
    Optional<AppUser> findByEmail(String email);
}
