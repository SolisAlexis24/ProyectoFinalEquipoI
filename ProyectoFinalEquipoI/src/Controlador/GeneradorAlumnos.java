package Controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import Modelo.Alumno;

/**
 *
 * @author tripl
 */
public class GeneradorAlumnos {
    public static LinkedList<Alumno> listado = new LinkedList<>(); //Lista de alumnos
    
    public void generar(){
        HistorialAcademico hist = new HistorialAcademico();
        Nombres nom = new Nombres();
        DatosPersonales data = new DatosPersonales();
        LinkedList<Double> indicadores = new LinkedList<>(); //Lista del número indicador de cada alumno
        
        for (int i = 0; i < 10; i++) {
            listado.add(new Alumno());
        }// Genera el número de alumnos establecido por el for
        //Listado de alumnos
        for (Alumno alumno : listado) {
            alumno.nombre = nom.nombre();
            alumno.edad = data.edad();
            alumno.direccion = data.direccion();
            alumno.numCuenta = data.numCuenta();
            alumno.semestre = data.semestre();
            alumno.histAc = hist.obtenerHistorial(alumno.semestre);
            alumno.promedio = hist.promedio(alumno.histAc);
        }
        
        //Listado de los indicadores
        for (Alumno alumno : listado) {
            alumno.indicador = hist.indEsc(alumno.histAc, indicadores);
        }
        
        //Asignación de número de inscripción
        for (Alumno alumno : listado) {
            alumno.numIns = hist.numIns(alumno.indicador, indicadores);
        }

        FileWriter ar;
        PrintWriter pw;
        try {
            ar = new FileWriter("numsC.txt");
            pw = new PrintWriter(ar);
            for (Alumno alumno : listado) {
                Integer nc = alumno.numCuenta;
                pw.println(Integer.toString(alumno.numCuenta));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("FALLA AL GUARDAR NUMEROS DE CUENTA");
        }
    }

    
}
