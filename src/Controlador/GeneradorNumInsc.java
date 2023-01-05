package Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author EquipoI
 */
public abstract class GeneradorNumInsc{
    //Método para obtener creditos escolares
    public int creditosEsc(HashMap<String,Integer> materias){
        int cont=0;
        int flag=0;
        int creditos=0;
        try {
            //lee el archivo con la materia y los creditos
            FileReader fr = new FileReader("creditos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                //Lee cada linea del archivo
                while(tokenizador.hasMoreTokens()){
                    String token = tokenizador.nextToken();
                    //cada que se lee una linea, se suma al contador
                    cont++;
                    
                    if(cont==1){
                        for (String llave : materias.keySet()) {
                            //si la materia se encuentra en la lista, se activa la bandera
                            if(llave.equals(token))
                                flag=1;
                        }
                    }
                    if(cont==2){
                        //se reinicia contador
                        cont=0;
                        //si la bandera está activada, se suman los valores de los creditos de la materia
                        if(flag==1){
                            creditos = creditos + Integer.parseInt(token);
                            flag=0; //se reinicia la bandera
                        }    
                    }
                }
                linea = br.readLine(); //siguiente linea
            }
            
            br.close();//cierra archivo
        } catch (FileNotFoundException ex) {
            System.out.println("Imposible leer");
        } catch (IOException ex) {
            System.out.println("Imposible leer");
        }
        //retorna el numero de creditos de la lista
        return creditos;
    }
    
    //Método que obtiene la escolaridad
    public double escolaridad(HashMap<String, Integer> hisAc){
        double esc;
        //Lista de materias aprobadas
        LinkedList<String> aprobadas = new LinkedList<>();
        for(String key: hisAc.keySet()){
            if(hisAc.get(key) >5)
                aprobadas.add(key);//Si la calificación de la materia es mayor a 5, se asigna a la lista de aprobadas
        }
        Double aprob= Double.valueOf(aprobadas.size());//número de materias aprobadas
        esc = (aprob/hisAc.size())*100;//fórmula de la escolaridad (materias aprob/materias totales)*100
        return esc;
    }
    
    //Método que devuelve la velocidad
    public double velocidad(HashMap<String, Integer> hisAc){
        int creditos;
        int creditosAlu;
        double vel;
        HashMap<String,Integer> aprob = new HashMap<>();//Materias aprobadas
        for(String key: hisAc.keySet()){
            if(hisAc.get(key) > 5)
                aprob.put(key, hisAc.get(key));//Si la calif es mayor a 5, se agrega a la tabla de aprobadas
        }
        creditosAlu = creditosEsc(aprob);//creditos de las materias aprobadas
        creditos = creditosEsc(hisAc);//creditos totales
        vel = (creditosAlu/Double.valueOf(creditos))*100; //fórmula de la velocidad (cred aprob/ cred total)*100
        return vel;
    }
    
    //Método que devuelve el promedio
    public double promedio(HashMap<String, Integer> hisAc){
        int materias = hisAc.size();//número de materias totales
        int suma=0;
        double prom;
        for (String llaves : hisAc.keySet()) {
            suma += hisAc.get(llaves);//suma de las calificaciones del hist ac.
        }
        prom = (suma/Double.valueOf(materias));//fórmula del promedio
        return prom;
    }
    
    //Método que devuelve el índice escolar
    public double indEsc(HashMap<String, Integer> hisAc, LinkedList<Double> indicadores){
        double escol = escolaridad(hisAc);//escolaridad
        double veloc = velocidad(hisAc); //velocidad
        double prom = promedio(hisAc); //promedio
        double indicador = (prom)*(escol)*(veloc); //fórmula del indicador
        indicadores.add(indicador); //lo añade a la lista de indicadores
        return indicador;
    }
    
    public int numIns(double ind, LinkedList<Double> indicadores){
        int numIn;
        Collections.sort(indicadores, Collections.reverseOrder());//ordena los inidcadpores de mayor a menor
        numIn=indicadores.indexOf(ind);//busca la posición del inidcador de un alumno
        return numIn+1;//regresa la posición (número de inscripción)
    }
}