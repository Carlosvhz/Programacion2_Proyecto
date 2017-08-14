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
public class Duque extends Fichas{
    
    private int x, y;
    //Atributo por los momentos desconocido

    public Duque(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;
    }

    
    @Override
    public boolean validar_mov(Fichas ficha, String[][] matriz, int x, int y) {
        if (x<0||x>matriz.length-1 || y<0||y>matriz.length-1 ) {
            return false;
        }else{
            if (ficha.getX()!=x&&ficha.getY()!=y) {
                return false;
            }else if (Math.abs(ficha.getX()-x)==1 || Math.abs(ficha.getY()-y)==1) {
                return true;
            }else if (matriz[y][x].equals("☒")){
                return false;
            }else{
                return false;
            }
        }
    }
    
    @Override
    public String[][] mover(Fichas ficha, String[][] matriz, int x, int y) {
       matriz[y][x] = "Ⓐ";
        matriz[ficha.getY()][ficha.getX()] = " ";
        this.x = x;
        this.y = y;
        return matriz;   
    }

}
    
