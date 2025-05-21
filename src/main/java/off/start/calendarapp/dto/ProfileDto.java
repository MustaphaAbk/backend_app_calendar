package off.start.calendarapp.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private UUID id;
    private String createdBy;
    private String updatedBy;
    private Instant createdAt;   
    private Instant updatedAt;
    private UUID user_id;
    private String status;
    private int hoursPerDay;
}
