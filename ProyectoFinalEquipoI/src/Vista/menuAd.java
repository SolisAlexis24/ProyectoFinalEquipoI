package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author Alexis
 */
public class menuAD {
    public void opc(){
        System.out.println("OPCIONES DE MENU ADMIN");
        System.out.println("1. Consultar datos de Estudiantes");
        System.out.println("2. Generar numero de inscripcion");

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
                    generarNumInsc op = new generarNumInsc();
                    op.generar();
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
