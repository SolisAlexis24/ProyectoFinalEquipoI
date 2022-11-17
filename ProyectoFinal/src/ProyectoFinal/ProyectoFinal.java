package ProyectoFinal;

/**
 *
 * @author Alexis
 */
public class ProyectoFinal {
    public static void main(String[] args){
        /*
        menu init = new menu();
        init.loginin();
        switch (init.acceso) {
            case 1 -> System.out.println("Administrador");
            case 2 -> System.out.println("Estudiante");
            default -> init.loginin();
        Alumno al = new Alumno();
        }
        */
        GeneradorNombres gen1 = new GeneradorNombres();
        gen1.leer();
        gen1.generarMombres();
    }
}
