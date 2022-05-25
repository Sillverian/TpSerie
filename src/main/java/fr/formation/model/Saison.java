package fr.formation.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Saison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private int annee;
    private int nbEpisodes;

    @OneToOne(cascade = CascadeType.ALL)
    private Realisateur realisateur;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Acteur> acteurs;

    public Saison() {
    }

    public Saison(int numero, int annee, int nbEpisodes, Realisateur realisateur, List<Acteur> acteurs) {
        this.numero = numero;
        this.annee = annee;
        this.nbEpisodes = nbEpisodes;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbEpisodes() {
        return nbEpisodes;
    }

    public void setNbEpisodes(int nbEpisodes) {
        this.nbEpisodes = nbEpisodes;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "\n        Saison " + numero + " : \n" +
                "            - annee : " + annee + "\n" +
                "            - nbEpisodes : " + nbEpisodes + "\n" +
                "            realisateur : " + realisateur + "\n" +
                "            acteurs : " + acteurs + "\n";
    }
}
