package paolooliviero.demo.payloads;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PrenotazionePayload(

        @NotNull(message = "La data di richiesta è obbligatoria")
        LocalDate dataRichiesta,

        @Size(max = 60, message = "Massimo 100 caratteri")
        String note,

        @Size(max = 10, message = "Massimo 100 caratteri")
        String preferenze,

        @NotNull(message = "L'ID è obbligatorio")
        Long dipendenteId,

        @NotNull(message = "L'ID è obbligatorio")
        Long viaggioId
) {}