package modele.management;

import modele.item.Arme;
import modele.personnage.Joueur;
import modele.personnage.Personnage;

import java.util.Map;
import java.util.TreeMap;

public class Manager {
    private TreeMap<Integer, Personnage> listePersonnage;


    public Manager(){
        listePersonnage = new TreeMap<Integer, Personnage>();
        listePersonnage.put(0, new Joueur("joueur", 3, 150, 150, 20, 0));
    }

    public TreeMap<Integer, Personnage> getListePersonnage(){
        return listePersonnage;
    }
    public void setListePersonnage(TreeMap<Integer, Personnage> listePersonnage){
        this.listePersonnage = listePersonnage;
    }



    public void afficherListePersonnage(){
        for(Map.Entry<Integer, Personnage> entry : listePersonnage.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
