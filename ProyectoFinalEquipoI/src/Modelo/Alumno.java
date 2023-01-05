package Modelo;

import java.util.HashMap;

/**
 *
 * @author EquipoI
 */
public class Alumno{
    //Atributos que posee un alumno
    private String nombre, direccion;
    private int semestre, edad, numCuenta;
    private HashMap<String, Integer> histAc;
    private double promedio;
    private int numIns;
    private double indicador;

    
    //Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public HashMap<String, Integer> getHistAc() {
        return histAc;
    }

    public void setHistAc(HashMap<String, Integer> histAc) {
        this.histAc = histAc;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getNumIns() {
        return numIns;
    }

    public void setNumIns(int numIns) {
        this.numIns = numIns;
    }

    public double getIndicador() {
        return indicador;
    }

    public void setIndicador(double indicador) {
        this.indicador = indicador;
    }
    
    
}