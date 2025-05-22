package off.start.calendarapp.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
