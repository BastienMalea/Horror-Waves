package modele;

import com.sun.source.tree.Tree;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.util.Map;
import java.util.TreeMap;

public class Personnage implements KeyListener {
    private String nom;
    private int pv;
    private int dmg;
    private TreeMap<Integer, Arme> listeArme;
    private int posX;
    private int posY;
    private int vitesse;

    public Personnage(String nom, int pv, int dmg, int posX, int posY, int vitesse) {
        this.nom = nom;
        this.pv = pv;
        this.dmg = dmg;
        this.posX = posX;  // A definir au milieu de l'écran j'ai mis une valeur random
        this.posY = posY;  //
        this.vitesse = vitesse;
        this.listeArme = new TreeMap<Integer, Arme>();
        listeArme.put(0, new Arme("poing", 1, -1, 1));
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




    public String afficherListeArme(TreeMap<Integer, Arme> listeArme){
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Integer, Arme> entry : listeArme.entrySet()){
            str.append(" ");
            str.append(entry.getValue().getNom());
        }
        return str.toString();
    }


    @Override
    public String toString() {
        String la = afficherListeArme(listeArme);
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", pv=" + pv +
                ", dmg=" + dmg +
                ", x=" + posX +
                ", y=" + posY +
                ", y=" + vitesse +
                ", Armes =" + la +
                '}';
    }

    /*private Grille[][] seDeplacer(){
    }*/



}
