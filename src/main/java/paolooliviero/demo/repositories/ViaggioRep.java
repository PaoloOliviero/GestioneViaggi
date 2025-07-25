package paolooliviero.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paolooliviero.demo.Entities.Prenotazione;

public interface ViaggioRep extends JpaRepository<Prenotazione, Integer> {

}
