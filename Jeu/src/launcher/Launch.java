package launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import modele.deplaceur.Deplaceur;
import modele.item.Arme;
import modele.item.Munition;
import modele.item.Power;
import modele.item.typeArme;
import modele.management.Manager;
import modele.personnage.Joueur;
import modele.personnage.Monstre;


public class Launch extends Application {

    public static void main(String[] args) {
        /*Monstre m1 = new Monstre("zombie", 2, 5, 20, 1,1);
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
        System.out.println(j1);*/

        Manager manager = new Manager();
        manager.afficherListePersonnage();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine= FXMLLoader.load(getClass().getResource("/FXML/test.fxml"));
        Scene scene=new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
