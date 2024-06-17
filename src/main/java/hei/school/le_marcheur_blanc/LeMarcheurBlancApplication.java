package hei.school.le_marcheur_blanc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LeMarcheurBlancApplication implements CommandLineRunner {

	@Autowired
	private MarcheurBlanc marcheurBlanc;

	public static void main(String[] args) {
		SpringApplication.run(LeMarcheurBlancApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			List<Lieu> chemin = marcheurBlanc.marcher("HEI", "ESTI");
			System.out.println("Le marcheur blanc a suivi le chemin suivant pour atteindre ESTI :");
			for (Lieu lieu : chemin) {
				System.out.println(lieu);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
