package masterIL.example.RestBDDSpringBoot.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
@Scope("prototype")
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String auteur;
    private String resume;


    public Serie(){

    }

    public Serie(String nom, String auteur, String resume){
        this.nom = nom;
        this.auteur = auteur;
        this.resume = resume;
    }

    public Serie(int id, String nom, String auteur, String resume){
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.resume = resume;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String name) {
        this.nom = name;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String author) {
        this.auteur = author;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", auteur='" + auteur + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
