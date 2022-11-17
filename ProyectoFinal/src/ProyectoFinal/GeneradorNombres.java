package ProyectoFinal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class GeneradorNombres {
    public String nom = "";
    public String ape = "";
    List<String> nomList = new ArrayList<>();
    List<String> apeList = new ArrayList<>();

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
    public void generarMombres(){
        try {
            String nombresGen = "";
            for (int i = 0; i <= 500; i++) {
                Random numAl = new Random();
                boolean elec = numAl.nextBoolean();
                //Nombres de mujer [0, 50]
                if(elec){
                    int r1 = (int)(Math.random()*50);
                    int r2 = (int)(Math.random()*50);
                    int r3 = (int)(Math.random()*200);
                    nombresGen += nomList.get(r1) + " "+ nomList.get(r2)+" "+ apeList.get(r3)+ " " + apeList.get(r1) + ",";
                }
                //Para nombres de hombre (51, 100)
                else{
                    int r1 = (int)(Math.random()*(100-51)+50);
                    int r2 = (int)(Math.random()*(100-51)+50);  
                    int r3 = (int)(Math.random()*200);
                    nombresGen += nomList.get(r1) + " "+ nomList.get(r2)+" "+ apeList.get(r3)+ " " + apeList.get(r1) + ",";
                }
            }
            System.out.println("Nombres generados");
            FileWriter fw = new FileWriter("NombresGenerados.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter sd = new PrintWriter(bw);
            sd.print(nombresGen);
            sd.close();
        }catch (IOException ex) {
            System.out.println("No fue posible abrir el archivo");
        }
    }

}

            /*
            Random numAl = new Random();
            boolean elec = numAl.nextBoolean();
            if(elec){
            int r1 = (int)(Math.random()*50);
            int r2 = (int)(Math.random()*50);
            int r3 = (int)(Math.random()*228);
            alu.setNombre(nomList.get(r1) + " "+ nomList.get(r2)+" "+ apeList.get(r3)+ " " + apeList.get(r1));
            }
            //Para nombres de hombre (51, 100)
            else{
            int r1 = (int)(Math.random()*(100-51)+50);
            int r2 = (int)(Math.random()*(100-51)+50);  
            int r3 = (int)(Math.random()*228);
            alu.setNombre(nomList.get(r1) + " "+ nomList.get(r2)+" "+ apeList.get(r3)+ " " + apeList.get(r1));
            }
             */
