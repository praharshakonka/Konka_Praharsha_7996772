package TCPClientServerChat;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server!");

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
                new InputStreamReader(System.in));

        String msg;

        while (true) {

            System.out.print("Client: ");
            msg = keyboard.readLine();

            output.println(msg);

            if (msg.equalsIgnoreCase("exit")) {
                break;
            }
        }

        socket.close();
    }
}