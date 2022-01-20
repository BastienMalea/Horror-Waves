package views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import launcher.Launch;
import model.manager.Manager;

import javax.swing.text.Position;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class VueMenu {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Manager manager;

    @FXML
    public void initialize(){
        //Jsp comment on met un background pour la scene
        /*Background bg = new Background(,"Image/MenuBackground.png");
        ImageView background = new ImageView(bg.getImage());
        background.setFitHeight(bg.getHeight());
        background.setFitWidth(bg.getWidth());
        background.setX(bg.getPos().getX());
        background.setY(bg.getPos().getY());
        gameBp.getChildren().add(0,background);*/
    }
    //Quand l'utilisateur clique sur le bouton "JOUER"
    public void lancerPartie(javafx.event.ActionEvent actionEvent) {
        manager.getNavigateur().navigateTo("vueJeu", Launch.getPrimaryStage());
    }
}
