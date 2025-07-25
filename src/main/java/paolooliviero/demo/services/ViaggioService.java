package paolooliviero.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import paolooliviero.demo.Entities.Dipendente;
import paolooliviero.demo.Entities.StatoViaggio;
import paolooliviero.demo.Entities.Viaggio;
import paolooliviero.demo.Exceptions.NotFoundException;
import paolooliviero.demo.payloads.ViaggioPayload;
import paolooliviero.demo.repositories.DipendenteRep;
import paolooliviero.demo.repositories.ViaggioRep;

import java.time.LocalDate;
import java.util.List;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRep viaggioRepository;
    @Autowired
    private DipendenteService viaggioService;

    public Viaggio save(ViaggioPayload body) {
        Viaggio newViaggio = new Viaggio();
        newViaggio.setDestinazione(body.destinazione());
        newViaggio.setData(body.data());
        newViaggio.setStato(body.stato());
        newViaggio.setCover("http://picsum.photos/200/300");
        return viaggioRepository.save(newViaggio);


        public List<Viaggio> getViaggio () {
            return viaggioRepository.findAll();
        }

        public Viaggio findById ( int id){
            return viaggioRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        }

        public void findByIdAndDelete (int id){
            Viaggio found = this.findById(id);
            viaggioRepository.delete(found);
        }

        public Viaggio findByIdAndUpdate ( int id, ViaggioPayload body){
            Viaggio found = this.findById(id);
            found.setDestinazione(body.destinazione());
            found.setData(body.data());
            found.setStato(body.stato());
            return viaggioRepository.save(found)
        }

        public List<Viaggio> findByDipendente ( int authorId){
            Dipendente viaggio = viaggioService.findById(authorId);
            return viaggioRepository.findByDipendente(viaggio);
        }

        public Viaggio cambiaStato ( int id, StatoViaggio stato){
            Viaggio found = findById(id);
            found.setStato(stato);
            Viaggio modified = viaggioRepository.save(found);
            log.info("Stato viaggio con id: " + found.getId() + " modificato!");
            return modified;
        }


    }

}

