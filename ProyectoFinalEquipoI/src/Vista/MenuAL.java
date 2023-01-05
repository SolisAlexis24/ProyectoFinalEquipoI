package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Esta clase muestra las acciones que puede realizar el alumno
 * @author EquipoI
 */
public class MenuAL {
    public int numCuenta;
    /**
     * Este metodo muestra el menu de opciones
     */
    public void opc(){
        System.out.println("OPCIONES DE MENU ALUMNO");
        System.out.println("1. Consultar datos academicos y personales");
        System.out.println("2. Modificar datos personales");
        System.out.println("3. Consultar numero de inscripcion");
        System.out.println("4. Regresar");
        try {
            String selc = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in)); 
            selc = br.readLine();
            int selci = Integer.parseInt(selc);
            switch (selci) {
                case 1 : {
                    ConsultarDatosAL op = new ConsultarDatosAL();
                    op.mtr(numCuenta);
                } break;
                case 2 :{
                    ModificarDatosPeronsalesAl  op = new ModificarDatosPeronsalesAl();
                    op.menu(numCuenta);
                }break;
                case 3 :{
                    ConsultarNumInsc op = new ConsultarNumInsc();
                    op.mtr(numCuenta);
                }break;
                case 4: System.out.println("regresando...");break;
                default :{
                    System.out.println("Opcion Invalida");
                    opc();
                }
            }
        } catch (IOException ex) {
            System.out.println("No fue posible leer la seleccion");
        }catch(NumberFormatException e){
            System.out.println("Opcion Invalida");
            opc();
        }
    }
}
