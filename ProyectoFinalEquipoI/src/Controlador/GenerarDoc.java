package Controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import Modelo.Alumno;

/**
 *
 * @author tripl
 */
public class GenerarDoc {
    public void genDoc(LinkedList<Alumno> listado){
        LinkedList<String> cadenas = new LinkedList<>();
        String cadena, materia;
        for (Alumno alumno : listado) {
            cadena = alumno.numCuenta + ", ";
            cadena = cadena + alumno.nombre + ", ";
            cadena = cadena + alumno.edad + ", ";
            cadena = cadena + alumno.direccion + ", ";
            cadena = cadena + alumno.semestre + ", ";
            cadena = cadena + alumno.promedio + ", ";
            cadena = cadena + alumno.numIns + ", ";
            for (String mts : alumno.histAc.keySet()) {
                materia = mts;
                materia = materia + ": " + alumno.histAc.get(mts) + ", ";
                cadena = cadena + materia;
            }
            cadenas.add(cadena);
        }
        
        try{
            FileWriter fw = new FileWriter("AlumnosGenerados.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter sd = new PrintWriter(bw);
            sd.println("Numero de cuenta, Nombre, Edad, Direccion, Semestre, Promedio, Numero de inscripcion, Materias");
            for (String cad : cadenas) {
                sd.println(cad);
            }
            sd.close();
        }catch (IOException ex) {
            System.out.println("No fue posible abrir el archivo");
        }
    }
}
