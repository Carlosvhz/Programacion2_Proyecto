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
        if (x<0||x>matriz.length-1 || y<0||y>matriz.length-1  || (ficha.getX()==x&&ficha.getY()==y)) {
            return false;
        }else{
            if (ficha.getX()!=x&&ficha.getY()!=y) {
                return false;
            }else if (matriz[x][y].equals("☒")||matriz[y][x].equals("✪")||matriz[y][x].equals("Ⓐ")||matriz[y][x].equals("♛")) {
                    return false;
            }else{
                if (ficha.getX()!=x&&ficha.getY()==y) { //Movimiento derecha o izquierda
                    if (x>ficha.getX()) {
                        for (int i = ficha.getX()+1; i <= x; i++) {
                            if (matriz[ficha.getY()][i].equals("✪")||matriz[ficha.getY()][i].equals("Ⓐ")||matriz[ficha.getY()][i].equals("♛")) {
                                return false;
                            }
                        }
                        return true;
                    }else{
                        for (int i = ficha.getX()-1; i >= x; i--) {
                            if (matriz[ficha.getY()][i].equals("✪")||matriz[ficha.getY()][i].equals("Ⓐ")||matriz[ficha.getY()][i].equals("♛")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }else{  // Movimiento arriba o abajo 
                    if (y>ficha.getY()) {
                        for (int i = ficha.getY()+1; i <= y; i++) {
                            if (matriz[i][ficha.getX()].equals("✪")||matriz[i][ficha.getX()].equals("Ⓐ")||matriz[i][ficha.getX()].equals("♛")) {
                                return false;
                            }
                        }
                        return true;
                    }else{
                        for (int i = ficha.getY()-1; i >= y; i--) {
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

    @Override
    public String[][] mover(Fichas ficha, String[][] matriz, int x, int y) {
        matriz[y][x] = "✪";
        matriz[ficha.getY()][ficha.getX()] = "⬜";
        ficha.setX(x);
        ficha.setY(y);
        return matriz;      
    }

    @Override
    public String[][] capturar(Fichas ficha, ArrayList colegas, String[][] matriz) {
        for (int i = 0; i < colegas.size(); i++) {
            if (Math.abs(ficha.getX()-((Fichas)colegas.get(i)).getX())==2 && ficha.getY()==((Fichas)colegas.get(i)).getY()) {
                if (matriz[ficha.getY()][(ficha.getX()+((Fichas)colegas.get(i)).getX())/2].equals("Ⓐ")) {
                    matriz[ficha.getY()][(ficha.getX()+((Fichas)colegas.get(i)).getX())/2] = "⬜";
                }
                if (matriz[ficha.getY()][(ficha.getX()+((Fichas)colegas.get(i)).getX())/2].equals("♛")&& 
                        matriz[ficha.getY()+1][(ficha.getX()+((Fichas)colegas.get(i)).getX())/2].equals("✪")&&
                        matriz[ficha.getY()-1][(ficha.getX()+((Fichas)colegas.get(i)).getX())/2].equals("✪")) {
                        matriz[ficha.getY()][(ficha.getX()+((Fichas)colegas.get(i)).getX())/2] = "⬜";
                }
            }
            if(Math.abs(ficha.getY()-((Fichas)colegas.get(i)).getY())==2 && ficha.getX()==((Fichas)colegas.get(i)).getX()){
                if (matriz[(ficha.getY()+((Fichas)colegas.get(i)).getY())/2][ficha.getX()].equals("Ⓐ") ) {
                    matriz[(ficha.getY()+((Fichas)colegas.get(i)).getY())/2][ficha.getX()] = "⬜";
                }
                if (matriz[(ficha.getY()+((Fichas)colegas.get(i)).getY())/2][ficha.getX()].equals("♛")&& 
                         matriz[(ficha.getY()+((Fichas)colegas.get(i)).getY())/2][ficha.getX()+1].equals("✪")&&
                         matriz[(ficha.getY()+((Fichas)colegas.get(i)).getY())/2][ficha.getX()-1].equals("✪")) {
                         matriz[(ficha.getY()+((Fichas)colegas.get(i)).getY())/2][ficha.getX()] = "⬜";
                }
            }
        }
        if (ficha.getX()==1||(ficha.getX()==3 && ficha.getY()<=1)||(ficha.getX()==3&&ficha.getY()>=17) ) {
                if (matriz[ficha.getY()][ficha.getX()-1].equals("Ⓐ")) {
                    matriz[ficha.getY()][ficha.getX()-1] = "⬜";
                }
                if (ficha.getX()==1&&matriz[ficha.getY()][ficha.getX()-1].equals("♛")&&
                        matriz[ficha.getY()+1][ficha.getX()-1].equals("✪")&&
                        matriz[ficha.getY()-1][ficha.getX()-1].equals("✪")) {
                        matriz[ficha.getY()][ficha.getX()-1] = "⬜";
                }
            
        }
        if (ficha.getX()==17||(ficha.getX()==15&& ficha.getY()<=1)||(ficha.getX()==15&&ficha.getY()>=17)) {
            if (matriz[ficha.getY()][ficha.getX()+1].equals("Ⓐ")) {
                    matriz[ficha.getY()][ficha.getX()+1] = "⬜";
            }
            if (ficha.getX()==17&&matriz[ficha.getY()][ficha.getX()+1].equals("♛")&&
                        matriz[ficha.getY()+1][ficha.getX()+1].equals("✪")&&
                        matriz[ficha.getY()-1][ficha.getX()+1].equals("✪")) {
                        matriz[ficha.getY()][ficha.getX()+1] = "⬜";
            }
        }
        if (ficha.getY()==1||(ficha.getY()==3&&ficha.getX()<=1)||(ficha.getY()==3&&ficha.getX()>=17)) {
            if (matriz[ficha.getY()-1][ficha.getX()].equals("Ⓐ")) {
                    matriz[ficha.getY()-1][ficha.getX()] = "⬜";
            }
            if (ficha.getY()==1&&matriz[ficha.getY()-1][ficha.getX()].equals("♛")&&
                        matriz[ficha.getY()-1][ficha.getX()+1].equals("✪")&&
                        matriz[ficha.getY()-1][ficha.getX()-1].equals("✪")) {
                        matriz[ficha.getY()-1][ficha.getX()] = "⬜";
            }
        }
        if (ficha.getY()==17||(ficha.getY()==15&&ficha.getX()<=1)||(ficha.getY()==15&&ficha.getX()>16)) {
            if (matriz[ficha.getY()+1][ficha.getX()].equals("Ⓐ")) {
                    matriz[ficha.getY()+1][ficha.getX()] = "⬜";
            }
            if (ficha.getY()==17&&matriz[ficha.getY()+1][ficha.getX()].equals("♛")&&
                        matriz[ficha.getY()+1][ficha.getX()+1].equals("✪")&&
                        matriz[ficha.getY()+1][ficha.getX()-1].equals("✪")) {
                        matriz[ficha.getY()+1][ficha.getX()] = "⬜";
            }
        }
        return matriz;
    }
}
