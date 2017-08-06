package proyecto_integrador_carlosvarela;

import java.util.Scanner;

public class Proyecto_Integrador_CarlosVarela {
   
    static Scanner sc = new Scanner(System.in);
    static String [][] tablero = new String [19][19];
    static Player_1 primero = new Player_1();
    
    
    public static void main(String[] args) {
        tablero = tablero(tablero, 0, 0);
        print_matriz(tablero, 0, 0);
        for (int i = 0; i < primero.rebeldes.size(); i++) {
                System.out.println((i+1)+"- "+primero.rebeldes.get(i));
        }
    }
    
     static String [][] tablero (String[][]matriz, int f, int c){
        if (f==matriz.length-1 && c==matriz[0].length-1) {
            matriz[f][c]="X";
            return matriz;
        }else{
            if (c==matriz.length-1 && (f==0||f==1||f==17)) {
                matriz[f][c]="X";
                return tablero(matriz,f+1,0);
            }else if(c==matriz.length-1 && (f==2||f==5||f==13||f==16)){
                matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));
                return tablero(matriz,f+1,0);
            }if(c==matriz.length-1 ){
                matriz[f][c]=" ";
                return tablero(matriz,f+1,0);
            }else if ( f==0 || f==matriz.length-1 ){
                if (c==2|| c==5 || c==13 || c==16) {
                matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                
                }else if (c==0 || c==1 || c==matriz.length-2 || c==matriz.length-1){
                matriz[f][c]="X";
                }else{
                matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1); 
            }else if (f==1 || f==matriz.length-2){
                if (c>1&&c<matriz.length-2) {
                    matriz[f][c]=" ";
                }else{
                    matriz[f][c]="X";
                }
                return tablero(matriz, f, c+1); 
            }else if(f==2 || f==matriz.length-3 ){
                if (c>5&&c<13 || (c>0&&c<5) ||(c>13&&c<18)) {
                    matriz[f][c]=" ";
                }else{
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }
                return tablero(matriz, f, c+1); 
            }else if(f==3 || f==matriz.length-4){
                if(c==7 || c==9 || c==11){
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1); 
            }else if(f==4 || f==matriz.length-5){
                if(c==6 || c==12){
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }else if(c==8||c==10){
                    matriz[f][c]="○";
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1);
            }else if(f==5 || f==matriz.length-6){
                if(c==0 || c==2 || c==matriz.length-1 || c==matriz.length-3|| c==5|| c==matriz.length-6){
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1);
            }else if (f==6 || f==matriz.length-7){
                if(c==4|| c==matriz.length-5){
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }else if (c==9){
                    matriz[f][c]="○";
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1);
            }else if (f==7 || f==matriz.length-8){
                if(c==3|| c==matriz.length-4){
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }else if (c==8 || c==10){
                    matriz[f][c]="○";
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1);
            }else if(f==8 || f==matriz.length-9){
                if (c==4||c==7||c==matriz.length-8||c==9|| c==matriz.length-5) {
                    matriz[f][c]="○";
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz, f, c+1);
            }else if(f==9){
                if (c==3 || c==matriz.length-4) {
                    matriz[f][c]="•";
        /***/        primero.rebeldes.add(new Fichas(f,c));                    
                }else if (c==6||c==matriz.length-7||c==8||c==matriz.length-9) {
                    matriz[f][c]="○";
                }else if(c==9){
                    matriz[f][c]="☼";
                }else{
                    matriz[f][c]=" ";
                }
                return tablero(matriz,f,c+1);
            }else{
                matriz[f][c] = " ";
                return tablero(matriz, f, c+1);
            }
        }
    }
    
    static void print_matriz(String[][]matriz, int f, int c){
        if (f==matriz.length-1 && c==matriz[0].length-1) {
            System.out.println(""+matriz[f][c]+"|");
        } else {
            if (c==matriz.length-1) {
                System.out.println(""+matriz[f][c]+"|");
                print_matriz(matriz, f+1, 0);
            } else {
                System.out.print("|"+matriz[f][c]+"|");
                print_matriz(matriz, f, c+1);
            }
        }
    }
}
