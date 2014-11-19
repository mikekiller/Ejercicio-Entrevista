/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mars_roverse;

import java.util.Scanner;
/**
 *
 * @author Desarrollador6
 */
public class Mars_RoversE {
    int plat_x, plat_y = 0 ;
    int x,y = 0;
    String D, I ;
    String[] resul = new String[50];
    int cont = 0;
   

    void  leer_plat(int i, String pl ){
        
                if (i==0) {
                    
                  plat_x = Integer.parseInt(pl.substring(0, 1));
                  plat_y = Integer.parseInt(pl.substring(2,3));
                  
                }
                if (i==1) {
                 
                  x = Integer.parseInt(pl.substring(0, 1));
                  y = Integer.parseInt(pl.substring(2,3));
                  D = pl.substring(4, 5);
                }
               
                if(i==2){
                    I = pl;
                    resolver(cont);
                    cont++;
                } 
    }
    
    void cambiar_sentido(String O){
        if (D.equals("S")&& O.equals("R")|| D.equals("N") && O.equals("L") ) {
            D = "O";
            return;
        }
        if (D.equals("N")&& O.equals("R")|| D.equals("S") && O.equals("L") ) {
            D = "E";
            return;
        }
        if (D.equals("O")&& O.equals("R")|| D.equals("E") && O.equals("L") ) {
            D = "N";
            return;
        }
        if (D.equals("E")&& O.equals("R")|| D.equals("O") && O.equals("L") ) {
            D = "S";
        }
    }
    void Medio(){
        if (D.equals("N")) {
            y = y + 1;
        }
        if (D.equals("E")) {
            x = x + 1;
        }if (D.equals("S")) {
            y = y - 1;
        }if (D.equals("O")) {
            x = x - 1;
        }
    }
    void resolver(int j){
     int i = 0;
        while (i<I.length()) {            
            if (I.substring(i, i+1).equals("M")) {
                Medio();
            }else{
                cambiar_sentido(I.substring(i,i+1));
            }
           i++; 
        }
        if (x <= plat_x && y <= plat_y) {
            resul[cont] = x + " " + y +" "+ D ;
        }else{
            resul[cont] ="Salio de la plataforma"+ x + " " + y +" "+ D ;
        }
        System.out.println("El resultado es:"+ resul[cont] );
    }
   
    void mostrar_resultados(){
        int i = 0;
        while (resul[i]!=null) {            
            System.out.println("el resultado es :"+ resul[i] );
            i++;
        }
    }
   
    public static void main(String[] args) {
        // TODO code application logic here
        Mars_RoversE obj = new Mars_RoversE();
        int i = 0;
        String v ;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
           v = scan.nextLine();
           obj.leer_plat(i,v);
           i++;
            if (i==3) {
              i=1;  
            }
        }
     obj.mostrar_resultados(); 
    }
}
