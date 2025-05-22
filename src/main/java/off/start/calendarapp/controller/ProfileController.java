//Controller/profilController.js
package off.start.calendarapp.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import off.start.calendarapp.dto.ProfileDto;
import off.start.calendarapp.entity.Profile;
import off.start.calendarapp.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileDto profileDto) {
        Profile createdProfile = profileService.newProfile(profileDto);
        return ResponseEntity.ok(createdProfile);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<ProfileDto> getProfile(@RequestParam UUID user_id) {
        ProfileDto profileDto = profileService.getProfileById(user_id);
        return profileDto != null
                ? ResponseEntity.ok(profileDto)
                : ResponseEntity.notFound().build();
    }
}
