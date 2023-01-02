package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import Modelo.Alumno;
import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;


/**
 * Esta clase es para el login general, con ella se muestra un menu para poder acceder
 * como un administrador o como un alumno
 * @author EquipoI
 */
public class login {
    private int acceso = 0;
    /**
     * Clase de menu de acceso
     */
    public void loginin(){
        System.out.println("¿Qué clase de usuario eres?");
        System.out.println("1. Administrador académico");
        System.out.println("2. Estudiante");
        System.out.println("3. Salir");
        try{
            String tipoUs = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            tipoUs = br.readLine();
            int tipoUsn = Integer.parseInt(tipoUs);
            this.acceso = tipoUsn;
            switch (tipoUsn) {
            case 1 -> loginAd();
            case 2 -> loginAL();
            case 3 -> Salir();
            default -> {
                System.out.println("Opcion no reconocida");
                loginin();
                }
            }
        }catch(IOException ioe){
            System.out.println("Error al leer desde teclado");
        }
    }
    /**
     * Clase de menu del login del alumno
     */
    private void loginAL() {
        CRUDAlumnos crud = new CRUDAlumnos();
        try{
            if(crud.obtenerNumCuenta(GeneradorAlumnos.listado)){
                menuAL men = new menuAL();
                men.numCuenta = crud.numCuenta;
                men.opc();
            }else{
                System.out.println("Numero de cuneta invalido");
                loginAL();
            }
        }catch(Exception ioe){
            System.out.println("falla al recibir los datos");
        }
    }
    /**
     * Clase de login para el admin
     */
    public void loginAd(){
        System.out.println("Introduzca su contrasena para ingresar:");
        try {
            String cont = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            cont = br.readLine();
            if("12345".equals(cont)){
                menuAD menu = new menuAD();
                menu.opc();
            }else{
                System.out.println("Constrasena incorrecta"); 
                loginAd();
            }
        } catch (IOException ex) {
            System.out.println("Contrasena imposible de leer");
        }
    }

    public void Salir(){
    }
}
