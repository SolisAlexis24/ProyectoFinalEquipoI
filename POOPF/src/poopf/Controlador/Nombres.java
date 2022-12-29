/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poopf.Controlador;

import poopf.Vista.POOPF;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tripl
 */
public class Nombres {
    public String nombre(){
        Random rand = new Random();
        String nombre=null;
        int num=rand.nextInt(100), cont=0;

        try {
            FileReader fr = new FileReader("nombres.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    cont++;
                    String token = tokenizador.nextToken();
                    if(cont == num)
                        nombre=token;
                }
                linea = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cont =0;
            num=rand.nextInt(226);
            FileReader fr = new FileReader("apellidos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    cont++;
                    String token = tokenizador.nextToken();
                    if(cont == num)
                        nombre=nombre+" "+token;
                }
                linea = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cont =0;
            num=rand.nextInt(226);
            FileReader fr = new FileReader("apellidos.csv");
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea != null ){
                StringTokenizer tokenizador = new StringTokenizer(linea, ",");
                while(tokenizador.hasMoreTokens()){
                    cont++;
                    String token = tokenizador.nextToken();
                    if(cont == num)
                        nombre=nombre+" "+token;
                }
                linea = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POOPF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }
}
