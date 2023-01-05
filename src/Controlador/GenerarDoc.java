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
    /**
     * Metodo para generar el documento .csv
     * @param listado lista de alumnos
     */
    public void genDoc(LinkedList<Alumno> listado){
        LinkedList<String> cadenas = new LinkedList<>();
        String cadena, materia;
        //Por cada alumno del listado, se obtendrán sus datos y se concatenarán agregando comas
        for (Alumno alumno : listado) {
            cadena = alumno.getNumCuenta() + ", ";
            cadena = cadena + alumno.getNombre() + ", ";
            cadena = cadena + alumno.getEdad() + ", ";
            cadena = cadena + alumno.getDireccion() + ", ";
            cadena = cadena + alumno.getSemestre() + ", ";
            cadena = cadena + alumno.getPromedio() + ", ";
            cadena = cadena + alumno.getNumIns() + ", ";
            for (String mts : alumno.getHistAc().keySet()) {
                materia = mts;
                materia = materia + ": " + alumno.getHistAc().get(mts) + ", ";
                cadena = cadena + materia;
            }
            cadenas.add(cadena);//Se agregan a una lista de cadenas, las cuales conienen  los datos de cada alumno
        }
        
        try{
            FileWriter fw = new FileWriter("AlumnosGenerados.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter sd = new PrintWriter(bw);
            sd.println("Numero de cuenta, Nombre, Edad, Direccion, Semestre, Promedio, Numero de inscripcion, Materias");
            //se obtendrá la info de  cada alumno
            for (String cad : cadenas) {
                sd.println(cad);//se agregará a la siguiente linea del archivo
            }
            sd.close();
        }catch (IOException ex) {
            System.out.println("No fue posible abrir el archivo");
        }
    }
}
