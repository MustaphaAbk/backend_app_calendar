//filer/RateLimitFilter.java
package off.start.calendarapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.github.bucket4j.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String ip = request.getRemoteAddr();
        
        Bucket bucket = buckets.computeIfAbsent(ip, key -> 
            Bucket.builder()
                .addLimit(Bandwidth.simple(10, Duration.ofMinutes(1)))
                .build()
        );

if (bucket.tryConsume(1)) {
    filterChain.doFilter(request, response);
} else {
    response.setStatus(429); // HTTP 429 Too Many Requests
    response.setContentType("application/json");
    response.getWriter().write("{\"error\": \"Too many requests. Please try again later.\"}");
}
    }
}
