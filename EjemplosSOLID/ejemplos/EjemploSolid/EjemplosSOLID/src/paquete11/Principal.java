/*
 * 
 * D - Dependency inversion principle (Principio de inversión de dependencias)
 */
package paquete11;

import java.util.ArrayList;
import static paquete11.LeerDatos.leer;

public class Principal {

    public static void main(String[] args) {

        /*
        Usar el txt llamado usuarios.txt; por cada línea del archivo
        crer un API en función de su servicio; además el API ahora genera
        información estática (no cambia el API), se debe buscar la forma que el 
        API sea dinámico totalmente (usar alguna librería propia de JAVA, tipo 
        Random); la url final debe contener el tipo de servicio y el user
        Por cada objeto de tipo GeneradoPelicula presentar la información 
        a través de un toString
         */
        ArrayList<String> lista = leer();
        ArrayList<GeneradorPelicula> generadores = new ArrayList();
        
        for (int i = 0; i < lista.size(); i++) {
            
            String[] partes = lista.get(i).split(";");
            
            
            String usuario = partes[1];
            String tipo = partes[2];
            
            String ak = usuario + tipo;

            GeneradorPelicula gp = new GeneradorPelicula();
            gp.establecerUser(usuario);

            if ("Netflix".equals(partes[2])) {

                APINetflix api = new APINetflix();
                api.establecerApiKey(ak);
                gp.establecerLlave(api);

            } else if ("Disney".equals(partes[2])) {

                APIDisney api = new APIDisney();
                api.establecerApiKey(ak);
                gp.establecerLlave(api);

            } else if ("Amazon".equals(partes[2])) {

                APIAmazonMovie api = new APIAmazonMovie();
                api.establecerApiKey(ak);
                gp.establecerLlave(api);

            } else if ("Startplus".equals(partes[2])) {

                APIStarplus api = new APIStarplus();
                api.establecerApiKey(ak);
                gp.establecerLlave(api);

            }

            gp.establecerUrl("http://api.movie?api=");

            generadores.add(gp);

        }

        for (GeneradorPelicula generador : generadores) {

            System.out.printf("%s\n", generador);

        }

    }
}
