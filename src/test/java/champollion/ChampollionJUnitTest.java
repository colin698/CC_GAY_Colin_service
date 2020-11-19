package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	@Test
        public void testHeuresPrevues(){
            untel.ajouteEnseignement(uml, 10, 6, 4);
            untel.ajouteEnseignement(java, 10, 6, 4);
            assertEquals(24, untel.heuresPrevues(), "Il y a 48h de cours de prévues");
        }
        
                @Test
        public void testHeuresPlanifiees(){
            Salle salle = new Salle("Salle B105", 20);
            Intervention inter = new Intervention(salle, java, untel, new Date(), 4, TypeIntervention.CM);
            untel.ajouteIntervention(inter); //!!a refaire si j'ai le tps avant de rendre
            assertEquals(4, untel.heuresPlanifiees(), "l'enseigant a 4h de cours de prévues"); 
       }
        
        @Test
        public void testSousService(){
             untel.ajouteEnseignement(uml, 60, 50, 30);
            assertEquals(true, untel.enSousService(), "L'enseignant est en sous-service");
            untel.ajouteEnseignement(uml, 100, 70, 50);
            assertEquals(false, untel.enSousService(), "L'enseignant n'est pas en sous-service");
        }

        @Test
        public void testHeuresPrevuesPourUe(){
            untel.ajouteEnseignement(uml, 2, 4, 4);
            untel.ajouteEnseignement(java, 2, 4, 4);
            assertEquals(10, untel.heuresPrevuesPourUE(uml), "10h de cours sont prévues");
            assertEquals(10, untel.heuresPrevuesPourUE(java), "10h de cours sont prévues");
        }
        

        
        
        
}

