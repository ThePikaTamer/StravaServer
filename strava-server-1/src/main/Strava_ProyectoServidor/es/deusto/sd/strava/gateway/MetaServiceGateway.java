package es.deusto.sd.strava.gateway;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

@Component
public class MetaServiceGateway {

    private final String metaServiceHost = "localhost";
    private final int metaServicePort = 8081;

    public boolean isEmailRegistered(String email) {
        return sendCommand("isRegistered;" + email).equals("TRUE");
    }

    public boolean validateCredentials(String email, String password) {
        return sendCommand("validate;" + email + ";" + password).equals("TRUE");
    }

    private String sendCommand(String command) {
        try (Socket socket = new Socket(metaServiceHost, metaServicePort);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(command);
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}
