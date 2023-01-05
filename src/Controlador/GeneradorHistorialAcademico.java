package Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author EquipoI
 */
public class GeneradorHistorialAcademico extends GeneradorNumInsc{
    //Método para obtener el historial académico
    public HashMap<String, Integer> obtenerHistorial(int semestre){
        //Se crea un Hashtable donde tenga como llave la materia y como valor la calificación
        HashMap<String, Integer> hisAc = new HashMap<>();
        int cont=0;
        int calif;
        try {
            //Leemos el archivo materias el cual cada linea contiene las materias por semestre
            FileReader fr = new FileReader("materias.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                //Al leer una linea, el contador sumará una unidad
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                cont++;
                while(tokenizador.hasMoreTokens()){
                    //Se geenra una calificación al azar
                    calif = (int)Math.floor(Math.random()*(10-5+1)+5);
                    String token = tokenizador.nextToken();
                    //Si el contador es menor que el semestre, se asigna a la tabla Hash
                    if(cont < semestre)
                        hisAc.put(token, calif);
                }
                linea = br.readLine();//pasa a la siguiente linea
            }
            
            br.close(); //cierra el archivo
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        return hisAc;
    }
}