package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import Modelo.Alumno;
import Controlador.*;

/**
 *Clase que sirve para poder modificar los datos de los alumnos
 * @author EquipoI
 */
public class modificarDatosAdmin {
    /**
     * Metodo de menu de acciones
     */
    public void menu(){
        System.out.println("¿Que opcion desea elegir?");
        System.out.println("1. Crear alumno");
        System.out.println("2. Ver informacion de alumno");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Eliminar alumno");
        try {
            String elec = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            elec = br.readLine();
            int eleci = Integer.parseInt(elec);
            switch (eleci) {
            case 1 -> crear();
            case 2 -> visualizar();
            case 3 -> modificar();
            case 4 -> eliminar();
            default -> {
                System.out.println("Opcion invalida");
                menu();
            }
            }
        } catch (IOException e) {
            System.out.println("Imposible leer");
        }
    }
    /**
     * Menu para crear alumno
     */
    public void crear(){
        System.out.println("--CREAR ALUMNO--");
        //TODO: Implementar crear alumno
    }
    /**
     * Menu para visualizrar datos de un alumno
     */
    public void visualizar(){
        System.out.println("--VISUALIZAR ALUMNO--");
        //TODO: Implementar visualizar alumno
    }
    /**
     * Menu para modificar alumno
     */
    public void modificar(){
        System.out.println("--MODIFICAR ALUMNO--");
        GeneradorAlumnos gen = new GeneradorAlumnos();
        CRUDAlumnos crud = new CRUDAlumnos();
        HistorialAcademico his = new HistorialAcademico();
        if(crud.obtenerNumCuenta(gen.listado)){
            Scanner leer = new Scanner(System.in);
            int op = 0;
            while(op!=5){
                System.out.println("Ingrese la opción deseada");
                System.out.println("1. Alta de materia");
                System.out.println("2. Baja de materia");
                System.out.println("3. Cambiar calificación de materia");
                System.out.println("4. Consultar historial academica");
                System.out.println("5. Guardar y regresar");
                op = leer.nextInt();
                switch(op){
                    case 1: crud.alta(gen.listado);
                    break;
                    case 2: crud.baja(gen.listado);
                    break;
                    case 3: crud.cambio(gen.listado);
                    break;
                    case 4: crud.consulta(gen.listado);
                    break;
                    case 5: for (Alumno alumno : gen.listado) {
                                if(alumno.numCuenta == crud.numCuenta){
                                    alumno.promedio = his.promedio(alumno.histAc);
                                    System.out.println("Alumno: "+alumno.nombre);
                                    System.out.println("Promedio: "+alumno.promedio);
                                    System.out.println("Historial académico:\n"+alumno.histAc);
                                    menu();
                                }
                            }
                    break;
                    default: System.out.println("opción no válida");
                    break;
                }
            }
        }else 
            System.out.println("No se encontró el número de cuenta");
        //TODO: Implementar Modificar alumno
    }
    /**
     * Menu para aliminar alumno
     */
    public void eliminar(){
        System.out.println("--ELIMINAR ALUMNO--");
        //TODO: Implementar eliminar alumno
    }
}
