package hei.school.le_marcheur_blanc;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class LeMarcheurBlancApplicationTests {

	@Autowired
	private MarcheurBlanc marcheurBlanc;

	@Autowired
	private Carte carte;

	@Test
	void contextLoads() {
		assertNotNull(marcheurBlanc);
		assertNotNull(carte);
	}

	@Test
	void testMarcheurBlancDepuisHEIAEsti() {
		Lieu lieuDeDepart = carte.getLieu("HEI");
		assertNotNull(lieuDeDepart, "Le lieu de départ HEI devrait exister dans la carte.");

		List<Lieu> chemin = marcheurBlanc.marcher("HEI", "ESTI");
		assertFalse(chemin.isEmpty(), "Le chemin ne devrait pas être vide.");
		assertEquals("HEI", chemin.get(0).getNom(), "Le premier lieu du chemin devrait être HEI.");
		assertEquals("ESTI", chemin.get(chemin.size() - 1).getNom(), "Le dernier lieu du chemin devrait être ESTI.");

		// Vérifier que chaque lieu du chemin est connecté par une rue valide
		for (int i = 0; i < chemin.size() - 1; i++) {
			Lieu actuel = chemin.get(i);
			Lieu suivant = chemin.get(i + 1);
			assertTrue(estConnecte(actuel, suivant),
					"Les lieux " + actuel.getNom() + " et " + suivant.getNom() + " devraient être connectés.");
		}
	}

	private boolean estConnecte(Lieu lieu1, Lieu lieu2) {
		return lieu1.getRues().stream()
				.anyMatch(rue -> rue.getAutreExtremite(lieu1).equals(lieu2));
	}

}
