package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            case 6 -> salir();
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
        CRUDAlumnos crud = new CRUDAlumnos();
        if(crud.obtenerNumCuenta(GeneradorAlumnos.listado)){
            crud.visualizar(GeneradorAlumnos.listado);
        }
        else{
            System.out.println("Numero de cuenta invalido");
        }
        menu();
    }
    /**
     * Menu para modificar alumno
     */
    public void modificar(){
        System.out.println("--MODIFICAR ALUMNO--");
        CRUDAlumnos crud = new CRUDAlumnos();
        HistorialAcademico his = new HistorialAcademico();
        if(crud.obtenerNumCuenta(GeneradorAlumnos.listado)){
            Scanner leer = new Scanner(System.in);
            int op = 0;
            while(op!=6){
                System.out.println("Ingrese la opción deseada");
                System.out.println("1. Alta de materia");
                System.out.println("2. Baja de materia");
                System.out.println("3. Cambiar calificación de materia");
                System.out.println("4. Consultar historial academica");
                System.out.println("5. Cambiar direccion");
                System.out.println("6. Cambiar nombre");
                System.out.println("7. Cambiar edad");
                System.out.println("8. Guardar y regresar");
                op = leer.nextInt();
                switch(op){
                    case 1: crud.alta(GeneradorAlumnos.listado);
                    break;
                    case 2: crud.baja(GeneradorAlumnos.listado);
                    break;
                    case 3: crud.cambio(GeneradorAlumnos.listado);
                    break;
                    case 4: crud.consulta(GeneradorAlumnos.listado);
                    break;
                    case 5: crud.cambioDomicilio(GeneradorAlumnos.listado);
                    break;
                    case 6: crud.cambioNombre(GeneradorAlumnos.listado);
                    break;
                    case 7: crud.cambioEdad(GeneradorAlumnos.listado);
                    break;
                    case 8: menu();
                    break;
                    default: System.out.println("opción no válida");
                    break;
                }
            }
        }else 
            System.out.println("No se encontró el número de cuenta");
    }
    /**
     * Menu para aliminar alumno
     */
    public void eliminar(){
        System.out.println("--ELIMINAR ALUMNO--");
        CRUDAlumnos crud = new CRUDAlumnos();
        if(crud.obtenerNumCuenta(GeneradorAlumnos.listado)){
            crud.eliminar(GeneradorAlumnos.listado);
            System.out.println("Alumno eliminado con exito");
        }
        menu();
    }
    /**
     * Salir al menu principal
     */
    public void salir(){
        menuAD men = new menuAD();
        men.opc();
    }
}
