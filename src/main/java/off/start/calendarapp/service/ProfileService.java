//service/profileService.java
package off.start.calendarapp.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import off.start.calendarapp.dto.ProfileDto;
import off.start.calendarapp.entity.Profile;
import off.start.calendarapp.mapper.ProfileMapper;
import off.start.calendarapp.repository.ProfileRepo;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepo profileRepo;
    private final ProfileMapper profileMapper;

    @Transactional
    public Profile newProfile(ProfileDto profileDto) {
        Profile profile = profileMapper.toEntity(profileDto);
        return profileRepo.save(profile);
    }

    @Transactional
    public ProfileDto getProfileById(UUID userId) {
        return profileRepo.findByUserId(userId)
                .map(profileMapper::toDto)
                .orElse(null); // or throw custom NotFoundException
    }
}
