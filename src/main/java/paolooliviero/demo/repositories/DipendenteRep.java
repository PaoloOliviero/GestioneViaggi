package paolooliviero.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paolooliviero.demo.Entities.Dipendente;

public interface DipendenteRep extends JpaRepository<Dipendente, Integer> {

}
