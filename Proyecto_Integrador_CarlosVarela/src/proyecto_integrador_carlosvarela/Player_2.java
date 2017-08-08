package proyecto_integrador_carlosvarela;

import java.util.ArrayList;

public class Player_2 {
    
    private ArrayList<Fichas> duques = new ArrayList(); //Arreglo de duques
    private Fichas rey;   
    private String nombre;
    
    public Player_2(){
    }
    
    public Player_2(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Fichas> getDuques() {
        return duques;
    }

    public void setDuques(Fichas duque) {
        this.duques.add(duque);
    }

    public String getNombre() {
        return nombre;
    }
   
    public Fichas getRey() {
        return rey;
    }

    public void setRey(Fichas rey) {
        this.rey = rey;
    }

}
