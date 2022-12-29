/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poopf.Controlador;

import poopf.Vista.POOPF;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jair Carbajal
 */
public class HistorialAcademico extends NumInsc{
    
    public HashMap obtenerHistorial(int semestre){
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
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hisAc;
    }
}
