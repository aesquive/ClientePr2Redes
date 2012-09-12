package cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import util.RWSocket;

/**
 *
 * @author Alberto Emmanuel Esquivel Vega
 *
 * Clase cliente que habre un socket y entabla conexion con servidor.Server
 *
 */
public class Cliente {

    private Socket socket;
    private String nombre;
    private final String host = "localhost";
    private final int puerto = 9999;

    public Cliente(String nombre) {
        this.nombre = nombre;
        crearSocket();
        System.out.println("[Client]Socket cliente " + nombre + " iniciado...");
    }

    /**
     * metodo que se encarga de contruir el socket para la comunicacion
     */
    private void crearSocket() {
        try {
            socket = new Socket(host, puerto);
        } catch (UnknownHostException ex) {
            System.out.println("[Client]Host desconocido");
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("[Client]Error al abrir el socket cliente");
            System.exit(1);
        }
    }

    /**
     * metodo que se encarga de interactuar con el servidor , acaba cuando se presiona la letra q
     */
    public void empezarDinamica() {
        while (!socket.isClosed()) {
            String textoRecibido = RWSocket.leerCanal(socket);
            System.out.println(textoRecibido);
            String respuesta = leerConsola();
            RWSocket.enviarMensaje(socket, respuesta);
            if (respuesta.trim().equals("q")) {
               RWSocket.cerrarSocket(socket);
            }
             
        }
    }

    /**
     * lee una linea de consola
     * @return 
     */
    private String leerConsola() {
        Scanner scaner = new Scanner(System.in);
        String nextLine = scaner.nextLine();
        return nextLine;
    }

    public static void main(String[] args) {
        Cliente client = new Cliente("Cliente1");
        client.empezarDinamica();
    }
}
