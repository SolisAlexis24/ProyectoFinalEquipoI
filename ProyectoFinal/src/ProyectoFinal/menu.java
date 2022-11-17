package ProyectoFinal;

import java.util.Scanner;

public class menu {
    int acceso = 0;
    public void loginin(){
        System.out.println("¿Qué clase de usuario eres?");
        System.out.println("1. Administrador académico");
        System.out.println("2. Estudiante");
        Scanner input = new Scanner(System.in);
        String tipoUs = input.nextLine();
        int tipoUsn = Integer.parseInt(tipoUs);
        this.acceso = tipoUsn;
        input.close();
    }
    public void estudiante(){
        System.out.println("Numero de cuenta:");
        
    }
}

