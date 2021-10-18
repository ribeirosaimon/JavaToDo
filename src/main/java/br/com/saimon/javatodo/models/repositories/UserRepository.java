package br.com.saimon.javatodo.models.repositories;

import br.com.saimon.javatodo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByLogin(String login);
}
