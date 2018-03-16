package pl.woonkievitch.Authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.woonkievitch.Authentication.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
