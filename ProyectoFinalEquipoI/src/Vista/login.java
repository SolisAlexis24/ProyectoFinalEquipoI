package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Controlador.LeeryGuardar;

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
        System.out.println("Introduzca su numero de cuenta:");
        LeeryGuardar lect = new LeeryGuardar();
        ArrayList<String> numsCuenta = new ArrayList<>();
        numsCuenta = lect.lyg("numsCuenta.csv");
        try{
            String numC = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            numC = br.readLine();
            //TODO:Verificar si el numero de cuneta esta en la base de datos y si lo esta, pedir la constrasena
            if(numsCuenta.contains(numC)){
                
                menuAL men = new menuAL();
                men.numCuenta = numC;
                men.opc();
            }else{
                System.out.println("Numero de cuneta invalido");
                loginAL();
            }
        }catch(IOException ioe){
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
}
