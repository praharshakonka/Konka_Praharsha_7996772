package TCPClientServerChat;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started... waiting for client");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String msg;

        while ((msg = input.readLine()) != null) {

            System.out.println("Server received: " + msg);

            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
        }

        socket.close();
        serverSocket.close();
    }
}