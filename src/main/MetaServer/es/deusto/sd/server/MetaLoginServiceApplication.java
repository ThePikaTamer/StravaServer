
public class MetaLoginServiceApplication 
{
    public static void main(String[] args) 
    {
        new MetaLoginServiceApplication().startServer();
    }

    public void startServer() 
    {
        MetaServer server = new MetaServer(9090);
        server.start();
    }
}
