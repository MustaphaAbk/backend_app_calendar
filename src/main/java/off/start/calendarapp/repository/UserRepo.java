//repository/UserRepo.java
package off.start.calendarapp.repository;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import off.start.calendarapp.entity.User;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
