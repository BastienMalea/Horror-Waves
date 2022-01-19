package model.manager;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Rectangle;
import model.affichage.Afficheur;
import model.affichage.AfficheurViseur;
import model.boucle.BoucleAffichage;
import model.boucle.BoucleDeplacement;
import model.boucle.BoucleTemps;
import model.boucle.Boucleur;

import model.deplacement.Collisionneur;
import model.deplacement.CollisionneurClassique;
import model.deplacement.Deplaceur;
import model.deplacement.DeplaceurClassique;
import model.entite.*;

import model.deplacement.*;
import model.entite.Joueur;
import model.entite.Monstre;
import model.entite.Personnage;
import model.entite.Timer;
import views.VueJeu;

import java.util.ArrayList;
import java.util.List;


public class Manager {
    //objet représenté sur la scene
    private Personnage joueur;
    private Personnage monstre;
    private Timer timer;
    private Mouse mouse;
    private Ligne ligne;

    //calcul les collisions
    private Collisionneur collisionneur;
    //calcul les déplacements
    private Deplaceur deplaceurJoueur;
    private Deplaceur deplaceurMechant;
    //calcul la droite pour le viseur
    private Calculateur calculateur;
    //raffraichit l'affichage du viseur
    private Afficheur afficheurViseur;

    //boucle pour le chrono
    private Boucleur boucleTemps;
    //boucle pour les déplacements
    private Boucleur boucleDeplacement;
    //boucle pour l'affichage
    private Boucleur boucleAffichage;

    //liste de rectangle monstres
    private List<Rectangle> listeRectangle;
    //listeObservable contenant les monstres
    private ObservableList<Personnage> oListeMonstre;
    //propriété encapsulant la liste observable contenant les monstres
    private final ListProperty<Personnage> listeMonstre = new SimpleListProperty<Personnage>();
        public List<Personnage> getListeMonstre(){ return listeMonstre.get(); }
        public void setListeMonstre(ObservableList<Personnage> listeMonstre){ this.listeMonstre.set(listeMonstre); }
        public ListProperty<Personnage> listeMonstreProperty(){ return listeMonstre; }

    //controlleur de la vue de jeu
    private VueJeu vueJeu;



    public Manager(VueJeu vueJeu){
        this.vueJeu = vueJeu;

        joueur = new Joueur(250, 200, 20, 20);
        monstre = new Monstre(15,15,10,10);
        ligne = new Ligne(250, 200);
        mouse = new Mouse();
        timer = new Timer(0, 0);

        collisionneur = new CollisionneurClassique();
        deplaceurJoueur = new DeplaceurClassique(collisionneur, joueur);
        deplaceurMechant = new DeplaceurMechant(collisionneur, this);

        calculateur = new Calculateur();
        afficheurViseur = new AfficheurViseur(calculateur, ligne, joueur, mouse);

        oListeMonstre = FXCollections.observableArrayList();
        listeRectangle = new ArrayList<Rectangle>();

        creerMonstre(10, 10);
        creerMonstre(100, 100);
        creerMonstre(200, 200);
        creerMonstre(300, 300);
        creerMonstre(400, 400);


        boucleTemps = new BoucleTemps();
        boucleTemps.ajouterObservateur(timer);
        new Thread(boucleTemps).start();

        boucleDeplacement = new BoucleDeplacement();
        boucleDeplacement.ajouterObservateur(deplaceurJoueur);
        boucleDeplacement.ajouterObservateur(deplaceurMechant);
        new Thread(boucleDeplacement).start();

        boucleAffichage = new BoucleAffichage();
        boucleAffichage.ajouterObservateur(afficheurViseur);
        new Thread(boucleAffichage).start();

    }

    public void creerMonstre(double x, double y){
        oListeMonstre.add(new Monstre(x,y,10,10));
        setListeMonstre(oListeMonstre);
        listeRectangle.add(new Rectangle());
        listeRectangle.get(listeRectangle.size()-1).setId(String.valueOf(listeRectangle.size()-1));
        listeRectangle.get(listeRectangle.size()-1).xProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).posXProperty());
        listeRectangle.get(listeRectangle.size()-1).yProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).posYProperty());
        listeRectangle.get(listeRectangle.size()-1).heightProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).hauteurProperty());
        listeRectangle.get(listeRectangle.size()-1).widthProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).largeurProperty());
        vueJeu.getListeMonstreVue().getChildren().add(listeRectangle.get(listeRectangle.size()-1));
    }

    public Personnage getJoueur(){
        return joueur;
    }

    public Collisionneur getCollisionneur(){
        return collisionneur;
    }

    public DeplaceurClassique getDeplaceur(){return (DeplaceurClassique) deplaceurJoueur;}

    public Mouse getMouse(){
        return mouse;
    }

    public Timer getTimer(){
        return timer;
    }

    public Ligne getLigne(){
        return ligne;
    }

}
