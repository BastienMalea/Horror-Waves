package model.deplacement;

import javafx.application.Platform;
import model.entite.Personnage;
import model.entite.Projectile;
import model.manager.Manager;

/**
 * Classe qui va gérer le déplacement des projectiles
 */

public class DeplaceurProjectile extends Deplaceur{
    //Vitesse de déplacement du projectile
    private double STEP = 10.0;
    private Manager manager;

    public DeplaceurProjectile(Collisionneur collisionneur, Manager manager){
        super(collisionneur);
        this.manager = manager;
    }

    /**
     * Méthode update qui va vérifier le déplacement des projectiles
     */
    @Override
    public void update() {
        //Vérification que la liste projectile n'est pas vide
        if(!manager.getListeProjectile().isEmpty()){
            //Parcours de la liste des projectiles
            for(Personnage projectile: manager.getListeProjectile()){
                //Set la nouvelle position du projectile
                projectile.setPosX(projectile.getPosX() + STEP*((Projectile) projectile).getDirection());
                projectile.setPosY(manager.getCalculateur().calculProjectileY(((Projectile)projectile).getA(), ((Projectile)projectile).getB(), projectile.getPosX()));
                //Parcours de la liste de monstre
                for(Personnage monstre: manager.getListeMonstre()){
                    //S'il y a collision entre un projectile et un monstre :
                    //-Suppresion du monstre de la listeMonstre
                    //-Suppresion du projectile de la listeProjectile
                    if(manager.getCollisionneur().isCollisionEntity(projectile, monstre)){
                        Platform.runLater(() -> manager.getListeRectangle().get(manager.getListeMonstre().indexOf(monstre)).setVisible(false));
                        Platform.runLater(() -> manager.getListeRectangle().remove(manager.getListeMonstre().indexOf(monstre)));
                        Platform.runLater(() -> manager.getListeMonstre().remove(monstre));
                        Platform.runLater(() -> manager.getListeRectangleProjectile().get(manager.getListeProjectile().indexOf(projectile)).setVisible(false));
                        Platform.runLater(() -> manager.getListeRectangleProjectile().remove(manager.getListeProjectile().indexOf(projectile)));
                        Platform.runLater(() -> manager.getListeProjectile().remove(projectile));
                    }
                }
                //S'il ya collision entre un projectile et la fenêtre Principale :
                //-Suppresion du projectile de la listeProjectile +
                if(manager.getCollisionneur().isCollisionMonstreWindow(projectile.getPosX(), projectile.getPosY(), projectile)){
                    Platform.runLater(() -> manager.getListeRectangleProjectile().get(manager.getListeProjectile().indexOf(projectile)).setVisible(false));
                    Platform.runLater(() -> manager.getListeRectangleProjectile().remove(manager.getListeProjectile().indexOf(projectile)));
                    Platform.runLater(() -> manager.getListeProjectile().remove(projectile));
                }
            }
        }
    }
}
