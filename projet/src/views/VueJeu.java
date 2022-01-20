package views;

import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import launcher.Launch;
import model.entite.Monstre;
import model.entite.Personnage;
import model.manager.Manager;

import javax.swing.text.html.ImageView;

/**
 * Controller de la vue du jeu pendant une partie
 */
public class VueJeu extends AnchorPane {

    //Rectangle qui représente le joueur
    @FXML
    private Rectangle joueurVue;

    //Groupe qui represente la liste de Monstre
    @FXML
    private Group listeMonstreVue;

    //Le timer
    @FXML
    private Label timer;

    //Les points de vies
    @FXML
    private Label ptsDeVie;

    //Le viseur qui est la ligne
    @FXML
    private Line viseur;

    //La liste projectile Vue
    @FXML
    private Group listeProjectileVue;

    //Le manager
    private Manager manager;


    @FXML
    public void initialize(){
        manager = new Manager(this);

        //Instanciation de l'image a la place du rectangle avec les bonnes dimensions
        Image img = new Image("Image/Perso/Pink_Monster.png",
                manager.getJoueur().getHauteur(), manager.getJoueur().getLargeur(),
                false, true);
        joueurVue.setFill(new ImagePattern(img));

        //Convertisseur string en Number
        StringConverter<Number> converter = new NumberStringConverter();

        //Binding des proprietes du joueur sur le rectangle
        joueurVue.xProperty().bind(manager.getJoueur().posXProperty());
        joueurVue.yProperty().bind(manager.getJoueur().posYProperty());
        joueurVue.heightProperty().bind(manager.getJoueur().hauteurProperty());
        joueurVue.widthProperty().bind(manager.getJoueur().largeurProperty());

        //Bind des pts de vie du joueur ainsi que du timer
        Bindings.bindBidirectional(ptsDeVie.textProperty(), manager.getJoueur().pvProperty(), converter);
        Bindings.bindBidirectional(timer.textProperty(), manager.getTimer().tempsProperty(), converter);

        //Bind du points de départ de la ligne et de la fin de celle-ci en X Y
        viseur.startXProperty().bind(manager.getJoueur().posCentreXProperty());
        viseur.startYProperty().bind(manager.getJoueur().posCentreYProperty());
        viseur.endXProperty().bind(manager.getLigne().posEndLineXProperty());
        viseur.endYProperty().bind(manager.getLigne().posEndLineYProperty());

        //Bind des propriétés du collisionneur sur la hauteur et largeur de la fenêtre
        manager.getCollisionneur().hauteurFenetreProperty().bind(Launch.getPrimaryStage().heightProperty());
        manager.getCollisionneur().largeurFenetreProperty().bind(Launch.getPrimaryStage().widthProperty());


        //Appel de la méthode ajouterTouche quand une touche est appuyée
        Launch.getPrimaryStage().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                manager.getDeplaceur().ajouterTouche(event.getCode());
            }
        });

        //Appel de la méthode supprimerTouche quand une touche est lachée
        Launch.getPrimaryStage().addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                manager.getDeplaceur().supprimerTouche(event.getCode());
            }
        });

        //Appel de la méthode updateCoordonnees lorsque le cursor bouge
        Launch.getPrimaryStage().addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                manager.getMouse().updateCoordonnees(event.getSceneX(), event.getSceneY());
            }
        });

        //Appel de la méthode creerProjectile lorsque on appuie sur la souris
        Launch.getPrimaryStage().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY) {
                    manager.creerProjectile(joueurVue.getX(), joueurVue.getY(), event.getSceneX());
                    //System.out.println(event.getButton());
                }
            }
        });


    }

    //Get de la listeMonstre
    public Group getListeMonstreVue(){
        return listeMonstreVue;
    }

    //Get de la listeProjectile
    public Group getListeProjectileVue(){
        return listeProjectileVue;
    }

    //Get du rectangle qui représente le joueur
    public Rectangle getJoueurVue(){
        return joueurVue;
    }


}
