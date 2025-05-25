package off.start.calendarapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Calendar extends BaseEntity {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Date is required")
    private String date;

    @NotNull(message = "Time is required")
    private String time;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "User ID is required")
    private String userId;
}
