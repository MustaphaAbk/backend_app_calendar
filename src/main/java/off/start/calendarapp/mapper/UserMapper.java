package off.start.calendarapp.mapper;

import org.mapstruct.Mapper;

import off.start.calendarapp.dto.UserRequestDto;
import off.start.calendarapp.dto.UserResponseDto;
import off.start.calendarapp.entity.User;

@Mapper(componentModel = "spring", uses = {ProfileMapper.class})
public interface UserMapper {
    User toEntity(UserRequestDto userRequestDto);
    UserRequestDto toDto(User user);
    UserResponseDto toResponseDto(User user);

}
