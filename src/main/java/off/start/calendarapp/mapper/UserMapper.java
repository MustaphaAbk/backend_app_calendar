package off.start.calendarapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import off.start.calendarapp.dto.UserRequestDto;
import off.start.calendarapp.dto.UserResponseDto;
import off.start.calendarapp.entity.User;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class})
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "password", source = "password")
    User toEntity(UserRequestDto userRequestDto);

    @Mapping(target = "profile", ignore = true)
    UserResponseDto toResponseDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void updateUserFromDto(UserRequestDto dto, @MappingTarget User entity);
}
