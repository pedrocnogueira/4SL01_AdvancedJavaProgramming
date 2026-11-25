package fr.tp.inf112.projects.robotsim.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloWorldClient {

    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {

        try(Socket socket = new Socket("localhost", PORT);) {
            final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("my message");


            final String msg = in.readLine();
            System.out.println("The server returned:");
            System.out.println(msg);
        }

    }


}
