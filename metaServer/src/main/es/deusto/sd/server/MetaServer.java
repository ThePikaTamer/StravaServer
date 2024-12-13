package com.example.metaauth.server;

import com.example.metaauth.storage.UserStorage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MetaServer {
    public static void main(String[] args) {
        final int PORT = 8081;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Meta Server running on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String request = in.readLine();
                    String[] parts = request.split(";");
                    String command = parts[0];
                    String email = parts[1];
                    String response = "INVALID";

                    switch (command) {
                        case "isRegistered":
                            response = UserStorage.isEmailRegistered(email) ? "TRUE" : "FALSE";
                            break;

                        case "validate":
                            String password = parts[2];
                            response = UserStorage.validateCredentials(email, password) ? "TRUE" : "FALSE";
                            break;

                        default:
                            response = "UNKNOWN_COMMAND";
                            break;
                    }

                    out.println(response);
                } catch (Exception e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
