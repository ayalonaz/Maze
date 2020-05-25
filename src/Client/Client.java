package Client;

import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private InetAddress ip;
    private int port;
    private IClientStrategy strategy;

    public Client(InetAddress SIP,int SPort,IClientStrategy CStrategy){
        this.ip=SIP;
        this.port=SPort;
        this.strategy=CStrategy;
    }

    public void communicateWithServer(){
        try {
            Socket server = new Socket(ip,port);
            strategy.clientStrategy(server.getInputStream(),server.getOutputStream());
            server.close();
        }
        catch (Exception exp){
            exp.printStackTrace();
        }

    }
}
