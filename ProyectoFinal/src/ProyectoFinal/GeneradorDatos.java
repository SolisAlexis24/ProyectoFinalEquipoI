package ProyectoFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneradorDatos {
    public String nom = "";
    public String ape = "";
    List<String> nomList = new ArrayList<>();
    List<String> apeList = new ArrayList<>();
    List<Integer> EdadesList = new ArrayList<>();

    public void leer(){
        int cont = 0;
        try{
            BufferedReader br;
            FileReader fr = new FileReader("nombres.csv");
            br = new BufferedReader(fr);
            this.nom = br.readLine();
            /*System.out.println(nom);*/
            br.close();
        }catch(IOException ioe){
            System.out.println("Imposible leer");
        }
        try{
            BufferedReader br1;
            FileReader fr1 = new FileReader("apellidos.csv");
            br1 = new BufferedReader(fr1);
            this.ape = br1.readLine();
            /*System.out.println(ape);*/
            br1.close();
        }catch(IOException ioe){
            System.out.println("Imposible leer");
        }
        StringTokenizer tokenizer = new StringTokenizer(nom, ",");
        while(tokenizer.hasMoreTokens()){
            nomList.add(cont, tokenizer.nextToken());
            cont++;
        }
        cont = 0;
        StringTokenizer tokenizer1 = new StringTokenizer(ape, ",");
        while(tokenizer1.hasMoreTokens()){
            apeList.add(cont, tokenizer1.nextToken());
            cont++;
        }
    }
    public String generarNombre(){
        String nomGen = "";
        Random numAl = new Random();
        boolean elec = numAl.nextBoolean();
        //Para nombres de mujer (0, 50)
        if(elec){
            int r1 = (int)(Math.random()*50);
            int r2 = (int)(Math.random()*50);
            int r3 = (int)(Math.random()*228);
            nomGen = nomList.get(r1) + " "+ nomList.get(r2)+" "+ apeList.get(r3)+ " " + apeList.get(r1));
        }
        //Para nombres de hombre (51, 100)
        else{
            int r1 = (int)(Math.random()*(100-51)+50);
            int r2 = (int)(Math.random()*(100-51)+50);  
            int r3 = (int)(Math.random()*228);
            nomGen = nomList.get(r1) + " "+ nomList.get(r2)+" "+ apeList.get(r3)+ " " + apeList.get(r1));
       }
        return nomGen();
    }
    public int generadorEdad(){
        int r1 = (int)(Math.random()*(25-19)+18);
        return r1;
    }
    
    public String generadorNumCuenta(){
        String numCuenta = "";
        for (int j = 0; j < 9; j++) {
            int r1 = (int)(Math.random()*(9-1)+0);
            numCuenta += String.valueOf(r1);
        }
        return numCuenta;
    }
}

