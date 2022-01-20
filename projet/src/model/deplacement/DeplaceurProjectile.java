package model.deplacement;

import javafx.application.Platform;
import model.entite.Personnage;
import model.entite.Projectile;
import model.manager.Manager;

public class DeplaceurProjectile extends Deplaceur{
    private double STEP = 10.0;
    private Manager manager;

    public DeplaceurProjectile(Collisionneur collisionneur, Manager manager){
        super(collisionneur);
        this.manager = manager;
    }

    @Override
    public void update() {
        if(!manager.getListeProjectile().isEmpty()){
            for(Personnage projectile: manager.getListeProjectile()){
                projectile.setPosX(projectile.getPosX() + STEP*((Projectile) projectile).getDirection());
                projectile.setPosY(manager.getCalculateur().calculProjectileY(((Projectile)projectile).getA(), ((Projectile)projectile).getB(), projectile.getPosX()));
                for(Personnage monstre: manager.getListeMonstre()){
                    if(manager.getCollisionneur().isCollisionEntity(projectile, monstre)){
                        Platform.runLater(() -> manager.getListeRectangle().get(manager.getListeMonstre().indexOf(monstre)).setVisible(false));
                        Platform.runLater(() -> manager.getListeRectangle().remove(manager.getListeMonstre().indexOf(monstre)));
                        Platform.runLater(() -> manager.getListeMonstre().remove(monstre));
                        Platform.runLater(() -> manager.getListeRectangleProjectile().get(manager.getListeProjectile().indexOf(projectile)).setVisible(false));
                        Platform.runLater(() -> manager.getListeRectangleProjectile().remove(manager.getListeProjectile().indexOf(projectile)));
                        Platform.runLater(() -> manager.getListeProjectile().remove(projectile));
                    }
                }
                if(manager.getCollisionneur().isCollisionMonstreWindow(projectile.getPosX(), projectile.getPosY(), projectile)){
                    Platform.runLater(() -> manager.getListeRectangleProjectile().get(manager.getListeProjectile().indexOf(projectile)).setVisible(false));
                    Platform.runLater(() -> manager.getListeRectangleProjectile().remove(manager.getListeProjectile().indexOf(projectile)));
                    Platform.runLater(() -> manager.getListeProjectile().remove(projectile));
                }
            }
        }
    }
}
