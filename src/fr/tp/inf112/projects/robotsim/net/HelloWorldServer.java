package fr.tp.inf112.projects.robotsim.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {

    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept()) {

            final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // true = autoflush

            final String msg = in.readLine();
            out.println("I received " + msg + "!");
        }
    }
}
