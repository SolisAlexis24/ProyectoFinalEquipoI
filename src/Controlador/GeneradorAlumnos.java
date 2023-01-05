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
        GeneradorHistorialAcademico hist = new GeneradorHistorialAcademico();
        GeneradorNombres nom = new GeneradorNombres();
        GeneradorDatosPersonales data = new GeneradorDatosPersonales();
        LinkedList<Double> indicadores = new LinkedList<>(); //Lista del número indicador de cada alumno
        
        for (int i = 0; i < 500; i++) {
            listado.add(new Alumno());
        }// Genera el número de alumnos establecido por el for
        
        //For each que le asigna los atributos a cada alumno dentro del listado
        for (Alumno alumno : listado) {
            alumno.setNombre(nom.nombre());
            alumno.setEdad(data.edad());
            alumno.setDireccion(data.direccion());
            alumno.setNumCuenta(data.numCuenta());
            alumno.setSemestre(data.semestre(alumno.getEdad()));
            alumno.setHistAc(hist.obtenerHistorial(alumno.getSemestre()));
            alumno.setPromedio(hist.promedio(alumno.getHistAc()));
        }
        
        //Listado de los indicadores
        for (Alumno alumno : listado) {
            alumno.setIndicador(hist.indEsc(alumno.getHistAc(), indicadores));
        }
        
        //Asignación de número de inscripción
        for (Alumno alumno : listado) {
            alumno.setNumIns(hist.numIns(alumno.getIndicador(), indicadores));
        }

        FileWriter ar;
        PrintWriter pw;
        //Asigna cada número de cuenta a un archivo de texto
        try {
            ar = new FileWriter("numsC.txt");
            pw = new PrintWriter(ar);
            for (Alumno alumno : listado) {
                pw.println(Integer.toString(alumno.getNumCuenta()));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("FALLA AL GUARDAR NUMEROS DE CUENTA");
        }
    }

    
}
