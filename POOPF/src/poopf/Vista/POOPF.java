/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poopf.Vista;

import poopf.Modelo.Alumno;
import poopf.Controlador.GeneradorAlumnos;
/**
 *
 * @author Jair Carbajal
 */
public class POOPF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAlumnos generador = new GeneradorAlumnos();
        generador.generar();
        
        for (Alumno alu : generador.listado) {
            System.out.println("Nombre: "+alu.nombre);
            System.out.println("Edad: "+alu.edad);
            System.out.println("Dirección: "+alu.direccion);
            System.out.println("Semestre: "+alu.semestre);
            System.out.println("Número de cuenta: "+alu.numCuenta);
            System.out.println("Promedio: "+alu.promedio);
            System.out.println("Historial Académico:");
            System.out.println(alu.histAc);
            System.out.println("Número de inscripción: "+alu.numIns);
            System.out.println("\n");
        }
    }
    
}
