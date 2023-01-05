package Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author tripl
 */
public class GeneradorNombres {
    public String nombre(){
        Random rand = new Random();
        String nombre=null;
        //Se genera un número random del 0 al 100 que representará la pocisión del nombre a seleccionar
        int num=rand.nextInt(100), cont=0;
        try {
            //Lector de archivo con los nombres
            FileReader fr = new FileReader("nombres.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            //Leerá linea por línea
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    //Cada token que pasa se le suma una unidad al contador
                    cont++;
                    String token = tokenizador.nextToken();
                    //Si el contador es igual a la posición obtenida aleatoriamente, se le asigna el nombre a la cadena
                    if(cont == num)
                        nombre=token;
                }
                linea = br.readLine();//siguiente linea
            }
            
            br.close();//cierra archivo
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        try {
            //reiniciamos contador
            cont =0;
            //número al azar del 1 al 226
            num=rand.nextInt(226);
            FileReader fr = new FileReader("apellidos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    //cada token aumenta una unidad al contador
                    cont++;
                    String token = tokenizador.nextToken();
                    //si el contador es igual al numero generado al azar, se concatena con el nombre anterior
                    if(cont == num)
                        nombre=nombre+" "+token;
                }
                linea = br.readLine(); //siguiente linea
            }
            
            br.close(); //cierra archivo
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        try {
            //reiniciando contador
            cont =0;
            //genera numero al azar del 1 al 226
            num=rand.nextInt(226);
            FileReader fr = new FileReader("apellidos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    //cada que recorre un token se le suma una unidad al contador
                    cont++;
                    String token = tokenizador.nextToken();
                    //si el contador es igual al número generado al azar, se concatena con el nombre anterior
                    if(cont == num)
                        nombre=nombre+" "+token;
                }
                linea = br.readLine(); //siguiente linea
            }
            
            br.close(); //cierra archivo
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        return nombre;
    }
}
