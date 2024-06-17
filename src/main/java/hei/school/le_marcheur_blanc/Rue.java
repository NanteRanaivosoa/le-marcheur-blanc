package hei.school.le_marcheur_blanc;

public class Rue {
    private Lieu debut;
    private Lieu fin;
    private String nom;

    public Rue(Lieu debut, Lieu fin, String nom) {
        this.debut = debut;
        this.fin = fin;
        this.nom = nom;
    }

    public Lieu getAutreExtremite(Lieu lieu) {
        return lieu.equals(debut) ? fin : debut;
    }

    @Override
    public String toString() {
        return nom == null ? "Rue sans nom" : nom;
    }
}
