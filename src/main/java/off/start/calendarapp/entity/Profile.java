package off.start.calendarapp.entity;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
public class Profile extends BaseEntity{

    @Column(name = "user_id")
    private UUID user_id;

    @Column(name = "Status")
    private String status;

    @Column(name = "hours_per_day")
    private int hoursPerDay;
}
