package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Esta clase sirve para poder leer desde un archivo csv y guardar su contenido en 
 * una lista ligada
 * @author EquipoI
 */
public class LeeryGuardar {
    public ArrayList<String> lyg(String name){
        ArrayList<String> listaRetorno = new ArrayList<>();
        String data = "";
        int cont = 0;
        try{
            BufferedReader br;
            FileReader fr = new FileReader(name);
            br = new BufferedReader(fr);
            data = br.readLine();
            br.close();
        }catch(IOException ioe){
            System.out.println("Imposible leer");
        }
        StringTokenizer tokenizer = new StringTokenizer(data, ",");
        while(tokenizer.hasMoreTokens()){
            listaRetorno.add(cont, tokenizer.nextToken());
            cont++;
        }
        return listaRetorno;
    }
}
