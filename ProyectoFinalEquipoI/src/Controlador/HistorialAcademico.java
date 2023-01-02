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
public class HistorialAcademico extends NumInsc{
    
    public HashMap<String, Integer> obtenerHistorial(int semestre){
        HashMap<String, Integer> hisAc = new HashMap<>();
        int cont=0;
        int calif;
        try {
            FileReader fr = new FileReader("materias.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                cont++;
                while(tokenizador.hasMoreTokens()){
                    calif = (int)Math.floor(Math.random()*(10-5+1)+5);
                    String token = tokenizador.nextToken();
                    if(cont < semestre)
                        hisAc.put(token, calif);
                }
                linea = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        return hisAc;
    }
}