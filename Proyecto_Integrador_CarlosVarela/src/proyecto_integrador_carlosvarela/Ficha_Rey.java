/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_integrador_carlosvarela;

/**
 *
 * @author carlo
 */
public class Ficha_Rey extends Fichas{
        
    private int x, y;
    
    public Ficha_Rey(int x, int y){
        super(x, y);
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean validar_mov(Fichas ficha, String[][] matriz, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] mover(Fichas ficha, String[][] matriz, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
