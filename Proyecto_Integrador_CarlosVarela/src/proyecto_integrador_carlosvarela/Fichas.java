package proyecto_integrador_carlosvarela;

import java.util.ArrayList;


public class Fichas implements Comportamiento{
    
    private int x, y; //Posicion en X y en Y de la ficha en especifico
    //private ArrayList<Integer> pos_x = new ArrayList(); //Posiciones en X de todas las fichas contenidas
    //private ArrayList<Integer> pos_y = new ArrayList(); //Posiciones en Y de todas las fichas contenidas

    
    public Fichas(int x, int y) { //Constructor que posee todos los atributos.
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
    
    @Override
    public void validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
