package Vista;

import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;

/**
 * Modificar datos personales del alumno
 * @author EquipoI
 */
public class ModificarDatosPeronsalesAl {
    public void menu(int key){
        CRUDAlumnos crud = new CRUDAlumnos();
        crud.numCuenta = key;
        crud.cambioDomicilio(GeneradorAlumnos.listado);
        MenuAL men = new MenuAL();
        men.numCuenta = key;
        men.opc();
    }
}
