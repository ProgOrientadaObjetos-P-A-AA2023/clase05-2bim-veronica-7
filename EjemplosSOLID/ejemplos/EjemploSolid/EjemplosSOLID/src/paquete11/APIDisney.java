/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete11;

/**
 *
 * @author Usuario
 */
public class APIDisney implements APIMovie {
    
    private String apiKey;
    
    @Override
    public void establecerApiKey(String ak){
        int aleatorio = (int)(Math.random() * 100000);
        apiKey = ak+aleatorio;
    }
    
    @Override
    public String obtenerApiKey(){
        return apiKey;
    }
}
