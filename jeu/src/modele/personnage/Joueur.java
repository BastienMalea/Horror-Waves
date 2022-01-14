package modele.personnage;

import modele.item.*;

public class Joueur extends Personnage {
    private int munitions;

    public Joueur(String nom, int pv, int posX, int posY, int vitesse, int munitions, String image, int Hhitbox, int Lhitbox) {
        super(nom, pv, posX, posY, vitesse, new Arme(typeArme.MELEE, "lien vers image", "poing", 1, -1, 1), image, Hhitbox, Lhitbox);
        this.munitions=munitions;
    }

    public int getMunitions() {
        return munitions;
    }
    public void setMunitions(int munitions) {
        this.munitions = munitions;
    }


    @Override
    public String toString() {
        String la = super.afficherListeArme(super.getListeArme());
        return "Joueur {" +
                "nom='" + getNom() + '\'' +
                ", pv=" + getPv() +
                ", x=" + getPosX() +
                ", y=" + getPosY() +
                ", vitesse=" + getVitesse() +
                ", Armes =" + la +
                '}';
    }


    @Override
    public void ramasser(Item i) {

    }

    @Override
    public void updateMunition(Munition m) {
        this.munitions = this.munitions + m.getQuantite();
    }

    @Override
    public void ramasserArme(Arme a) {
        if(getListeArme().size() == 1){
            this.addArme(getListeArme().size(), a);
        }
        else if(getListeArme().size() == 2){
            this.delArme(getIndiceArme());
            this.addArme(getIndiceArme(), a);
        }
    }

    @Override
    public void ajouterPower(Power p) {

    }

    @Override
    public void supprimerPower(Power p) {

    }

    @Override //Est ce qu'on fait 2 armes max pour le joueur ? oui(antoine)
    public void changerArmeActive() {
        if(getIndiceArme()==0){
            setIndiceArme(1);
        }
        else if(getIndiceArme()==1)
        {
            setIndiceArme(0);
        }
    }
}
