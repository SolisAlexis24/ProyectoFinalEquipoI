package Vista;

import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;

/**
 * Esta clase permite consultar los datos del alumno
 * @author EquipoI
 */
public class consultarDatosAL {
    /**
     * Este metodo permite encontar por medio el numero de cuenta, los datos del alumno
     * @param key Numero de cuenta 
     */
    public void mtr(int key){
        CRUDAlumnos crud = new CRUDAlumnos();
        crud.numCuenta = key;
        crud.consultaAL(GeneradorAlumnos.listado);
        menuAL men = new menuAL();
        men.numCuenta = key;
        men.opc();
    }
}
