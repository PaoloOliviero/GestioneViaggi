package paolooliviero.demo.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DipendentePayload(

        @NotNull(message = "L'ID è obbligatorio")
        Integer id,

        @NotNull(message = "Lo username è obbligatorio")
        String cognome,

        @NotNull(message = "Il nome è obbligatorio")
        String nome,

        @NotNull(message = "Il nome è obbligatorio")
        String usarname,

        @NotNull(message = "L'email è obbligatoria")
        String email
) {}