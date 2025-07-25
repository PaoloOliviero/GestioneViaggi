package paolooliviero.demo.repositories;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import paolooliviero.demo.Entities.Dipendente;

import java.util.Optional;

public interface DipendenteRep extends JpaRepository<Dipendente, Integer> {

    Optional<Object> findByEmail(@NotNull(message = "L'email è obbligatoria") String email);
}
