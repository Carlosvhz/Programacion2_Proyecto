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
public interface Comportamiento {
    
    public abstract boolean validar_mov(Fichas ficha, String[][]matriz, int x, int y);
    
    public abstract String [][] mover(Fichas ficha, String[][]matriz, int x, int y);
}
