/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_integrador_carlosvarela;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Rebelde extends Fichas{
    
    private int x, y;

    public Rebelde(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean validar_mov(Fichas ficha, String[][] matriz, int x, int y) {
        int num, cont;
        if (x<0||x>matriz.length-1 || y<0||y>matriz.length-1) {
            return false;
        }else{
            if (ficha.getX()!=x&&ficha.getY()!=y) {
                return false;
            }else if (matriz[x][y].equals("☒")||matriz[y][x].equals("✪")||matriz[y][x].equals("Ⓐ")||matriz[y][x].equals("♛")) {
                    return false;
            }else{
                if (ficha.getX()!=x&&ficha.getY()==y) { //Movimiento derecha o izquierda
                    if (x>ficha.getX()) {
                        for (int i = ficha.getX()+1; i < x; i++) {
                            if (matriz[ficha.getY()][i].equals("✪")||matriz[ficha.getY()][i].equals("Ⓐ")||matriz[ficha.getY()][i].equals("♛")) {
                                return false;
                            }
                        }
                        System.out.println("///True -_-");
                        return true;
                    }else{
                        for (int i = ficha.getX()-1; i > x; i--) {
                            if (matriz[ficha.getY()][i].equals("✪")||matriz[ficha.getY()][i].equals("Ⓐ")||matriz[ficha.getY()][i].equals("♛")) {
                                return false;
                            }
                        }
                        System.out.println("///True -_-");
                        return true;
                    }
                }else{  // Movimiento arriba o abajo 
                    if (y>ficha.getY()) {
                        for (int i = ficha.getY()+1; i < y; i++) {
                            if (matriz[i][ficha.getX()].equals("✪")||matriz[i][ficha.getX()].equals("Ⓐ")||matriz[i][ficha.getX()].equals("♛")) {
                                return false;
                            }
                        }
                        System.out.println("///True -_-");
                        return true;
                    }else{
                        for (int i = ficha.getY()-1; i > y; i--) {
                            if (matriz[i][ficha.getX()].equals("✪")||matriz[i][ficha.getX()].equals("Ⓐ")||matriz[i][ficha.getX()].equals("♛")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }//
        }
    }

    public String[][] mover(Fichas ficha, String[][] matriz, int x, int y) {
        matriz[y][x] = "✪";
        matriz[ficha.getY()][ficha.getX()] = "⬜";
        ficha.setX(x);
        ficha.setY(y);
        return matriz;      
    }

    @Override
    public String[][] comer(Fichas ficha, ArrayList enemigos, String[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
