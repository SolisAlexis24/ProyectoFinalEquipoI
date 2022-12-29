package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Esta clase muestra las acciones que puede realizar el alumno
 * @author EquipoI
 */
public class menuAL {
    public String numCuenta = "";
    /**
     * Este metodo muestra el menu de opciones
     */
    public void opc(){
        System.out.println("OPCIONES DE MENU ALUMNO");
        System.out.println("1. Consultar datos academicos y personales");
        System.out.println("2. Modificar datos personales");
        System.out.println("3. Consultar numero de inscripcion");
        try {
            String selc = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in)); 
            selc = br.readLine();
            int selci = Integer.parseInt(selc);
            switch (selci) {
                case 1 -> {
                    consultarDatosAL op = new consultarDatosAL();
                    op.mtr(numCuenta);
                }
                case 2 ->{
                    modificarDatosPeronsalesAl  op = new modificarDatosPeronsalesAl();
                    op.menu(numCuenta);
                }
                case 3 ->{
                    consultarNumInsc op = new consultarNumInsc();
                    op.mtr(numCuenta);
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
