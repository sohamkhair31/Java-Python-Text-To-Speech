package Server;
import org.python.util.PythonInterpreter;

import java.io.IOException;

public class RunScript {
    public static void RunPyScript()
    {
        try{
            String path = "C:\\Users\\Soham Khair\\IdeaProjects\\KOTLIN\\TEXT-SPEECh\\src\\Scripts\\ScriptTTS.py";
            ProcessBuilder Builder= new ProcessBuilder("python",path,"Running...");
            Builder.start();
         } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
