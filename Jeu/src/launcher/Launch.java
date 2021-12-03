package launcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import modele.Arme;
import modele.Monstre;
import modele.Munition;
import modele.Personnage;


public class Launch extends Application {

    public static void main(String[] args) {
        Monstre m1 = new Monstre("zombie", 2, 5, 20);
        System.out.println(m1);
        Munition mun1 = new Munition("mun1", 6);
        System.out.println(mun1);
        Arme a1 = new Arme("pistolet", 3, 6, 10);
        System.out.println(a1);
        Personnage p1 = new Personnage("Antoine", 10, 1, 150, 150, 10);
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
