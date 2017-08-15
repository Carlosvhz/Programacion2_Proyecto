package proyecto_integrador_carlosvarela;

import java.util.ArrayList;


public abstract class  Fichas implements Comportamiento{
    
    private int x, y; 
    
    public Fichas(int x, int y) { 
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Fichas{" + "x=" + x + ", y=" + y + '}';
    }

    
}
