package model.manager;

public class Calculateur {
    private float a;
    private float b;

    public Calculateur(){}

    public void updateCalculateur(double xJoueur, double yJoueur, double xMouse, double yMouse){
        a = ((float)yMouse - (float)yJoueur) / ((float)xMouse - (float)xJoueur);
        b = (a*(-1) * (float)xMouse + (float)yMouse);
    }
}
