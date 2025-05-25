package off.start.calendarapp.dto;

import off.start.calendarapp.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CalendarRepository extends JpaRepository<Calendar, UUID> {
}