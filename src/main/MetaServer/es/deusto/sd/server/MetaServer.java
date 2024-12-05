
public class MetaServer 
{
    private final int port;

    public MetaServer(int port) 
    {
        this.port = port;
    }

    public void start() 
    {
        try (ServerSocket serverSocket = new ServerSocket(port)) 
        {
            System.out.println("Meta Server listening on port " + port);
            while (true) 
            {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
