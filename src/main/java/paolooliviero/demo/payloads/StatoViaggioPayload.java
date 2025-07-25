package paolooliviero.demo.payloads;

import jakarta.validation.constraints.NotNull;
import paolooliviero.demo.Entities.StatoViaggio;

public record StatoViaggioPayload(

		@NotNull(message = "Lo stato è obbligatorio")
		StatoViaggio stato
) {}

