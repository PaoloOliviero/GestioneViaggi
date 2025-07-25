package paolooliviero.demo.Entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Dipendente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String Profiloimmagine;

    public Dipendente(String username, String email, String cognome, String nome, int id) {
        this.username = username;
        this.email = email;
        this.cognome = cognome;
        this.nome = nome;
        this.id = id;
    }

    public  Dipendente() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfiloimmagine() {
        return Profiloimmagine;
    }

    public void setProfiloimmagine(String profiloimmagine) {
        Profiloimmagine = profiloimmagine;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setAvatar(@NotNull(message = "Il nome è obbligatorio") String s) {
    }

    public @NotNull(message = "Il nome è obbligatorio") String getAvatar() {
    }
}
