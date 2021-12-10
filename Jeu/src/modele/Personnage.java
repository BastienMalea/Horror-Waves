package modele;

import com.sun.source.tree.Tree;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.util.Map;
import java.util.TreeMap;

public class Personnage implements KeyListener {
    private String nom;
    private int pv;
    private int posX;
    private int posY;
    private int vitesse;

    public Personnage(String nom, int pv, int posX, int posY, int vitesse) {
        this.nom = nom;
        this.pv = pv;
        this.posX = posX;  // A definir au milieu de l'écran j'ai mis une valeur random
        this.posY = posY;  //
        this.vitesse = vitesse;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public int getX() {
        return posX;
    }
    public void setX(int x) {
        this.posX = x;
    }

    public int getY() {
        return posY;
    }
    public void setY(int y) {
        this.posY = y;
    }

    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }
    public int getPv() {
        return pv;
    }


    /*private Grille[][] seDeplacer(){
    }*/



}
