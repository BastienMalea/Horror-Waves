package model.manager;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Manager {
    //objet représenté sur la scene
    private Personnage joueur;
    private Timer timer;
    private Mouse mouse;
    private Ligne ligne;


    //calcul les collisions
    private Collisionneur collisionneur;
    //calcul les déplacements
    private Deplaceur deplaceurJoueur;
    private Deplaceur deplaceurMechant;
    private Deplaceur deplaceurProjectile;
    //calcul la droite pour le viseur
    private Calculateur calculateur;
    //raffraichit l'affichage du viseur
    private Afficheur afficheurViseur;
    //raffraichit l'affichage du joueur
    private Afficheur afficheurJoueur;
    //raffraichit l'affichage des monstre
    private Afficheur afficheurMonstre;
    //raffraichit la vie du joueur
    private EtatJoueur etatJoueur;
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
    //boucle pour gérer l'état du joueur
    private Boucleur boucleEtatJoueur;

    //Threads
    private Thread affichage;
    private Thread deplacement;
    private Thread temps;

    //Liste qui contient les threads
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

    //liste de rectangle projectiles
    private List<Rectangle> listeRectangleProjectile;
    //listeObservable contenant les monstres
    private ObservableList<Personnage> oListeProjectile;
    //propriété encapsulant la liste observable contenant les monstres
    private final ListProperty<Personnage> listeProjectile = new SimpleListProperty<Personnage>();
        public List<Personnage> getListeProjectile(){ return listeProjectile.get(); }
        public void setListeProjectile(ObservableList<Personnage> listeProjectile){ this.listeProjectile.set(listeProjectile); }
        public ListProperty<Personnage> listeProjectileProperty(){ return listeProjectile; }

    //controlleur de la vue de jeu
    private VueJeu vueJeu;



    public Manager(VueJeu vueJeu){
        this.vueJeu = vueJeu;

        //Création du joueur en position au centre de la fenêtre
        joueur = new Joueur(500, 300, 60, 60, 17.0/28.0, 1, 3);
        etatJoueur=new EtatJoueur(this);

        ligne = new Ligne(250, 200);
        mouse = new Mouse();
        timer = new Timer(0, 0);


        //Instanciation des collisionners + déplaceurs
        collisionneur = new CollisionneurClassique();
        deplaceurJoueur = new DeplaceurClassique(collisionneur, joueur);
        deplaceurMechant = new DeplaceurMechant(collisionneur, this);
        deplaceurProjectile = new DeplaceurProjectile(collisionneur, this);

        //Instanciation du calculateur
        calculateur = new Calculateur();
        //Instanciation des afficheurs
        afficheurViseur = new AfficheurViseur(calculateur, ligne, joueur, mouse);
        afficheurJoueur = new AfficheurPersonnage(this);
        afficheurMonstre = new AfficheurMonstre(this);

        //Instanciation de la liste Monstre
        oListeMonstre = FXCollections.observableArrayList();
        setListeMonstre(oListeMonstre);
        listeRectangle = new ArrayList<Rectangle>();
        //Création des monstres
        createurMonstre = new CreateurMonstre(this);

        //Instanciation de la liste des projectiles
        oListeProjectile = FXCollections.observableArrayList();
        setListeProjectile(oListeProjectile);
        listeRectangleProjectile = new ArrayList<Rectangle>();

        //Instanciation de la liste des threads
        listeThread = new ArrayList<Thread>();

        //Instanciation et ajout du timer aux observers de la boucle Temps
        boucleTemps = new BoucleTemps();
        boucleTemps.ajouterObservateur(timer);
        //Création du thread
        Thread temps=new Thread(boucleTemps);
        //Lancement du thread
        temps.start();
        //Ajout du thread dans la listeThread
        listeThread.add(temps);

        //Instanciation et ajout des deplaceurs aux observers de la boucle Deplacement
        boucleDeplacement = new BoucleDeplacement();
        boucleDeplacement.ajouterObservateur(deplaceurJoueur);
        boucleDeplacement.ajouterObservateur(deplaceurMechant);
        boucleDeplacement.ajouterObservateur(deplaceurProjectile);
        //Création du thread
        Thread deplacement=new Thread(boucleDeplacement);
        //Lancement du thread
        deplacement.start();
        //Ajout du thread dans la listeThread
        listeThread.add(deplacement);

        //Instanciation et ajout des afficheurs aux observers de la boucle affichage
        boucleAffichage = new BoucleAffichage();
        boucleAffichage.ajouterObservateur(afficheurViseur);
        boucleAffichage.ajouterObservateur(afficheurJoueur);
        boucleAffichage.ajouterObservateur(afficheurMonstre);
        //Création du thread et ajout de celui-ci dans la listeThread
        Thread affichage=new Thread(boucleAffichage);
        //Lancement du thread
        affichage.start();
        //Ajout du thread dans la listeThread
        listeThread.add(affichage);

        //Instanciation et ajout du créateurMonstre aux observers de la boucle Jeu
        boucleJeu = new BoucleJeu();
        boucleJeu.ajouterObservateur(createurMonstre);
        //Création du thread et ajout de celui-ci dans la listeThread
        Thread jeu = new Thread(boucleJeu);
        //Lancement du thread
        jeu.start();
        //Ajout du thread dans la listeThread
        listeThread.add(jeu);

        //Instanciation et ajout de l'état du Joueur aux observers de la boucle EtatJoueur
        boucleEtatJoueur = new BoucleEtatJoueur();
        boucleEtatJoueur.ajouterObservateur(etatJoueur);
        Thread etat = new Thread(boucleEtatJoueur);
        //Lancement du thread
        etat.start();
        //Ajout du thread dans la listeThread
        listeThread.add(etat);
    }

    /**
     * crée un monstre et son rectangle associé dans la scene et l'ajoute à la liste de monstre / liste de rectangle du manager
     * @param x position du monstre en x
     * @param y position du monstre en y
     * @param type type de monstre (3 types possibles actuellement)
     */
    public void creerMonstre(double x, double y, int type){
        Image img;
        switch(type){
            case 0:
                oListeMonstre.add(new Monstre(x,y,50,50,20.0/27.0 , 1, 1, 0));
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
                oListeMonstre.add(new Monstre(x,y,50,50, 20.0/27.0, 1, 1, 2));
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

    /**
     * crée un projectile et son rectangle associé dans la scene et l'ajoute à la liste de projectile / liste de rectangleProjectile du manager
     * @param x position du monstre en x
     * @param y position du monstre en y
     * @param xMouse position de la souris pour connaitre la direction du projectile (droite ou gauche)
     */
    public void creerProjectile(double x, double y, double xMouse){
        int direction = 1;
        if(x > xMouse) direction = -1;
        oListeProjectile.add(new Projectile(x, y, 10, 10, 1, 1, calculateur.getA(), calculateur.getB(), direction));
        Image img = new Image("Image/Perso/Rock1.png",
                oListeProjectile.get(oListeProjectile.size()-1).getHauteur(), oListeProjectile.get(oListeProjectile.size()-1).getLargeur(),
                false, true);
        setListeProjectile(oListeProjectile);
        listeRectangleProjectile.add(new Rectangle());
        listeRectangleProjectile.get(listeRectangleProjectile.size()-1).setId(String.valueOf(listeRectangleProjectile.size()-1));
        listeRectangleProjectile.get(listeRectangleProjectile.size()-1).xProperty().bind(oListeProjectile.get(oListeProjectile.size()-1).posXProperty());
        listeRectangleProjectile.get(listeRectangleProjectile.size()-1).yProperty().bind(oListeProjectile.get(oListeProjectile.size()-1).posYProperty());
        listeRectangleProjectile.get(listeRectangleProjectile.size()-1).heightProperty().bind(oListeProjectile.get(oListeProjectile.size()-1).hauteurProperty());
        listeRectangleProjectile.get(listeRectangleProjectile.size()-1).widthProperty().bind(oListeProjectile.get(oListeProjectile.size()-1).largeurProperty());
        listeRectangleProjectile.get(listeRectangleProjectile.size()-1).setFill(new ImagePattern(img));
        vueJeu.getListeProjectileVue().getChildren().add(listeRectangleProjectile.get(listeRectangleProjectile.size()-1));
    }

    /**
     * Méthode qui stop les thread une fois que le joueur à 0 points de vies
     * et lance le stage "GameOver.fxml"
     */
    public void stopPartie(){
        if(joueur.getPv()==0){
            for(Thread thread: listeThread){
                thread.stop();
            }

            Parent racine = null;
            try {
                racine = FXMLLoader.load(Launch.class.getResource("/FXML/GameOver.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(racine);
            scene.getStylesheets().addAll(this.getClass().getResource("/FXML/style.css").toExternalForm());
            Launch.getPrimaryStage().setScene(scene);
        }

    }

    /**
     * get qui retourne le joueur
     */
    public Personnage getJoueur(){
        return joueur;
    }


    /**
     * get qui retourne le colisionneur
     */
    public Collisionneur getCollisionneur(){
        return collisionneur;
    }

    /**
     * get qui retourne le deplaceurClassique
     */
    public DeplaceurClassique getDeplaceur(){return (DeplaceurClassique) deplaceurJoueur;}

    /**
     * get qui retourne le curseur
     */
    public Mouse getMouse(){
        return mouse;
    }

    /**
     * get qui retourne le timer
     */
    public Timer getTimer(){
        return timer;
    }

    /**
     * get qui retourne la ligne
     */
    public Ligne getLigne(){
        return ligne;
    }

    /**
     * get qui retourne la vueJeu
     */
    public VueJeu getVueJeu(){
        return vueJeu;
    }

    /**
     * get qui retourne l'afficheur
     */
    public Afficheur getAfficheurMonstre(){
        return afficheurMonstre;
    }

    /**
     * get qui retourne le calculateur
     */
    public Calculateur getCalculateur(){
        return calculateur;
    }

    /**
     * get qui retourne la liste de Rectangle
     */
    public List<Rectangle> getListeRectangle(){
        return listeRectangle;
    }

    /**
     * get qui retourne la liste des rectangles pour les projectiles
     */
    public List<Rectangle> getListeRectangleProjectile(){
        return listeRectangleProjectile;
    }

}
