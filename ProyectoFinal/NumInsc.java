/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poopf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jair Carbajal
 */
public class NumInsc{
    LinkedList<Double> indicadores = new LinkedList<>();
    
    public int creditosEsc(HashMap<String,Integer> materias){
        int cont=0;
        int flag=0;
        int creditos=0;
        try {
            FileReader fr = new FileReader("creditos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    String token = tokenizador.nextToken();
                    cont++;
                    if(cont==1){
                       for (String llave : materias.keySet()) {
                           if(llave.equals(token))
                               flag=1;
                        }
                    }
                    if(cont==2){
                        cont=0;
                        if(flag==1){
                            creditos = creditos + Integer.parseInt(token);
                            flag=0;
                        }    
                    }
                }
                linea = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return creditos;
    }
    
    public double escolaridad(HashMap<String, Integer> hisAc){
        double esc;
        LinkedList<String> aprobadas = new LinkedList<>();
        for(String key: hisAc.keySet()){
            if(hisAc.get(key) >5)
                aprobadas.add(key);
        }
        Double aprob= Double.valueOf(aprobadas.size());
        esc = (aprob/hisAc.size())*100;
        return esc;
    }
    
    public double velocidad(HashMap<String, Integer> hisAc){
        int creditos;
        int creditosAlu;
        double vel;
        HashMap<String,Integer> aprob = new HashMap<>();
        for(String key: hisAc.keySet()){
            if(hisAc.get(key) > 5)
                aprob.put(key, hisAc.get(key));
        }
        creditosAlu = creditosEsc(aprob);
        creditos = creditosEsc(hisAc);
        vel = (creditosAlu/Double.valueOf(creditos))*100;
        return vel;
    }
    
    public double promedio(HashMap<String, Integer> hisAc){
        int materias = hisAc.size();
        int suma=0;
        double prom;
        for (String llaves : hisAc.keySet()) {
            suma += hisAc.get(llaves);
        }
        prom = (suma/Double.valueOf(materias));
        return prom;
    }
    
    public double indEsc(HashMap<String, Integer> hisAc){
        double escol = escolaridad(hisAc);
        double veloc = velocidad(hisAc);
        double prom = promedio(hisAc);
        double indicador = (prom)*(escol)*(veloc);
        indicadores.add(indicador);
        return indicador;
    }
    
    public int numIns(HashMap<String, Integer> hisAc){
        int numIn;
        double ind = indEsc(hisAc);
        Collections.sort(indicadores, Collections.reverseOrder());
        numIn=indicadores.indexOf(ind);
        return numIn+1;
    }
}
