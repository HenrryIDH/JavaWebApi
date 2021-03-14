package ar.com.eduit.curso.java.socket;
        
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;

/**
 * * Servidor TCP/IP
 */
public class Server {

    public static void main(String... args) {
        System.out.println("Iniciando Servidor...");
        String mensaje = "<h1>Servidor de Henrry!</h1>";
        mensaje = "HTTP/1.1 200 OK\n" + "Content-Length: " + mensaje.length() + "\n\n" + mensaje;
        try ( ServerSocket ss = new ServerSocket(8080);) {
            while (true) {
                System.out.println("Esperando conexion de cliente");
                try ( Socket so = ss.accept();  OutputStream out = so.getOutputStream();) {
                    System.out.println("Se conecto: " + so.getInetAddress());
                    out.write(mensaje.getBytes());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
