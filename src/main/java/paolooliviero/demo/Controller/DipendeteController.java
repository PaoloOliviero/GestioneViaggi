package paolooliviero.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import paolooliviero.demo.Entities.Dipendente;
import paolooliviero.demo.Exceptions.BadRequestException;
import paolooliviero.demo.payloads.DipendentePayload;
import paolooliviero.demo.payloads.RisponstaDipendente;
import paolooliviero.demo.services.DipendenteService;

import java.io.IOException;

public class DipendeteController {

    @Autowired
    private DipendenteService dipendenteService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public RisponstaDipendente saveDipendente(@RequestBody @Validated DipendentePayload body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().toString());
        }
        Dipendente newDipendente = dipendenteService.save(body);
        return new RisponstaDipendente(newDipendente.getId());
    }

    @GetMapping("")
    public Page<Dipendente> getDipendente(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return DipendenteService.getDipendente(page, size, sortBy);
    }

    // 4. - PUT http://localhost:3001/authors/{id} (+ req.body)
    @PutMapping("/{dipendenteId}")
    public Dipendente findAndUpdate(@PathVariable int authorId, @RequestBody Dipendente body) {
        return dipendenteService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int authorId) {
        dipendenteService.findByIdAndDelete(authorId);
    }

    @PatchMapping("/{authorId}/avatar")
    public Dipendente uploadAvatar(@RequestParam("avatar") MultipartFile file, @PathVariable int authorId) {
        try {
            return dipendenteService.uploadAvatar(authorId, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}








}
