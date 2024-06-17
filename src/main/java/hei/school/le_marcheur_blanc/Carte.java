package hei.school.le_marcheur_blanc;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Carte {
    private Map<String, Lieu> lieux;

    public Carte() {
        lieux = new HashMap<>();
        initialiserCarte();
    }

    private void initialiserCarte() {
        // Créer les lieux
        Lieu marais = new Lieu("Marais");
        Lieu seikolintsika = new Lieu("Sekolintsika");
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu balancoire = new Lieu("Balançoire");
        Lieu nexta = new Lieu("Nexta");
        Lieu esti = new Lieu("ESTI");
        Lieu boulevardDeLEurope = new Lieu("Boulevard de l'Europe");

        // Ajouter les lieux à la carte
        lieux.put(marais.getNom(), marais);
        lieux.put(seikolintsika.getNom(), seikolintsika);
        lieux.put(hei.getNom(), hei);
        lieux.put(pullman.getNom(), pullman);
        lieux.put(balancoire.getNom(), balancoire);
        lieux.put(nexta.getNom(), nexta);
        lieux.put(esti.getNom(), esti);
        lieux.put(boulevardDeLEurope.getNom(), boulevardDeLEurope);

        // Créer les rues
        Rue rue1 = new Rue(marais, seikolintsika, null);
        Rue rue2 = new Rue(seikolintsika, hei, null);
        Rue rue3 = new Rue(hei, pullman, "Rue Andriantsihoarana");
        Rue rue4 = new Rue(hei, balancoire, null);
        Rue rue5 = new Rue(pullman, balancoire, "Rue Ranaivo");
        Rue rue6 = new Rue(pullman, nexta, null);
        Rue rue7 = new Rue(balancoire, esti, null);
        Rue rue8 = new Rue(balancoire, boulevardDeLEurope, null);
        Rue rue9 = new Rue(boulevardDeLEurope, esti, null);

        // Ajouter les rues aux lieux
        marais.ajouterRue(rue1);
        seikolintsika.ajouterRue(rue1);
        seikolintsika.ajouterRue(rue2);
        hei.ajouterRue(rue2);
        hei.ajouterRue(rue3);
        hei.ajouterRue(rue4);
        pullman.ajouterRue(rue3);
        pullman.ajouterRue(rue5);
        pullman.ajouterRue(rue6);
        balancoire.ajouterRue(rue4);
        balancoire.ajouterRue(rue5);
        balancoire.ajouterRue(rue7);
        balancoire.ajouterRue(rue8);
        nexta.ajouterRue(rue6);
        boulevardDeLEurope.ajouterRue(rue8);
        boulevardDeLEurope.ajouterRue(rue9);
        esti.ajouterRue(rue7);
        esti.ajouterRue(rue9);
    }

    public Lieu getLieu(String nom) {
        return lieux.get(nom);
    }
}
