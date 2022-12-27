package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *Clase que sirve para poder modificar los datos de los alumnos
 * @author EquipoI
 */
public class modificarDatosAdmin {
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
    public void crear(){
        System.out.println("--CREAR ALUMNO--");
        //TODO Implementar crear alumno
    }
    public void visualizar(){
        System.out.println("--vISUALIZAR ALUMNO--");
    }
    public void modificar(){
        System.out.println("--MODIFICAR ALUMNO--");
    }
    public void eliminar(){
        System.out.println("--ELIMINAR ALUMNO--");
    }
}
