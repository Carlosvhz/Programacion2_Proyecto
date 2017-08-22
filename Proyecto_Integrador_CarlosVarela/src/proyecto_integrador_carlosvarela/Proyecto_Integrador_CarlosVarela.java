package proyecto_integrador_carlosvarela;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Proyecto_Integrador_CarlosVarela {
   
    static Scanner sc = new Scanner(System.in);
    static String [][] tablero = new String [19][19];
    static Player_1 primero;
    static Player_2 segundo;
    static int x, y;
    
    public static void main(String[] args) {
        String p1, p2, resp;
        do{
            System.out.print("==== Proyecto Integrador ====\n"
                    + "Nombre del player 1: ");
            p1 = sc.next();
            primero = new Player_1(p1);
            System.out.print("Nombre del player 2: ");
            p2 = sc.next();
            segundo = new Player_2(p2);
            //Creacion de tablero
            tablero = tablero(tablero, 0, 0);
            //Inicio del juego
            juego(p1,p2);
            System.out.print("¿Desea continuar?[Si/No]: ");
            resp = sc.next();
        }while(resp.equalsIgnoreCase("SI"));
    }
    
    /**
     * Metodo en el que empieza el juego, seleccionando fichas,
     * moviendo fichas, quitando fichas, validando y demas.
     * @param p1
     * @param p2 
     */
    public static void juego(String p1, String p2){
        String turno = "1";
        int posicion;
        Fichas ficha;
        System.out.println("        ______________ Comienzo del juego ______________ ");
        print_matriz(tablero);
        do {
            if (turno.equals("1")) { // Jugador#1
                System.out.println(" --- Turno de "+primero.getNombre()+" ---");
                System.out.print("... Seleccionar ficha\n"
                            + "- Ingrese posicion x de la ficha rebelde: ");
                x = sc.nextInt();
                System.out.print("- Ingrese posicion y de la ficha rebelde: ");
                y = sc.nextInt();
                //Comprobando posicion de la ficha
                while(posicion(turno, x, y)==-1){
                    System.out.print("... Ficha no encontrada, Ingrese de nuevo\n"
                            + "- Posicion x: ");
                    x = sc.nextInt();
                    System.out.print("- Posicion y: ");
                    y = sc.nextInt();
                }
                //Agregando el movimiento
                posicion = posicion(turno, x, y);
                System.out.print("... Agregando moviemiento\n"
                        + "- Ingrese x: ");
                x = sc.nextInt();
                System.out.print("- Ingrese y: ");
                y = sc.nextInt();
                //Teniendo la ficha
                ficha = primero.getRebeldes().get(posicion);
                while(ficha.validar_mov(ficha, tablero, x, y)==false){
                    System.out.print("... Movimiento no valido, ingrese de nuevo\n"
                            + "- Ingrese x: ");
                    x = sc.nextInt();
                    System.out.print("- Ingrese y: ");
                    y = sc.nextInt();
                }
                // Obteniendo matriz con la ficha movida
                tablero = ficha.comer(ficha, primero.getRebeldes(), segundo.getDuques(), ficha.mover(ficha, tablero, x, y));
                turno = "2";
            } else { //jugador# 2
                System.out.println(" --- Turno de "+segundo.getNombre()+" ---");
                    System.out.print("... Seleccionar ficha\n"
                            + "- Ingrese posicion x del duque o rey: ");
                x = sc.nextInt();
                System.out.print("- Ingrese posicion y del duque o rey: ");
                y = sc.nextInt();
                //Comprobando posicion de la ficha
                while(posicion(turno, x, y)==-1){
                    System.out.print("... Ficha no encontrada, Ingrese de nuevo\n"
                            + "- Posicion x: ");
                    x = sc.nextInt();
                    System.out.print("- Posicion y: ");
                    y = sc.nextInt();
                }
                //En caso de que la ficha sea la ficha Rey
                if (posicion(turno, x, y)==25) {
                    ficha = (Ficha_Rey)segundo.getRey();
                    System.out.print("... Rey Agregando moviemiento\n"
                            + "- Ingrese x: ");
                    x = sc.nextInt();
                    System.out.print("- Ingrese y: ");
                    y = sc.nextInt();
                    while(ficha.validar_mov(ficha, tablero, x, y)==false){
                        System.out.print("... Movimiento no valido, ingrese de nuevo\n"
                                + "- Ingrese x: ");
                        x = sc.nextInt();
                        System.out.print("- Ingrese y: ");
                        y = sc.nextInt();
                    }
                    //Retornando matriz con el rey en su nueva posicion
                    tablero = ficha.comer(ficha, segundo.getDuques(), primero.getRebeldes(), ficha.mover(ficha, tablero, x, y));
                    turno = "1";
                }else{ 
                    //En caso de que la ficha sea un Duque
                    posicion = posicion(turno, x, y);
                    System.out.print("... Agregando moviemiento\n"
                            + "- Ingrese x: ");
                    x = sc.nextInt();
                    System.out.print("- Ingrese y: ");
                    y = sc.nextInt();
                    ficha = segundo.getDuques().get(posicion);
                    while(ficha.validar_mov(ficha, tablero, x, y)==false){
                        System.out.print("... Movimiento no valido, ingrese de nuevo\n"
                                + "- Ingrese x: ");
                        x = sc.nextInt();
                        System.out.print("- Ingrese y: ");
                        y = sc.nextInt();
                    }
                    //Retornando matriz con la ficha movida
                    tablero = ficha.comer(ficha, segundo.getDuques(), primero.getRebeldes(), ficha.mover(ficha, tablero, x, y));
                    turno = "1";
                }
            }        
            print_matriz(tablero);
        } while (evaluar(ficha));    
    }

    public static boolean evaluar(Fichas ficha){
        if (ficha instanceof Ficha_Rey) {
            if ( (ficha.getY()<2&&ficha.getX()<2)||(ficha.getY()<2&&ficha.getX()>16)||
                (ficha.getY()>16&&ficha.getX()<2)||(ficha.getY()>16&&ficha.getX()>16) ) {
                System.out.println(primero.getNombre()+" HA GANADOOO! ");
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }
    
    /**
     * @param turno del jugador
     * @param x
     * @param y
     * @return Posición de la ficha seleccionada
     */
    public static int posicion(String turno, int x, int y){
        int num = -1;
        if (turno.equals("1")) {
            for (int i = 0; i < primero.getRebeldes().size(); i++) {
                if (primero.getRebeldes().get(i).getX()==x && primero.getRebeldes().get(i).getY()==y) {
                    num = i;
                }
            }
            return num;
        }else{
            for (int i = 0; i < segundo.getDuques().size(); i++) {
                if ( (segundo.getDuques().get(i).getX()==x && segundo.getDuques().get(i).getY()==y)) {
                    num = i;
                }else if (segundo.getRey().getX()==x&&segundo.getRey().getY()==y) {
                    num = 25;
                }
            }
            return num;
        }
    }
    
    /**
     * @param matriz
     * @param f filas 
     * @param c columnas
     * @return  matriz llena de fichas, tambien almacena todas las fichas en 
     * El ArrayList de cada jugador.
     */
    public static String [][] tablero (String[][]matriz, int f, int c){
        if (f==matriz.length-1 && c==matriz[0].length-1) {
            matriz[f][c]="☒";
            return matriz;
        }else{
            if (c==matriz.length-1 && (f==0||f==1||f==17)) {
                matriz[f][c]="☒";
                return tablero(matriz,f+1,0);
            }else if(c==matriz.length-1 && (f==2||f==5||f==13||f==16)){
                matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));
                return tablero(matriz,f+1,0);
            }if(c==matriz.length-1 ){
                matriz[f][c]="⬜";
                return tablero(matriz,f+1,0);
            }else if ( f==0 || f==matriz.length-1 ){
                if (c==2|| c==5 || c==13 || c==16) {
                matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));               
                }else if (c==0 || c==1 || c==matriz.length-2 || c==matriz.length-1){
                matriz[f][c]="☒";
                }else{
                matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1); 
            }else if (f==1 || f==matriz.length-2){
                if (c>1&&c<matriz.length-2) {
                    matriz[f][c]="⬜";
                }else{
                    matriz[f][c]="☒";
                }
                return tablero(matriz, f, c+1); 
            }else if(f==2 || f==matriz.length-3 ){
                if (c>5&&c<13 || (c>0&&c<5) ||(c>13&&c<18)) {
                    matriz[f][c]="⬜";
                }else{
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                   
                }
                return tablero(matriz, f, c+1); 
            }else if(f==3 || f==matriz.length-4){
                if(c==7 || c==9 || c==11){
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                    
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1); 
            }else if(f==4 || f==matriz.length-5){
                if(c==6 || c==12){
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                    
                }else if(c==8||c==10){
                    matriz[f][c]="Ⓐ";
                     segundo.setDuques(new Duque(c,f));
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1);
            }else if(f==5 || f==matriz.length-6){
                if(c==0 || c==2 || c==matriz.length-1 || c==matriz.length-3|| c==5|| c==matriz.length-6){
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                    
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1);
            }else if (f==6 || f==matriz.length-7){
                if(c==4|| c==matriz.length-5){
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                    
                }else if (c==9){
                    matriz[f][c]="Ⓐ";
                    segundo.setDuques(new Duque(c,f));
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1);
            }else if (f==7 || f==matriz.length-8){
                if(c==3|| c==matriz.length-4){
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                    
                }else if (c==8 || c==10){
                    matriz[f][c]="Ⓐ";
                    segundo.setDuques(new Duque(c,f));
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1);
            }else if(f==8 || f==matriz.length-9){
                if (c==4||c==7||c==matriz.length-8||c==9|| c==matriz.length-5) {
                    matriz[f][c]="Ⓐ";
                    segundo.setDuques(new Duque(c,f));
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz, f, c+1);
            }else if(f==9){
                if (c==3 || c==matriz.length-4) {
                    matriz[f][c]="✪";
                primero.setRebeldes(new Rebelde(c,f));                    
                }else if (c==6||c==matriz.length-7||c==8||c==matriz.length-9) {
                    matriz[f][c]="Ⓐ";
                    segundo.setDuques(new Duque(c,f));
                }else if(c==9){
                    matriz[f][c]="♛";
                    segundo.setRey(new Ficha_Rey(c,f));
                }else{
                    matriz[f][c]="⬜";
                }
                return tablero(matriz,f,c+1);
            }else{
                matriz[f][c] = "⬜";
                return tablero(matriz, f, c+1);
            }
        }
    } 
    
    /**
     * Imprime matriz.
     * @param matriz 
     */
    static void print_matriz(String[][]matriz){
        System.out.println("=====================================================================");
        System.out.println("     ⓿  ➊  ➋  ➌  ➍  ➎  ➏  ➐  ➑  ➒  ➓  ⓫"
                + "  ⓬  ⓭  ⓮  ⓯  ⓰  ⓱  ⓲");
        System.out.println("   _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++){
                if (j==0) {
                    if (i>9) {
                      System.out.print(i+"| ");  
                    }else{
                      System.out.print(i+" | ");
                    }  
                }
                System.out.print(" "+matriz[i][j]+" ");
            }
            System.out.println();
        }
            System.out.println("=====================================================================");        
    }
}
