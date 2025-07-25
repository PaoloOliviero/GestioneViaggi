package paolooliviero.demo.payloads;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import paolooliviero.demo.Entities.StatoViaggio;

import java.time.LocalDate;

public record ViaggioPayload(

        @NotNull(message = "La destinazione è obbligatoria")
        String destinazione,

        @NotNull(message = "La data è obbligatoria")
        @FutureOrPresent(message = "La data non può essere nel passato")
        LocalDate datapartenza,

        @NotNull(message = "Lo stato è obbligatorio")
        StatoViaggio stato
) {}