package model.manager;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.affichage.Afficheur;
import model.affichage.AfficheurMonstre;
import model.affichage.AfficheurPersonnage;
import model.affichage.AfficheurViseur;
import model.boucle.*;
import model.affichage.EtatJoueur;
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
import java.util.Map;


public class Manager {
    //objet représenté sur la scene
    private Personnage joueur;
    private Timer timer;
    private Mouse mouse;
    private Ligne ligne;
    private EtatJoueur etatJoueur;

    //calcul les collisions
    private Collisionneur collisionneur;
    //calcul les déplacements
    private Deplaceur deplaceurJoueur;
    private Deplaceur deplaceurMechant;
    //calcul la droite pour le viseur
    private Calculateur calculateur;
    //raffraichit l'affichage du viseur
    private Afficheur afficheurViseur;
    //raffraichit l'affichage du joueur
    private Afficheur afficheurJoueur;
    //raffraichit l'affichage des monstre
    private Afficheur afficheurMonstre;
    //crée les monstres aléatoirement sur la scene
    private CreateurMonstre createurMonstre;

    //boucle pour le chrono
    private Boucleur boucleTemps;
    //boucle pour les déplacements
    private Boucleur boucleDeplacement;
    //boucle pour l'affichage
    private Boucleur boucleAffichage;
    //boucle pour la génération de monstre
    private Boucleur boucleJeu;

    //Threads
    private Thread affichage;
    private Thread deplacement;
    private Thread temps;
    private List<Thread> listeThread;

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

        joueur = new Joueur(500, 300, 60, 60, 17.0/28.0, 1, 3);
        etatJoueur=new EtatJoueur(this);

        ligne = new Ligne(250, 200);
        mouse = new Mouse();
        timer = new Timer(0, 0);

        collisionneur = new CollisionneurClassique();
        deplaceurJoueur = new DeplaceurClassique(collisionneur, joueur);
        deplaceurMechant = new DeplaceurMechant(collisionneur, this);

        calculateur = new Calculateur();
        afficheurViseur = new AfficheurViseur(calculateur, ligne, joueur, mouse);
        afficheurJoueur = new AfficheurPersonnage(this);
        afficheurMonstre = new AfficheurMonstre(this);

        oListeMonstre = FXCollections.observableArrayList();
        setListeMonstre(oListeMonstre);
        listeRectangle = new ArrayList<Rectangle>();
        createurMonstre = new CreateurMonstre(this);

        listeThread = new ArrayList<Thread>();

        boucleTemps = new BoucleTemps();
        boucleTemps.ajouterObservateur(timer);
        Thread temps=new Thread(boucleTemps);
        temps.start();
        listeThread.add(temps);

        boucleDeplacement = new BoucleDeplacement();
        boucleDeplacement.ajouterObservateur(deplaceurJoueur);
        boucleDeplacement.ajouterObservateur(deplaceurMechant);
        Thread deplacement=new Thread(boucleDeplacement);
        deplacement.start();
        listeThread.add(deplacement);

        boucleAffichage = new BoucleAffichage();
        boucleAffichage.ajouterObservateur(afficheurViseur);
        boucleAffichage.ajouterObservateur(afficheurJoueur);
        boucleAffichage.ajouterObservateur(afficheurMonstre);
        boucleAffichage.ajouterObservateur(etatJoueur);
        Thread affichage=new Thread(boucleAffichage);
        affichage.start();
        listeThread.add(affichage);

        boucleJeu = new BoucleJeu();
        boucleJeu.ajouterObservateur(createurMonstre);
        Thread jeu = new Thread(boucleJeu);
        jeu.start();
        listeThread.add(jeu);
    }


    public void creerMonstre(double x, double y, int type){
        Image img;
        switch(type){
            case 0:
                oListeMonstre.add(new Monstre(x,y,50,50, 22.0/26.0, 1, 1, 0));
                img = new Image("Image/MechantPetit/Tiny.png",
                        oListeMonstre.get(oListeMonstre.size()-1).getHauteur(), oListeMonstre.get(oListeMonstre.size()-1).getLargeur(),
                        false, true);
                break;
            case 1:
                oListeMonstre.add(new Monstre(x,y,50,50, 20.0/27.0, 1, 1, 1));
                img = new Image("Image/MechantRouge/Red.png",
                        oListeMonstre.get(oListeMonstre.size()-1).getHauteur(), oListeMonstre.get(oListeMonstre.size()-1).getLargeur(),
                        false, true);
                break;
            case 2:
                oListeMonstre.add(new Monstre(x,y,50,50, 27.0/30.0, 1, 1, 2));
                img = new Image("Image/Ours/Bear.png",
                        oListeMonstre.get(oListeMonstre.size()-1).getHauteur(), oListeMonstre.get(oListeMonstre.size()-1).getLargeur(),
                        false, true);
                break;
            default:
                oListeMonstre.add(new Monstre(x,y,50,50, 27.0/30.0, 1, 1, 2));
                img = new Image("Image/Ours/Bear2.png",
                        oListeMonstre.get(oListeMonstre.size()-1).getHauteur(), oListeMonstre.get(oListeMonstre.size()-1).getLargeur(),
                        false, true);
                break;
        }
        setListeMonstre(oListeMonstre);
        listeRectangle.add(new Rectangle());
        listeRectangle.get(listeRectangle.size()-1).setId(String.valueOf(listeRectangle.size()-1));
        listeRectangle.get(listeRectangle.size()-1).xProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).posXProperty());
        listeRectangle.get(listeRectangle.size()-1).yProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).posYProperty());
        listeRectangle.get(listeRectangle.size()-1).heightProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).hauteurProperty());
        listeRectangle.get(listeRectangle.size()-1).widthProperty().bind(oListeMonstre.get(oListeMonstre.size()-1).largeurProperty());
        listeRectangle.get(listeRectangle.size()-1).setFill(new ImagePattern(img));
        vueJeu.getListeMonstreVue().getChildren().add(listeRectangle.get(listeRectangle.size()-1));
    }

    public void stopPartie(){
        if(joueur.getPv()==0){
            for(Thread thread: listeThread){
                thread.stop();
            }

        }

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

    public VueJeu getVueJeu(){
        return vueJeu;
    }

    public Afficheur getAfficheurMonstre(){
        return afficheurMonstre;
    }

}
