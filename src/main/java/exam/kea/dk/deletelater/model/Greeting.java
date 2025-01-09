package exam.kea.dk.deletelater.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Greeting {

    private static final Logger log = LoggerFactory.getLogger(Greeting.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    // Optional: Store creation timestamp in the entity itself
    private LocalDateTime createdAt;

    public Greeting(String message) {
        this.message = message;
    }

    /**
     * This method is called automatically by JPA before the entity is persisted.
     */
    @PrePersist
    private void onCreate() {
        // Log the current time
        log.info("A new Greeting entity is about to be saved: '{}' at {}",
                message, LocalDateTime.now());

        // (Optional) if you want to store it as a field in the database:
        this.createdAt = LocalDateTime.now();
    }
}
