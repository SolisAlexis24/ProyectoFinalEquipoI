package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *clase que sirve como menu del administrador del sistema
 * @author EquipoI
 */
public class menuAD {
    /**
     * Menu para las opciones que tiene el admin
     */
    public void opc(){
        System.out.println("OPCIONES DE MENU ADMIN");
        System.out.println("1. Consultar datos de Estudiantes");
        System.out.println("2. Salir");
        try {
            String selc = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in)); 
            selc = br.readLine();
            int selci = Integer.parseInt(selc);
            switch (selci) {
                case 1 -> {
                    modificarDatosAdmin op = new modificarDatosAdmin();
                    op.menu();
                }
                case 2 ->{
                    login op = new login();
                    op.loginin();
                }
                default ->{
                    System.out.println("Opcion Invalida");
                    opc();
                }
            }
        } catch (IOException ex) {
            System.out.println("No fue posible leer la seleccion");
        }
            
    }
}
