/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poopf.Controlador;

import java.util.LinkedList;
import poopf.Modelo.Alumno;

/**
 *
 * @author tripl
 */
public class GeneradorAlumnos {
    public LinkedList<Alumno> listado = new LinkedList<>(); //Lista de alumnos
    
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
    }
}