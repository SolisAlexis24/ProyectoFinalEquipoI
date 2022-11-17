package ProyectoFinal;

public class Alumno {
    private String nombre, direccion;
    private int numCuenta, semestre, contrasena, edad, creditos, numInsc;
    private Historial historialAcademico;

    public Alumno() {
    }

    public Alumno(String nombre, String direccion, int numCuenta, int semestre, int contrasena, int edad, int creditos, int numInsc, Historial historialAcademico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numCuenta = numCuenta;
        this.semestre = semestre;
        this.contrasena = contrasena;
        this.edad = edad;
        this.creditos = creditos;
        this.numInsc = numInsc;
        this.historialAcademico = historialAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getNumInsc() {
        return numInsc;
    }

    public void setNumInsc(int numInsc) {
        this.numInsc = numInsc;
    }

    public Historial getHistorialAcademico() {
        return historialAcademico;
    }

    public void setHistorialAcademico(Historial historialAcademico) {
        this.historialAcademico = historialAcademico;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", direccion=" + direccion + ", numCuenta=" + numCuenta + ", semestre=" + semestre + ", contrasena=" + contrasena + ", edad=" + edad + ", creditos=" + creditos + ", numInsc=" + numInsc + ", historialAcademico=" + historialAcademico + '}';
    }
    
}
