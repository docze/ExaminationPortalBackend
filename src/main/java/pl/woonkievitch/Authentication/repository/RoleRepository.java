package pl.woonkievitch.Authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.woonkievitch.Authentication.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
