package Window;

import Data.DataCollection;
import Server.RunScript;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TTSWindow extends JFrame {
    private boolean isActive = false;
    private final JPanel mainPanel = new JPanel();
    private final TextArea textArea = new TextArea();
    private final JButton Narrate = new JButton("Narrate");
    private final JButton Clear = new JButton("Clear");
    public TTSWindow()
    {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setLayout(null);
        mainPanel.setSize(800,600);
        mainPanel.setLocation(0,0);
        mainPanel.setLayout(null);
        addTextArea(mainPanel);
        add(mainPanel);
        setVisible(true);
        isActive = true;
        SwingUtilities.invokeLater(()->{
            NarrotListener(Narrate,textArea);
        });
    }
    private void addTextArea(JPanel panel)
    {
        textArea.setSize(550,450);
        textArea.setLocation(50,50);
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(textArea);
        addButtons(panel);
    }
    private void addButtons(JPanel panel)
    {
        Narrate.setSize(120,25);
        Narrate.setLocation(620,50);
        Narrate.setFocusable(false);
        Narrate.setBackground(Color.WHITE);
        Clear.setSize(120,25);
        Clear.setLocation(620,100);
        Clear.setFocusable(false);
        Clear.setBackground(Color.WHITE);
        ClearListener(Clear,textArea);
        panel.add(Narrate);
        panel.add(Clear);
    }
    public static String getString(TextArea textArea){
        System.out.println("TAKING DATA");
        if(textArea.getText().isEmpty())
        {
            return "Please Check TEXT AREA";
        }
        else {
            return String.valueOf(textArea.getText());
        }
    }
    private void ClearListener(JButton button,TextArea Area)
    {
        button.addActionListener(e->{
            Area.setText("");
        });
    }
    private void NarrotListener(JButton button,TextArea Area)
    {
        DataCollection collection = new DataCollection();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                collection.setStringDataTTS(getString(Area));
                System.out.println("GATHERED : "+collection.getStringDataTTS());
                RunScript.RunPyScript();
            }
        });
    }

}
