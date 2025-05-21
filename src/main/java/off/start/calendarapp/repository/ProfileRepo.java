package off.start.calendarapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import off.start.calendarapp.entity.Profile;


public interface ProfileRepo extends JpaRepository<Profile, UUID>{
     Profile findByUser_id(UUID user_id);
}
