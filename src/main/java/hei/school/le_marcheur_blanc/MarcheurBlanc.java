package hei.school.le_marcheur_blanc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MarcheurBlanc {
    private final Carte carte;

    public MarcheurBlanc(Carte carte) {
        this.carte = carte;
    }

    public List<Lieu> marcher(String departNom, String destinationNom) {
        Lieu depart = carte.getLieu(departNom);
        if (depart == null) {
            throw new IllegalArgumentException("Le lieu de départ n'existe pas.");
        }

        List<Lieu> chemin = new ArrayList<>();
        Random rand = new Random();
        Lieu actuel = depart;

        while (!actuel.getNom().equals(destinationNom)) {
            chemin.add(actuel);
            List<Rue> rues = actuel.getRues();
            if (rues.isEmpty()) {
                throw new IllegalStateException("Impasse, impossible de continuer.");
            }
            Rue rueSuivante = rues.get(rand.nextInt(rues.size()));
            actuel = rueSuivante.getAutreExtremite(actuel);
        }

        chemin.add(actuel); // Ajouter la destination finale
        return chemin;
    }
}
