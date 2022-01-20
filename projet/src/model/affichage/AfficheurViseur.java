package model.affichage;

import model.entite.Ligne;
import model.entite.Mouse;
import model.entite.Personnage;
import model.manager.Calculateur;

public class AfficheurViseur extends Afficheur {
    private Calculateur calculateur;
    private Ligne ligne;
    private Personnage joueur;
    private Mouse mouse;

    /**
     * constructeur de l'afficheur viseur
     * @param calculateur utilisé pour calculer la nouvelle droite du viseur
     * @param ligne utilisé pour stocker les informations sur le viseur
     * @param joueur utilisé pour calculer l'equation de la droite
     * @param mouse utilisé pour calculer l'equation de la droite
     */
    public AfficheurViseur(Calculateur calculateur, Ligne ligne, Personnage joueur, Mouse mouse){
        this.calculateur = calculateur;
        this.ligne = ligne;
        this.joueur = joueur;
        this.mouse = mouse;
    }

    /**
     * actualise l'affichage du viseur
     */
    @Override
    public void update() {
        calculateur.updateCalculateur(joueur.getPosCentreX(),joueur.getPosCentreY(), mouse.getPosMouseX(), mouse.getPosMouseY());
        ligne.updatePosEndLine(calculateur.calculPosEndLineX(joueur.getPosCentreX(), mouse.getPosMouseX()), calculateur.calculPosEndLineY(joueur.getPosCentreY(), mouse.getPosMouseY()));
    }
}
