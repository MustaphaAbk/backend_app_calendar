package off.start.calendarapp.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import off.start.calendarapp.dto.ProfileDto;
import off.start.calendarapp.entity.Profile;
import off.start.calendarapp.mapper.ProfileMapper;
import off.start.calendarapp.repository.ProfileRepo;

@Service
@Data
@AllArgsConstructor @NoArgsConstructor
public class ProfileService {
    
    private  ProfileRepo profileRepo;
    private  ProfileMapper profileMapper;

    @Transactional
    public Profile newProfile(ProfileDto profileDto) {
        Profile profile = profileMapper.toEntity(profileDto);
        return profileRepo.save(profile);
    }

    @Transactional
    public ProfileDto getProfileById(UUID user_id) {
        Profile profile = profileRepo.findByUser_id(user_id);
        if (profile != null) {
            return profileMapper.toDto(profile);
        } else {
            return null; // or throw an exception
        }
    }
}
