//entity/profile.js
package off.start.calendarapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
public class Profile extends BaseEntity {

    @Column(name = "user_id") // maps to the DB column `user_id`
    private UUID userId;       // valid Java field name

    @Column(name = "status")   // lowercase to follow standard naming conventions
    private String status;

    @Column(name = "hours_per_day")
    private int hoursPerDay;
}
