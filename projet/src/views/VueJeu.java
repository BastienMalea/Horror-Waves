package views;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import launcher.Launch;
import model.manager.Manager;

import javax.swing.text.html.ImageView;


public class VueJeu extends AnchorPane {

    @FXML
    private Rectangle joueurVue;

    @FXML
    private Group listeMonstreVue;

    @FXML
    private Label timer;

    @FXML
    private Line viseur;

    @FXML
    private Group listeProjectileVue;


    private Manager manager;


    @FXML
    public void initialize(){
        manager = new Manager(this);

        Image img = new Image("Image/Perso/Pink_Monster.png",
                manager.getJoueur().getHauteur(), manager.getJoueur().getLargeur(),
                false, true);
        joueurVue.setFill(new ImagePattern(img));



        StringConverter<Number> converter = new NumberStringConverter();

        joueurVue.xProperty().bind(manager.getJoueur().posXProperty());
        joueurVue.yProperty().bind(manager.getJoueur().posYProperty());
        joueurVue.heightProperty().bind(manager.getJoueur().hauteurProperty());
        joueurVue.widthProperty().bind(manager.getJoueur().largeurProperty());


        Bindings.bindBidirectional(timer.textProperty(), manager.getTimer().tempsProperty(), converter);

        viseur.startXProperty().bind(manager.getJoueur().posCentreXProperty());
        viseur.startYProperty().bind(manager.getJoueur().posCentreYProperty());
        viseur.endXProperty().bind(manager.getLigne().posEndLineXProperty());
        viseur.endYProperty().bind(manager.getLigne().posEndLineYProperty());

        manager.getCollisionneur().hauteurFenetreProperty().bind(Launch.getPrimaryStage().heightProperty());
        manager.getCollisionneur().largeurFenetreProperty().bind(Launch.getPrimaryStage().widthProperty());


        Launch.getPrimaryStage().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                manager.getDeplaceur().ajouterTouche(event.getCode());
            }
        });

        Launch.getPrimaryStage().addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                manager.getDeplaceur().supprimerTouche(event.getCode());
            }
        });

        Launch.getPrimaryStage().addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.getMouse().updateCoordonnees(event.getSceneX(), event.getSceneY());
            }
        });

        Launch.getPrimaryStage().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getButton());
            }
        });


    }

    public Group getListeMonstreVue(){
        return listeMonstreVue;
    }


}
