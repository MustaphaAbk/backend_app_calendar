package off.start.calendarapp.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import off.start.calendarapp.dto.UserRequestDto;
import off.start.calendarapp.dto.UserResponseDto;
import off.start.calendarapp.entity.User;
import off.start.calendarapp.mapper.UserMapper;
import off.start.calendarapp.repository.UserRepo;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Transactional
    public UserResponseDto newUser(UserRequestDto userRequestDto) {
        // Convert UserRequestDto to User entity
        User user=userMapper.toEntity(userRequestDto);
        // Save the user entity to the database
        userRepo.save(user);
        // Convert the saved User entity to UserResponseDto
        UserResponseDto userResponseDto=userMapper.toResponseDto(user);
        // Return the UserResponseDto
        return userResponseDto;
    }

    @Transactional
    public UserResponseDto getuserbyID(UUID id){
        //find user by id
        User user=userRepo.findById(id).orElse(null);
        //convert user to userResponseDto
        UserResponseDto userResponseDto=userMapper.toResponseDto(user);
        //return userResponseDto
        return userResponseDto;
    }
}
