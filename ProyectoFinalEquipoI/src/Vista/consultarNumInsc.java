package Vista;

import Controlador.CRUDAlumnos;
import Controlador.GeneradorAlumnos;

/**
 * Esta clase permite mostrar al usuario su numero de inscripcion generado
 * @author EquipoI
 */
public class consultarNumInsc {
    /**
     * Este metodo permite, por medio el numero de cuenta, encontrar y mostrar 
     * el numero de inscripcion generado
     * @param key Numero de cuenta
     */
    public void mtr(int key){
        CRUDAlumnos crud = new CRUDAlumnos();
        crud.numCuenta = key;
        crud.consNumInsc(GeneradorAlumnos.listado);
        menuAL men = new menuAL();
        men.numCuenta = key;
        men.opc();
    }
}
