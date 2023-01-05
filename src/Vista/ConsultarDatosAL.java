package Vista;

import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;

/**
 * Esta clase permite consultar los datos del alumno
 * @author EquipoI
 */
public class ConsultarDatosAL {
    /**
     * Este metodo permite encontar por medio el numero de cuenta, los datos del alumno
     * @param key Numero de cuenta 
     */
    public void mtr(int key){
        CRUDAlumnos crud = new CRUDAlumnos();
        crud.numCuenta = key;
        crud.consultaAL(GeneradorAlumnos.listado);
        MenuAL men = new MenuAL();
        men.numCuenta = key;
        men.opc();
    }
}
