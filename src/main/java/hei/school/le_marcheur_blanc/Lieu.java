package hei.school.le_marcheur_blanc;

import java.util.ArrayList;
import java.util.List;

public class Lieu {
    private String nom;
    private List<Rue> rues;

    public Lieu(String nom) {
        this.nom = nom;
        this.rues = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterRue(Rue rue) {
        rues.add(rue);
    }

    public List<Rue> getRues() {
        return rues;
    }

    @Override
    public String toString() {
        return nom;
    }
}
