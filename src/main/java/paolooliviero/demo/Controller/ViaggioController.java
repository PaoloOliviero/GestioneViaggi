package paolooliviero.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import paolooliviero.demo.Entities.Dipendente;
import paolooliviero.demo.Entities.Viaggio;
import paolooliviero.demo.Exceptions.BadRequestException;
import paolooliviero.demo.payloads.DipendentePayload;
import paolooliviero.demo.payloads.RisponstaDipendente;
import paolooliviero.demo.services.DipendenteService;
import paolooliviero.demo.services.ViaggioService;

import java.io.IOException;

public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;
    @Autowired
    private DipendenteService dipendenteService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public RisponstaDipendente saveViaggio(@RequestBody @Validated DipendentePayload body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().toString());
        }
        Viaggio newViaggio = viaggioService.save(body);
        return new RisponstaDipendente(newViaggio.getId());
    }

    @GetMapping("")
    public Page<Viaggio> getViaggio(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return viaggioService.getViaggio(page, size, sortBy);
    }

    @PutMapping("/{viaggioId}")
    public Viaggio findAndUpdate(@PathVariable int authorId, @RequestBody Dipendente body) {
        return viaggioService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{viaggioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int authorId) {
        viaggioService.findByIdAndDelete(authorId);
    }

    @PatchMapping("/{viaggioId}/avatar")
    public Viaggio uploadAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable int authorId) {
        try {
            return dipendenteService.uploadAvatar(authorId, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/{id}/stato")
    public Viaggio cambiaStato(@PathVariable int id, @RequestParam StatoViaggio stato) {
        return viaggioService.cambiaStato(id, stato);
    }

}
