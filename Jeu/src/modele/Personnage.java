package modele;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Personnage implements KeyListener {
    private String nom;
    private int pv;
    private int dmg;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public interface Collection<Arme>{};
    private int posX;
    private int posY;
    private int vitesse;



    public Personnage(String nom, int pv, int dmg) {
        this.nom = nom;
        this.pv = pv;
        this.dmg = dmg;
        posX=150;  // A definir au milieu de l'écran j'ai mis une valeur random
        posY=150; //
        vitesse=10;
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

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getY() {
        return posY;
    }

    public void setY(int y) {
        this.posY = y;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPv() {
        return pv;
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", pv=" + pv +
                ", dmg=" + dmg +
                ", x=" + posX +
                ", y=" + posY +
                '}';
    }

    /*private Grille[][] seDeplacer(){
    }*/



}
