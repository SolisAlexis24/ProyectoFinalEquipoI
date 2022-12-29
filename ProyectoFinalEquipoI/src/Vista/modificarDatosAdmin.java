package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
