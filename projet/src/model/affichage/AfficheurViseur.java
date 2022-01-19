package model.affichage;

import model.entite.Ligne;
import model.entite.Mouse;
import model.entite.Personnage;
import model.manager.Calculateur;

public class AfficheurViseur extends Afficheur {
    private Ligne ligne;
    private Personnage joueur;
    private Mouse mouse;

    public AfficheurViseur(Calculateur calculateur, Ligne ligne, Personnage joueur, Mouse mouse){
        super(calculateur);
        this.ligne = ligne;
        this.joueur = joueur;
        this.mouse = mouse;
    }

    @Override
    public void update() {
        calculateur.updateCalculateur(joueur.getPosCentreX(),joueur.getPosCentreY(), mouse.getPosMouseX(), mouse.getPosMouseY());
        ligne.updatePosEndLine(calculateur.calculPosEndLineX(joueur.getPosCentreX(), mouse.getPosMouseX()), calculateur.calculPosEndLineY(joueur.getPosCentreY(), mouse.getPosMouseY()));
    }
}
