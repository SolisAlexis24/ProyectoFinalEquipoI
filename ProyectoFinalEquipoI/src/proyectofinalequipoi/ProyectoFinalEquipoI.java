package proyectofinalequipoi;

import Controlador.GeneradorAlumnos;
import Vista.Login;

public class ProyectoFinalEquipoI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAlumnos gen = new GeneradorAlumnos();
        gen.generar();
        Login menu = new Vista.Login();
        menu.loginin();
    }
}
