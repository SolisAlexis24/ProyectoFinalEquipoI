package Vista;

import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;

/**
 * Modificar datos personales del alumno
 * @author EquipoI
 */
public class modificarDatosPeronsalesAl {
    public void menu(int key){
        CRUDAlumnos crud = new CRUDAlumnos();
        crud.numCuenta = key;
        crud.cambioDomicilio(GeneradorAlumnos.listado);
        menuAL men = new menuAL();
        men.numCuenta = key;
        men.opc();
    }
}
