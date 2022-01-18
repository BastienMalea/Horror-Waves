package model.manager;

public class Calculateur {
    private float a;
    private float b;
    private double x;

    public Calculateur(){}

    public void updateCalculateur(double xJoueur, double yJoueur, double xMouse, double yMouse){
        a = ((float)yMouse - (float)yJoueur) / ((float)xMouse - (float)xJoueur);
        b = (a*(-1) * (float)xMouse + (float)yMouse);
    }

    public double calculPosEndLineX(double xJoueur, double xMouse){
        if(Float.isInfinite(a)){
            this.x = xMouse;
            return xMouse;
        }
        if(xJoueur <= xMouse){
            this.x = 750;
            return 750;
        }
        if(xJoueur >= xMouse){
            this.x = -750;
            return -750;
        }

        this.x = xMouse;
        return xMouse;
    }

    public double calculPosEndLineY(double yJoueur, double yMouse){
        if(Float.isInfinite(a) && yJoueur < yMouse){
            return 450;
        }
        if(Float.isInfinite(a) && yJoueur > yMouse){
            return -450;
        }
        return a*x+b;
    }
}
