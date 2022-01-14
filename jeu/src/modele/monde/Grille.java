package modele.monde;

public class Grille {
    private int colonnes;
    private int lignes;
    private int tabGrille[][];


    public Grille(int colonnes, int lignes, int[][] tabGrille) {
        this.colonnes = colonnes;
        this.lignes = lignes;
        this.tabGrille = tabGrille;
    }



    public int getColonnes() {
        return colonnes;
    }
    public void setColonnes(int colonnes) {
        this.colonnes = colonnes;
    }

    public int getLignes() {
        return lignes;
    }
    public void setLignes(int lignes) {
        this.lignes = lignes;
    }

    public int[][] getTabGrille() {
        return tabGrille;
    }
    public void setTabGrille(int[][] tabGrille) {
        this.tabGrille = tabGrille;
    }




}