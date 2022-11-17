/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poopf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Jair Carbajal
 */
public class POOPF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Double> indicadores = new LinkedList<>();
        HashMap<String,Integer> historial;
        Alumno alu = new Alumno();
        NumInsc num = new NumInsc();
        Random rand = new Random();
        
        alu.semestre=3;
        historial=alu.obtenerHistorial(alu.semestre);
        System.out.println(historial);
        System.out.println(historial.size());
        
        //System.out.println("num de ins "+alu.numIns(historial));
        
        LinkedList<Alumno> listado = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            listado.add(new Alumno());
        }
        for (Alumno alumno : listado) {
            alumno.semestre=(int)Math.floor(Math.random()*(4-2+1)+2);
            System.out.println("semestre: " + alumno.semestre);
            alumno.histAc=alumno.obtenerHistorial(alumno.semestre);
        }
        System.out.println("calif");
        for (Alumno alumno : listado) {
            System.out.println(alumno.histAc);
        }
        System.out.println("numeros de inscripción");
        for (Alumno alumno : listado) {
            alumno.indicador=alumno.indEsc(alumno.histAc, indicadores);
            System.out.println(alumno.indicador);
        }
        for (Alumno alumno : listado) {
            System.out.println("num de inscripciones "+alumno.numIns(alumno.indicador, indicadores));
        }
    }
    
}
