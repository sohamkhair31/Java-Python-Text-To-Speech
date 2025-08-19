package Server;
import Data.DataCollection;
import Window.TTSWindow;
import py4j.GatewayServer;

import Data.DataCollection;
public class Connect {
    public GatewayServer Server;
     private void est()
    {
        Connect con = new Connect();
        Server = new GatewayServer(con);
        System.out.println("SERVER STARTED");
    }
    public String getSTR()
    {
        DataCollection collection = new DataCollection();
        System.out.println("FROM getSTR(Connnect)\n"+DataCollection.getStringDataTTS());
        return collection.getStringDataTTS();
    }
    public static void main(String[] args) {
        Connect cn = new Connect();
        cn.est();
        cn.Server.start();

    }
}
