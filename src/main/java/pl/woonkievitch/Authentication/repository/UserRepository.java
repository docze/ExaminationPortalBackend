package pl.woonkievitch.Authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.woonkievitch.Authentication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
