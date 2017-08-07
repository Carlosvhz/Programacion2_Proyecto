package proyecto_integrador_carlosvarela;

import java.util.ArrayList;

public class Player_2 {
    
    public ArrayList<Fichas> duques = new ArrayList();
    private Fichas rey;
    
    public Player_2(){
    }

    public ArrayList<Fichas> getDuques() {
        return duques;
    }

    public void setDuques(ArrayList<Fichas> duques) {
        this.duques = duques;
    }

    public Fichas getRey() {
        return rey;
    }

    public void setRey(Fichas rey) {
        this.rey = rey;
    }
    
    
    
}
