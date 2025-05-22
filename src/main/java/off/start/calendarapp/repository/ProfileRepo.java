//repository/ProfileRepo.java
package off.start.calendarapp.repository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import off.start.calendarapp.entity.Profile;

public interface ProfileRepo extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByUserId(UUID userId);
}
