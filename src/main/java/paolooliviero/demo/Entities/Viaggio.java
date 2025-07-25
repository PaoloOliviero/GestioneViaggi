package paolooliviero.demo.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name="viaggio")
public class Viaggio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;
    private String destinazione;
    private LocalDate data;
    private StatoViaggio stato;

    public Viaggio(Long id, String destinazione, LocalDate data, StatoViaggio stato) {
        this.id = id;
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }

    public  Viaggio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public StatoViaggio getStato() {
        return stato;
    }

    public void setStato(StatoViaggio stato) {
        this.stato = stato;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
