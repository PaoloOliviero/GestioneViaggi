package paolooliviero.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import paolooliviero.demo.Entities.Prenotazione;
import paolooliviero.demo.Entities.Viaggio;

public interface ViaggioRep extends JpaRepository<Viaggio, Integer> {

}
