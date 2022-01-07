package launcher;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import modele.hitbox.Hitbox;
import modele.management.Manager;


public class Launch extends Application {

    /*
    public static void main(String[] args) {
        Monstre m1 = new Monstre("zombie", 2, 5, 20, 1,1);
        System.out.println(m1);
        Munition mun1 = new Munition("mun1", "lien vers image", 6);
        System.out.println(mun1);
        Arme a1 = new Arme(typeArme.DISTANCE, "lien vers image", "pistolet", 3, 6, 10);
        System.out.println(a1);
        Joueur j1 = new Joueur("Antoine", 10, 1, 150, 20, 6);
        System.out.println(j1);
        Power p1=new Power("boissonEnergisante", "lien vers fichier", "BoostVitesse", 1.5f, 60);
        System.out.println(p1);
        Deplaceur d = new Deplaceur();
        d.seDeplacer(j1.getX()+4, j1.getY(), j1);
        System.out.println(j1);

        Manager manager = new Manager();
        manager.afficherListePersonnage();

        Hitbox h1 = new Hitbox();
        h1.addRectangle(30, 20);
        h1.addRectangle(20, 30);
        h1.addRectangle(25, 25);
        System.out.println(h1);
    }
    */

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine= FXMLLoader.load(getClass().getResource("/FXML/vueJeu.fxml"));
        Scene scene = new Scene(racine);

        Manager manager = new Manager();


        manager.jeu(scene);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
