package br.com.saimon.javatodo.usersConfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
