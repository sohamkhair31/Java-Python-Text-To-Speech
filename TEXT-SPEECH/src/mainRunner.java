import Server.Connect;
import Window.SelectFrame;
import Window.TTSWindow;
import Window.STTWindow;
import py4j.GatewayServer;

public class mainRunner {
    public static  SelectFrame selectFrame;
    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.Server = new GatewayServer(connect);
        connect.Server.start();
        selectFrame = new SelectFrame();

    }
}
