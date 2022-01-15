package views;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import launcher.Launch;
import model.manager.Manager;


public class VueJeu extends AnchorPane {

    @FXML
    private Rectangle joueurVue;

    @FXML
    private Label timer;


    private Manager manager;

    @FXML
    public void initialize(){
        manager = new Manager();
        StringConverter<Number> converter = new NumberStringConverter();

        joueurVue.xProperty().bind(manager.getJoueur().posXProperty());
        joueurVue.yProperty().bind(manager.getJoueur().posYProperty());
        joueurVue.heightProperty().bind(manager.getJoueur().hauteurProperty());
        joueurVue.widthProperty().bind(manager.getJoueur().largeurProperty());

        Bindings.bindBidirectional(timer.textProperty(), manager.getTimer().tempsProperty(), converter);


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

    }


}
