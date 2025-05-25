//Controller/UserController.js
package off.start.calendarapp.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import off.start.calendarapp.dto.UserResponseDto;
import off.start.calendarapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@RequestParam UUID id) {
        return userService.getuserbyID(id) != null
                ? ResponseEntity.ok(userService.getuserbyID(id))
                : ResponseEntity.notFound().build();
    }
    
    
}
