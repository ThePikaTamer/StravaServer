
public class ClientHandler implements Runnable 
{
    private final Socket clientSocket;
    private final UserInMemoryDAO userDAO = new UserInMemoryDAO();

    public ClientHandler(Socket clientSocket) 
    {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() 
    {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) 
        {

            String request = in.readLine();
            Map<String, String> response = handleRequest(request);
            out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> handleRequest(String request) 
    {
        // Parse JSON and handle logic based on the action (e.g., CHECK_EMAIL, VALIDATE_CREDENTIALS).
        // Use userDAO for data access.
        return Map.of("response", "handled");
    }
}
