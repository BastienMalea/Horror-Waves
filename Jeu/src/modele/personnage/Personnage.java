package modele.personnage;

import modele.hitbox.Hitbox;
import modele.hitbox.Rectangle;
import modele.item.Arme;
import modele.item.Item;
import modele.item.Munition;
import modele.item.Power;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.TreeMap;

public class Personnage implements Action {
    private String nom;
    private int pv;
    private int posX;
    private int posY;
    private int vitesse;
    private int indiceArme;
    private String image;
    private Hitbox hitbox;
    private TreeMap<Integer, Arme> listeArme;
    private TreeMap<Integer, Power> listePower;

    public Personnage(String nom, int pv, int posX, int posY, int vitesse, Arme arme, String image, int Hhitbox, int Lhitbox) {
        this.nom = nom;
        this.pv = pv;
        this.posX = posX;  // A definir au milieu de l'écran j'ai mis une valeur random
        this.posY = posY;  //
        this.vitesse = vitesse;
        this.indiceArme = 0;
        this.image = image;
        this.hitbox.addRectangle(Hhitbox, Lhitbox);
        this.listeArme = new TreeMap<Integer, Arme>();
        listeArme.put(0, arme);
        this.listePower = new TreeMap<Integer, Power>();
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

    public int getIndiceArme() {
        return indiceArme;
    }
    public void setIndiceArme(int indiceArme) {
        this.indiceArme = indiceArme;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public void setListeArme(TreeMap<Integer, Arme> listeArme) {
        this.listeArme = listeArme;
    }
    public TreeMap<Integer, Arme> getListeArme(){
        return listeArme;
    }

    public TreeMap<Integer, Power> getListePower() {
        return listePower;
    }
    public void setListePower(TreeMap<Integer, Power> listePower) {
        this.listePower = listePower;
    }


    public void addArme(int i, Arme a){
        listeArme.put(i, a);
    }

    public void delArme(int i){
        listeArme.remove(i);
    }

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

    @Override
    public void ramasser(Item i) {

    }

    @Override
    public void updateMunition(Munition m) {

    }

    @Override
    public void ramasserArme(Arme a) {

    }

    @Override
    public void ajouterPower(Power p) {

    }

    @Override
    public void supprimerPower(Power p) {

    }

    @Override
    public void changerArmeActive() {

    }

    @Override
    public void attaquer(Personnage p) {

    }


}
