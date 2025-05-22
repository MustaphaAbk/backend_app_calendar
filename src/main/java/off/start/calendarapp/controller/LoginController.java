//Controller/UserController.js
package off.start.calendarapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import off.start.calendarapp.dto.LoginRequestDto;
import off.start.calendarapp.dto.LoginResponseDto;
import off.start.calendarapp.dto.UserRequestDto;
import off.start.calendarapp.dto.UserResponseDto;
import off.start.calendarapp.service.UserService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {
    
    private final UserService userService;
    @PostMapping("/login")
public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
    LoginResponseDto response = userService.login(loginRequestDto);
    if ("Login successful".equals(response.getMessage())) {
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.status(401).body(response);
    }
}
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        // Call the service to create a new user
        UserResponseDto createdUser = userService.newUser(userRequestDto);
        // Return the created user as a response
        return ResponseEntity.ok(createdUser);
    }
    
}
