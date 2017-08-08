    package proyecto_integrador_carlosvarela;

import java.util.ArrayList;

public class Player_1 {
    
    private ArrayList<Fichas> rebeldes = new ArrayList();
    private String nombre;
    
    public Player_1(){
    }
    
    public Player_1(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public ArrayList<Fichas> getRebeldes() {
        return rebeldes;
    }

    public void setRebeldes(Fichas rebeldes) {
        this.rebeldes.add(rebeldes);
    }
    
    
    
}
