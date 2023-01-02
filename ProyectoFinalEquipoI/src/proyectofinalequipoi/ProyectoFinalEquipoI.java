package proyectofinalequipoi;

import Controlador.GeneradorAlumnos;
import Vista.login;

public class ProyectoFinalEquipoI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAlumnos gen = new GeneradorAlumnos();
        gen.generar();
        login menu = new Vista.login();
        menu.loginin();
    }
}
