package paolooliviero.demo.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import paolooliviero.demo.payloads.RisponstaDipendente;
import paolooliviero.demo.repositories.DipendenteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import paolooliviero.demo.Entities.Dipendente;
import paolooliviero.demo.Exceptions.BadRequestException;
import paolooliviero.demo.Exceptions.NotFoundException;
import paolooliviero.demo.payloads.DipendentePayload;
import paolooliviero.demo.repositories.DipendenteRep;

import java.io.IOException;

@Service
public class DipendenteService {
    @Autowired
    private Cloudinary cloudinaryUploader;

    @Autowired
    private DipendenteRep DipendenteRep;


    public Dipendente save(DipendentePayload body) throws IOException {
        DipendenteRep.findByEmail(body.email()).ifPresent(user -> {
            throw new paolooliviero.demo.Exceptions.BadRequestException("L'email " + body.email() + " è già stata utilizzata");
        });
        Dipendente newDipendente = new Dipendente();
        newDipendente.setAvatar("https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());
        newDipendente.setNome(body.nome());
        newDipendente.setCognome(body.cognome());
        newDipendente.setEmail(body.email());

        return DipendenteRep.save(newDipendente);
    }

    public static Page<Dipendente> getDipendente(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return RisponstaDipendente.findAll(pageable);
    }

    public Dipendente findById(int id) {
        return DipendenteRep.findById(id).orElseThrow(() -> new paolooliviero.demo.Exceptions.NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        Dipendente found = this.findById(id);
        DipendenteRep.delete(found);
    }

    public Dipendente findByIdAndUpdate(int id, Dipendente body) {

        Dipendente found = this.findById(id);
        found.setEmail(body.getEmail());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setAvatar(body.getAvatar());
        return DipendenteRep.save(found);
    }

    public Dipendente uploadAvatar(int id, MultipartFile file) throws IOException {
        Dipendente found = this.findById(id);
        String avatarURL = (String) cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
        found.setAvatar(avatarURL);
        return DipendenteRep.save(found);
    }
}





