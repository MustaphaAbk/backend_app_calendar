package off.start.calendarapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import off.start.calendarapp.entity.Calendar;
import off.start.calendarapp.dto.CalendarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarRepository calendarRepository;

    // Rate limiter: 5 requests per minute
    private final Bucket bucket = Bucket.builder()
            .addLimit(Bandwidth.builder()
                    .capacity(5)
                    .refillGreedy(5, Duration.ofMinutes(1))
                    .build())
            .build();

    @PostMapping("/")
    public ResponseEntity<?> createCalendar(@Valid @RequestBody Calendar calendar) {
        if (!bucket.tryConsume(1)) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .body("Too many requests - please wait and try again.");
        }
        return ResponseEntity.ok(calendarRepository.save(calendar));
    }

    @GetMapping("/")
    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }
}
