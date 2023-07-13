/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author SALA H
 */
public class LeerDatos {
    
    public static ArrayList<String> leer(){
        
        ArrayList<String> lista = new ArrayList();

        try ( BufferedReader  lector = new BufferedReader(new FileReader("datos\\usuarios.txt"))) {

            String mensaje;
            while ((mensaje = lector.readLine()) != null) {
                lista.add(mensaje);
            }
                
            lector.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    
        return lista;
    }
}
