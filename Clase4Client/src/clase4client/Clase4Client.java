package clase4client;

import ar.com.eduit.curso.java.web.entities.Articulo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;
/**
 *
 * @author HenrryG
 */
public class Clase4Client {

     public static void main(String[] args) throws Exception{


        //Cliente HTTP 
        String url = "";
        // url = "http://localhost:8083/Clase4/ArticuloAlta?id=6&descripcion=Bluetooth&precio=5000";
        //url = "http://localhost:8083/Clase4/ArticuloAll";
        //url = "http://servicios.usig.buenosaires.gob.ar/normalizar?direccion=Medrano%20162";
        //url="https://ws.smn.gob.ar/map_items/weather";

       /*
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("---Headers---");
        response.headers().map().forEach((K, V) -> System.out.println(K + "  -  " + V));
        System.out.println(response.body());
        */
       
      System.out.println("****************************************************");
        System.out.println("- Servicio Metereologico");
        System.out.println(getBody("https://ws.smn.gob.ar/map_items/weather"));
        System.out.println("****************************************************");
        System.out.println("- Normalizador de direcciones");
        System.out.println(getBody("http://servicios.usig.buenosaires.gob.ar/normalizar?direccion=Medrano%20162"));
        System.out.println("****************************************************");
        System.out.println("- Alta Articulo");
        System.out.println(getBody("http://localhost:8083/Clase4/ArticuloAlta?id=15&descripcion=Monitos&precio=5000"));
        System.out.println("****************************************************");
        System.out.println("- Articulo All");
        System.out.println(getBody("http://localhost:8083/Clase4/ArticuloAll"));
        System.out.println("****************************************************");
        System.out.println("- Articulo LikeDescripcion");
        System.out.println(getBody("http://localhost:8083/Clase4/ArticuloLikeDescripcion?descripcion=pa"));
        
        System.out.println("****************************************************");
        System.out.println("- Articulo All");
        Type ListType=new TypeToken<List<Articulo>>(){}.getType();
        List<Articulo> list=new Gson().fromJson(getBody("http://localhost:8083/Clase4/ArticuloAll"), ListType);
        list.forEach(System.out::println);
        
        System.out.println("****************************************************");
        System.out.println("- Articulo All");
        list=new Gson().fromJson(getBody("http://localhost:8083/Clase4/ArticuloLikeDescripcion?descripcion=la"), ListType);
        list.forEach(System.out::println);
       

    }

    public static String getBody(String url) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    
}

