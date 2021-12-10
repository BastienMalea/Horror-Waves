package launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import modele.*;


public class Launch extends Application {

    public static void main(String[] args) {
        Monstre m1 = new Monstre("zombie", 2, 5, 20, 1,1);
        System.out.println(m1);
        Munition mun1 = new Munition("mun1", 6);
        System.out.println(mun1);
        Arme a1 = new Arme(typeArme.DISTANCE, "pistolet", 3, 6, 10);
        System.out.println(a1);
        Joueur j1 = new Joueur("Antoine", 10, 1, 150, 150, 6);
        System.out.println(j1);
        Power p1=new Power("boissonEnergisante", "BoostVitesse", 1.5f, 60);
        System.out.println(p1);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine= FXMLLoader.load(getClass().getResource("/FXML/test.fxml"));
        Scene scene=new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
