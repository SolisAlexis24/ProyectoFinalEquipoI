package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Controlador.generadorNumsInsc;
/**
 *Esta clase muestra el menu para poder generar los numeros de inscripcion
 * @author EquipoI
 */
public class generarNumInsc {
    public void generar(){
        System.out.println("¿Desa generar los numeros de inscripcion?[s/n]");
        try{
            String elec = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            elec = br.readLine();
            switch(elec){
            case "s" ->{
                generadorNumsInsc gen = new generadorNumsInsc();
                gen.generar();
                menuAD menu = new menuAD();
                menu.opc();
            }
            case "n"->{
                menuAD menu = new menuAD();
                menu.opc();
            }
            default -> System.out.println("Opcion no reconocida");
            }
        }catch(IOException ioe){
            System.out.println("Imposible leer eleccion");
        }
    }
}
