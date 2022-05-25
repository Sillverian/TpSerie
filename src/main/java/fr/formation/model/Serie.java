package fr.formation.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Saison> saisons;

    public Serie() {
    }

    public Serie(String titre, List<Saison> saisons) {
        this.titre = titre;
        this.saisons = saisons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Saison> getSaisons() {
        return saisons;
    }

    public void setSaisons(List<Saison> saisons) {
        this.saisons = saisons;
    }

    @Override
    public String toString() {
        return "Serie "+ id +"\n" +
                "    - titre='" + titre + "'\n" +
                "    saisons=" + saisons +
                '}';
    }
}
