package Controlador;

import java.util.LinkedList;
import java.util.Scanner;

import Modelo.Alumno;

public class CRUDAlumnos {
    public int numCuenta;
    
    /**
     * Metodo para verificar si existe un número de cuenta
     * @param listado lista de alumnos
     */
    public boolean obtenerNumCuenta(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresar número de cuenta");
        numCuenta = leer.nextInt();
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta)
                return true;
        }
        return false;
    }
    
    /**
     * Metodo para dar de alta una materia
     * @param listado lista de alumnos
     */
    public void alta(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String materia;
        int calif;
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: "+ alumno.getNombre());
                System.out.println("Ingrese la materia a registrar");
                materia = leer.nextLine();
                System.out.println("Ingrese la calificación obtenida");
                calif = leer.nextInt();
                alumno.getHistAc().put(materia, calif);
                System.out.println("Materia registrada");
            }
        }
    }

    /**
     * Metodo para dar de baja una materia
     * @param listado lista de alumnos
     */
    public void baja(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String materia;
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: "+alumno.getNombre());
                System.out.println("Ingrese la materia a dar de baja");
                materia = leer.nextLine();
                if(alumno.getHistAc().remove(materia) != null){
                    System.out.println("La materia fue dada de baja");
                } else
                    System.out.println("La materia no se encuentra registrada");
            }
        }
    }

    /**
     * Metodo para cambiar una materia
     * @param listado lista de alumnos
     */
    public void cambio(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String materia;
        int calif;
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: "+alumno.getNombre());
                System.out.println("Ingrese la materia a cambiar de calificación");
                materia = leer.nextLine();
                System.out.println("Ingrese la calificación nueva");
                calif = leer.nextInt();
                if(alumno.getHistAc().replace(materia, calif) != null){
                    System.out.println("La materia fue modificada");
                } else
                    System.out.println("La materia no se encuentra registrada");
            }
        }
    }
    /**
     * Metodo para consultar una materia
     * @param listado lista de alumnos
     */
    public void consulta(LinkedList<Alumno> listado){
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: "+alumno.getNombre());
                System.out.println("Promedio: "+alumno.getPromedio());
                System.out.println("Historial académico");
                System.out.println(alumno.getHistAc());
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
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: " + alumno.getNombre());
                System.out.println("Ingrese la nueva direccion: ");
                direccion = leer.nextLine();
                System.out.println("La nueva direccion sera: " + direccion);
                alumno.setDireccion(direccion);
            }
        }
    }
    /**
     * Metodo para cambiar nombre de alumno
     * @param listado lista de alumnos
     */
    public void cambioNombre(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        String nombre;
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: " + alumno.getNombre());
                System.out.println("Ingrese la nuevo nombre: ");
                nombre = leer.nextLine();
                System.out.println("El nuevo nombre sera: " + nombre);
                alumno.setNombre(nombre);
            }
        }
    }
    /**
     * Metodo para cambiar la edad
     * @param listado listado de alumnos
     */
    public void cambioEdad(LinkedList<Alumno> listado){
        Scanner leer = new Scanner(System.in);
        int edad;
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: " + alumno.getNombre());
                System.out.println("Ingrese la edad: ");
                edad = leer.nextInt();
                System.out.println("La nueva edad sera: " + edad);
                alumno.setEdad(edad);       
            }
        }
    }
    /**
     * Metodo para visualizar alumno
     * @param listado lista de alumnos
     */
    public void visualizar(LinkedList<Alumno> listado){
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno : " + alumno.getNombre());
                System.out.println("Direccion: " + alumno.getDireccion());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Numero de inscripcion: " + alumno.getNumIns());
            }
        }
    }
    /**
     * Metodo para eliminar alumno
     * @param listado lista de alumnos
     */
    public void eliminar(LinkedList<Alumno> listado){
        for(int i = 0; i< listado.size();i++){
            if(listado.get(i).getNumCuenta() == numCuenta){
                listado.remove(listado.get(i));
            }
        }
    }
    /**
     * Metodo para crear alumno
     * @param listado lista de alumnos
     */
    public void crear(LinkedList<Alumno> listado){
        //TODO: Crear Alumno
        Alumno alu = new Alumno();
        GeneradorDatosPersonales dt = new GeneradorDatosPersonales();
        Scanner info = new Scanner(System.in);
        System.out.println("Introduzca el nombre del alumno: ");
        alu.setNombre(info.nextLine());
        alu.setNumCuenta(dt.numCuenta());
        System.out.println("El numero de cuneta de " + alu.getNombre() + " es: " + alu.getNumCuenta());
        System.out.println("Introduzca su direccion: ");
        alu.setDireccion(info.nextLine());
        System.out.println("Introduzca su edad");
        alu.setEdad(info.nextInt());
        System.out.println("Introduzca su semestre actual");
        alu.setSemestre(info.nextInt());
        listado.add(alu);
        System.out.println("Si desea dar de alta materias, remitase al menu para ello");
    }
    /**
     * Consulta como alumno
     * @param listado
     */
    public void consultaAL(LinkedList<Alumno> listado){
        for (Alumno alumno : listado) {
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Alumno: "+alumno.getNombre());
                System.out.println("Num Cuenta: " + alumno.getNumCuenta());
                System.out.println("Direccion: " + alumno.getDireccion());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Promedio " + alumno.getPromedio());
                System.out.println("Historial académico");
                System.out.println(alumno.getHistAc());
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
            if(alumno.getNumCuenta() == numCuenta){
                System.out.println("Numero de inscripcion " + alumno.getNumIns());
            }
        }
    }
}
