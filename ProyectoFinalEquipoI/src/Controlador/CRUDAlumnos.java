package Controlador;

import java.util.LinkedList;
import java.util.Scanner;

import Modelo.Alumno;

public class CRUDAlumnos {
    public int numCuenta;
    public boolean obtenerNumCuenta(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresar número de cuenta");
        numCuenta = leer.nextInt();
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta)
                return true;
        }
        return false;
    }
    
    public void alta(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String materia;
        int calif;
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno: "+ alumno.nombre);
                System.out.println("Ingrese la materia a registrar");
                materia = leer.nextLine();
                System.out.println("Ingrese la calificación obtenida");
                calif = leer.nextInt();
                alumno.histAc.put(materia, calif);
                System.out.println("Materia registrada");
            }
        }
    }

    public void baja(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String materia;
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno: "+alumno.nombre);
                System.out.println("Ingrese la materia a dar de baja");
                materia = leer.nextLine();
                if(alumno.histAc.remove(materia) != null){
                    System.out.println("La materia fue dada de baja");
                } else
                    System.out.println("La materia no se encuentra registrada");
            }
        }
    }

    public void cambio(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String materia;
        int calif;
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno: "+alumno.nombre);
                System.out.println("Ingrese la materia a cambiar de calificación");
                materia = leer.nextLine();
                System.out.println("Ingrese la calificación nueva");
                calif = leer.nextInt();
                if(alumno.histAc.replace(materia, calif) != null){
                    System.out.println("La materia fue modificada");
                } else
                    System.out.println("La materia no se encuentra registrada");
            }
        }
    }
    
    public void consulta(LinkedList<Alumno> listado){
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno: "+alumno.nombre);
                System.out.println("Historial académico");
                System.out.println(alumno.histAc);
            }
        }
    }
    /**
     * Metodo para poder cambiar el domiciulio de los alumnos
     * @param listado lista de alumnos
     */
    public void cambioDomicilio(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String direccion;
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno: " + alumno.nombre);
                System.out.println("Ingrese la nueva direccion: ");
                direccion = leer.nextLine();
                System.out.println("La nueva direccion sera: " + direccion);
                alumno.direccion = direccion;
            }
        }
    }
    /**
     * Metodo para visualizar alumno
     * @param listado lista de alumnos
     */
    public void visualizar(LinkedList<Alumno> listado){
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno : " + alumno.nombre);
                System.out.println("Direccion: " + alumno.direccion);
                System.out.println("Edad: " + alumno.edad);
                System.out.println("Numero de inscripcion: " + alumno.numIns);
            }
        }
    }
    /**
     * Metodo para eliminar alumno
     * @param listado lista de alumnos
     */
    public void eliminar(LinkedList<Alumno> listado){
        for(int i = 0; i< listado.size();i++){
            if(listado.get(i).numCuenta == numCuenta){
                listado.remove(listado.get(i));
            }
        }
    }
    /**
     * Metodo para crear alumno
     * @param listado lista de alumnos
     */
    public Alumno crear(LinkedList<Alumno> listado){
        //TODO: Crear Alumno
        Alumno alu = new Alumno();
        return alu;
    }
    /**
     * Consulta como alumno
     * @param listado
     */
    public void consultaAL(LinkedList<Alumno> listado){
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Alumno: "+alumno.nombre);
                System.out.println("Num Cuenta: " + alumno.numCuenta);
                System.out.println("Direccion: " + alumno.direccion);
                System.out.println("Edad: " + alumno.edad);
                System.out.println("Promedio " + alumno.promedio);
                System.out.println("Historial académico");
                System.out.println(alumno.histAc);
            }
        }
    }
    /**
     * Consultar numero de inscripcion
     * @param listado
     */
    public void consNumInsc(LinkedList<Alumno> listado){
        System.out.println("Tu numero de inscripcion es: ");
        for (Alumno alumno : listado) {
            if(alumno.numCuenta == numCuenta){
                System.out.println("Numero de inscripcion " + alumno.numIns);
            }
        }
    }
}
