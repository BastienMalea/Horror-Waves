package model.deplacement;

import javafx.scene.input.KeyCode;
import model.entite.Personnage;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui va déplacer les personnages
 */
public class DeplaceurClassique extends Deplaceur{
    //Vitesse du Personnage Joueur
    private double STEP = 6.0;
    //Instanciation d'une liste de touche
    private List<KeyCode> listeTouche = new ArrayList<KeyCode>();
    private Personnage joueur;

    public DeplaceurClassique(Collisionneur collisionneur, Personnage joueur){
        super(collisionneur);
        this.joueur = joueur;
    }

    /**
     * Méthode qui ajoute la touche à la liste de Touche si elle n'est pas déjà contenu dans la liste
     * @param code touche appuyée
     */
    public void ajouterTouche(KeyCode code){
        if(!listeTouche.contains(code))
            listeTouche.add(code);
    }

    /**
     * Méthode qui supprime la touche de la liste si elle est dans la liste
     * @param code
     */
    public void supprimerTouche(KeyCode code){
        if(listeTouche.contains(code))
            listeTouche.remove(code);
    }


    /**
     * Méthode update du déplaceur
     */
    @Override
    public void update() {
        //Réduction de la vitesse lorsque deux touches sont appuyés en même temps (déplacement diagonal)
        if(listeTouche.size() == 2){
            STEP = (STEP*5)/6;
        }
        //Si on appuie sur la flèche UP, on déplace le joueur vers le haut
        if(listeTouche.contains(KeyCode.UP))
            //Verification qu'il n'y ait pas collision entre le joueur et la fenêtre du milieu
            if(!collisionneur.isCollision(joueur.getPosX(), joueur.getPosY() - STEP, joueur))
                joueur.setPosY(joueur.getPosY() - STEP);
        //Si on appuie sur la flèche DOWN, on déplace le joueur vers le bas
        if(listeTouche.contains(KeyCode.DOWN))
            //Verification qu'il n'y ait pas collision entre le joueur et la fenêtre du milieu
            if(!collisionneur.isCollision(joueur.getPosX(), joueur.getPosY() + STEP, joueur))
                joueur.setPosY(joueur.getPosY() + STEP);
        //Si on appuie sur la flèche LEFT, on déplace le joueur vers la gauche
        if(listeTouche.contains(KeyCode.LEFT))
            //Verification qu'il n'y ait pas collision entre le joueur et la fenêtre du milieu
            if(!collisionneur.isCollision(joueur.getPosX() - STEP, joueur.getPosY(), joueur))
                joueur.setPosX(joueur.getPosX() - STEP);
        //Si on appuie sur la flèche RIGHT, on déplace le joueur vers la droite
        if(listeTouche.contains(KeyCode.RIGHT))
            //Verification qu'il n'y ait pas collision entre le joueur et la fenêtre du milieu
            if(!collisionneur.isCollision(joueur.getPosX() + STEP, joueur.getPosY(), joueur))
                joueur.setPosX(joueur.getPosX() + STEP);

        if(listeTouche.size() == 2){
            STEP = (STEP*6)/5;
        }
    }
}
