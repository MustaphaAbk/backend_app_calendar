package off.start.calendarapp.mapper;

import org.mapstruct.Mapper;

import off.start.calendarapp.dto.ProfileDto;
import off.start.calendarapp.entity.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile toEntity(ProfileDto profileDto);
    ProfileDto toDto(Profile profile);
}
