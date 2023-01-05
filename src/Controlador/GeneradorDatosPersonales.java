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
public class GeneradorDatosPersonales {
    //Método que retorna la edad
    public int edad(){
        //Número random del 17 al 26
        int edad=(int)(Math.floor(Math.random()*(26-17+1)+17));
        return edad;
    }
    
    //Método que regresa dirección
    public String direccion(){
        String dir=null;
        Random rand = new Random();
        //Genera un número al azar del 0 al 500 el cual representa la posición de la dirección a tomar
        int num=rand.nextInt(500), cont=0;
        try {
            //Leerá el archivo que contiene las direcciones
            FileReader fr = new FileReader("direcciones.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                //Leerá token por token separado por comas
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    //Se recorrerán todos los tokens hasta que sea igual a la posición generada al azar
                    cont++;
                    String token = tokenizador.nextToken();
                    if(cont == num){
                        dir=token;
                        break;
                    }
                }
                linea = br.readLine(); //pasa a la siguiente linea
            }           
            br.close();//cierra el lectro de archivo
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        return dir;
    }
    
    //Método que asigna un número de cuenta
    public int numCuenta(){
        Random rand = new Random();
        String numCuen="";
        for (int i = 0; i < 9; i++) {
            //asigna un número entero del 1 al 9 
            int r1 = rand.nextInt(9);
            //Si en la primera iteración r1 es cero, se le suma una unidad
            if(i==0 && r1==0){
                    r1+=1;
            }
            //Luego, se concatenan los números conviertiendolos en cadenas
            numCuen += String.valueOf(r1);
        }
        //retrona la cadena concatenada pasada a entero
        return Integer.parseInt(numCuen);
    }
    
    /**
     * Método que asigna el semestre
     * @param edad edad del alumno
     */
    //
    public int semestre(int edad){
        int semestre = 0;
        //Si el alumno es mayor a 18, podrá estar inscrito a cualquier semestre
        if(edad > 18){
            semestre=(int)Math.floor(Math.random()*(10-2+1)+2);
            return semestre;
        }else{
            //Si tiene 18 o menos no puede estar en 5 semestre o mayor
            semestre=(int)Math.floor(Math.random()*(4-2+1)+2);
        }
        return semestre;
    }
}
