package champollion;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Enseignant extends Personne {

    private ArrayList<ServicePrevu> servPrevu = new ArrayList<>();
    private LinkedList<Intervention> interventions = new LinkedList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int equivalentTD = 0;
        for (ServicePrevu sp : servPrevu){
            equivalentTD += 1.5 * sp.getVolumeCM();
            equivalentTD += 0.75 * sp.getVolumeTP();
            equivalentTD += sp.getVolumeTD();
            
        }
            return Math.round(equivalentTD);
        
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int equivalentTD = 0;
        for (ServicePrevu spUE : servPrevu){
            if (spUE.getU().equals(ue)){
            equivalentTD += 1.5 * spUE.getVolumeCM();
            equivalentTD += 0.75 * spUE.getVolumeTP();
            equivalentTD += spUE.getVolumeTD();
            }
            
        }
            return Math.round(equivalentTD);
        
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu service = new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue);
        servPrevu.add(service);
          
    }
        
    public boolean enSousService(){
        if (heuresPrevues()< 192){
            return true;
        }else{
            return false;
        }
    }
    
     public void ajouteIntervention(Salle s, UE u, Enseignant e, Date debut, int duree, TypeIntervention type){
        Intervention inter = new Intervention(s, u, e, debut, duree, type);
        interventions.add(inter);
    }
    
    public int heuresPlanifiees(){
        int heurePlanif = 0;
        for (int i=0 ; i < interventions.size() ; i++){
            switch (interventions.get(i).getType()){
                case CM:
                    heurePlanif += interventions.get(i).getDuree()* 1.5;
                    break;
                case TP:
                    heurePlanif += interventions.get(i).getDuree()* 0.75;
                    break;
                case TD:
                    heurePlanif += interventions.get(i).getDuree();
                    break;
                    
            }
            
        }
        return Math.round(heurePlanif);
    }
    
    }
