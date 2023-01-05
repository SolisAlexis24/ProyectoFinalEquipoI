package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import Modelo.Alumno;
import proyectofinalequipoi.ProyectoFinalEquipoI;
import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;
import Controlador.GenerarDoc;
import java.util.Scanner;


/**
 * Esta clase es para el Login general, con ella se muestra un menu para poder acceder
 como un administrador o como un alumno
 * @author EquipoI
 */
public class Login {
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
            case 1 : loginAd();
            case 2 : loginAL();
            case 3 : Salir();
            default : {
                System.out.println("Opcion no reconocida");
                loginin();
                }
            }
        }catch(IOException ioe){
            System.out.println("Error al leer desde teclado");
        }catch(NumberFormatException e){
            System.out.println("Opcion no reconocida");
            loginin();
        }
    }
    /**
     * Clase de menu del Login del alumno
     */
    private void loginAL() {
        CRUDAlumnos crud = new CRUDAlumnos();
        System.out.println("1. Introducir número de cuenta");
        System.out.println("2. Regresar"); 
        try{
            String op = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            op = br.readLine();
            int opc = Integer.parseInt(op);
            switch(opc){
                case 1:
                    try{
                        if(crud.obtenerNumCuenta(GeneradorAlumnos.listado)){
                            MenuAL men = new MenuAL();
                            men.numCuenta = crud.numCuenta;
                            men.opc();
                        }else{
                            System.out.println("Numero de cuneta invalido");
                            opc=2;
                            loginAL();
                        }
                    }catch(Exception ioe){
                        System.out.println("falla al recibir los datos");
                    }
                break;
                case 2: loginin(); break;
                default: System.out.println("opción no válida");
            }
        }catch(IOException ioe){
            System.out.println("Error al leer desde teclado");
        }
        catch(NumberFormatException e){
            System.out.println("Opcion no reconocida");
            loginAL();
        } 
        
    }
    /**
     * Clase de Login para el admin
     */
    public void loginAd(){
        System.out.println("1. Introducir contraseña");
        System.out.println("2. Regresar");
        try{
            String op = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            op = br.readLine();
            int opc = Integer.parseInt(op);      
            switch(opc){
                case 1:
                    System.out.println("Introduzca su contrasena para ingresar:");
                    try {
                        String cont = "";
                        BufferedReader brr;
                        brr = new BufferedReader(new InputStreamReader(System.in));
                        cont = brr.readLine();
                        if("12345".equals(cont)){
                            MenuAd menu = new MenuAd();
                            menu.opc();
                        }else{
                            System.out.println("Constrasena incorrecta"); 
                            loginAd();
                        }
                    } catch (IOException ex) {
                        System.out.println("Contrasena imposible de leer");
                    }
                break;
                case 2: loginin(); break;
                default: System.out.println("opción no válida");
            }
        }catch(IOException ioe){
            System.out.println("Error al leer desde teclado");
        }catch(NumberFormatException e){
            System.out.println("Opcion no reconocida");
            loginAd();
        }    
    }

    public void Salir(){
        GenerarDoc doc = new GenerarDoc();
        doc.genDoc(GeneradorAlumnos.listado);
        System.exit(0);
    }
}
