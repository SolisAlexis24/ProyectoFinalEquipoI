package Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author EquipoI
 */
public class DatosPersonales {
    public int edad(){
        int edad=(int)(Math.floor(Math.random()*(26-17+1)+17));
        return edad;
    }
    
    public String direccion(){
        String dir=null;
        Random rand = new Random();
        int num=rand.nextInt(500), cont=0;
        try {
            FileReader fr = new FileReader("direcciones.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    cont++;
                    String token = tokenizador.nextToken();
                    if(cont == num)
                        dir=token;
                }
                linea = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        return dir;
    }
    
    public int numCuenta(){
        String numCuen="";
        for (int i = 0; i < 9; i++) {
            int r1 = (int)(Math.random()*(9-1)+0);
            numCuen += String.valueOf(r1);
        }
        if(numCuen.length()<9){
            numCuen += "1";
        }
        return Integer.parseInt(numCuen);
    }
    
    public int semestre(){
        int semestre=(int)Math.floor(Math.random()*(4-2+1)+2);
        return semestre;
    }
}
