package view;

import javafx.scene.layout.BorderPane;
import launch.Launch;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.beans.EventHandler;
import java.security.Key;

public class FenetreSimple extends BorderPane {

    private Rectangle personnageView;
    private Rectangle mechantView;
    private Manager manager = new manager;

    public FenetreSimple() {
        super();
    }

    public void initialize(){
        personnageView=creationView(manager.getPersoPrincipal(), Color.)

        personnageView=new Rectangle(0,0, Color.BROWN);
        personnageView.layoutXProperty().bind(manager.getPersoPrincipal().xProperty());
        personnageView.layoutYProperty().bind(manager.getPersoPrincipal().YProperty());
        personnageVeiw.widthProperty().bind(manager.getPersoPrincipal().largeurProperty());
        personnageVeiw.widthProperty().bind(manager.getPersoPrincipal().largeurProperty());

        panelDeJeu.getChildren().add{personnageView};

        mechantView=new Rectangle(0,0, Color.BROWN);
        mechantView.layoutXProperty().bind(manager.getPersoPrincipal().xProperty());
        mechantView.layoutYProperty().bind(manager.getPersoPrincipal().YProperty());
        mechantView.widthProperty().bind(manager.getPersoPrincipal().largeurProperty());
        mechantView.widthProperty().bind(manager.getPersoPrincipal().largeurProperty());

        panelDeJeu.getChildren().add{personnageView};

        Launch.getPrimaryStage().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>);
            @Override
                    public void handle(KeyEvent event){
                        manager.deplacerPersonnagePrincipal(event.getCode);
        }

        manager.getCollisionner().hauteurFenetrePreperty().bind(LAunch.getPrmarySatge(.heightProperty()));
        manager.getCollisionner().hauteurFenetrePreperty().bind(LAunch.getPrmarySatge(.heightProperty()));

        private Rectangle creationDesVIew(Entite e, Color couleur){
            Rectangle retour = new Rectangle();
            retour.layoutlayoutXProperty().bind(e.xProperty());
            personnageView.layoutYProperty().bind(.YProperty());
            personnageVeiw.widthProperty().bind(manager.getPersoPrincipal().largeurProperty());
            personnageVeiw.widthProperty().bind(manager.getPersoPrincipal().largeurProperty());

            return retour;
        }
    }
}
