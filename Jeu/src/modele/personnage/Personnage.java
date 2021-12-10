package modele.personnage;

import modele.item.Arme;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.TreeMap;

public class Personnage implements KeyListener {
    private String nom;
    private int pv;
    private int posX;
    private int posY;
    private int vitesse;
    private TreeMap<Integer, Arme> listeArme;

    public Personnage(String nom, int pv, int posX, int posY, int vitesse, Arme arme) {
        this.nom = nom;
        this.pv = pv;
        this.posX = posX;  // A definir au milieu de l'écran j'ai mis une valeur random
        this.posY = posY;  //
        this.vitesse = vitesse;
        this.listeArme = new TreeMap<Integer, Arme>();
        listeArme.put(0, arme);
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

    public void setListeArme(TreeMap<Integer, Arme> listeArme) { this.listeArme = listeArme; }
    public TreeMap<Integer, Arme> getListeArme(){ return listeArme; }



    public String afficherListeArme(TreeMap<Integer, Arme> listeArme){
        StringBuilder str = new StringBuilder();
        for(Map.Entry<Integer, Arme> entry : listeArme.entrySet()){
            str.append(" ");
            str.append(entry.getValue().getNom());
            str.append("(");
            str.append(entry.getValue().getType());
            str.append(")");
        }
        return str.toString();
    }






    /*private Grille[][] seDeplacer(){
    }*/



}
