package paolooliviero.demo.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dataRichiesta;
    private String note;
    private String preferenze;

    @ManyToOne
    @JoinColumn (name= "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn (name= "viaggio_id")
    private Viaggio viaggio;

    public Prenotazione(LocalDate dataRichiesta, String note, String preferenze, Dipendente dipendente, Viaggio viaggio) {
        this.dataRichiesta = dataRichiesta;
        this.note = note;
        this.preferenze = preferenze;
        this.dipendente = dipendente;
        this.viaggio = viaggio;
    }

    public Prenotazione() {
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPreferenze() {
        return preferenze;
    }

    public void setPreferenze(String preferenze) {
        this.preferenze = preferenze;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }


}
