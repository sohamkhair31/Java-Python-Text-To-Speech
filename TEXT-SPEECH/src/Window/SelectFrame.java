package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectFrame extends JFrame {
    JLabel Ver = new JLabel("1.0");
    private JPanel mainPanel = new JPanel();
    public TTSWindow ttsWindow;
    public STTWindow sttWindow;
    private JButton Button$1 = new JButton("TEXT TO SPEECH ");
    private JButton Button$2 = new JButton("SPEECH TO TEXT ");
    public SelectFrame()
    {
        setUndecorated(true);
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel.setSize(300,200);
        mainPanel.setLocation(0,0);
        mainPanel.setLayout(null);
        addCloseButton(mainPanel);
        addSelectors(mainPanel);
        addVersion(mainPanel );
        add(mainPanel);
        setVisible(true);
        SwingUtilities.invokeLater(this::addActionListeners);
    }
    private void addCloseButton(JPanel panel)
    {
        JLabel Exit =new JLabel("X");
        Exit.setSize(50,50);
        Exit.setFont(new Font("Calibri",Font.BOLD,30));
        Exit.setLocation(270,0);
        Exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
        panel.add(Exit);
    }
    private void addSelectors(JPanel panel)
    {
        Button$1.setSize(200,30);
        Button$1.setLocation(50,50);
        Button$1.setFocusable(false);
        Button$1.setBackground(new Color(255,255,255));
        Button$1.setForeground(Color.DARK_GRAY);
        Button$2.setSize(200,30);
        Button$2.setLocation(50,100);
        Button$2.setFocusable(false);
        Button$2.setBackground(new Color(255,255,255));
        Button$2.setForeground(Color.DARK_GRAY);
        panel.add(Button$1);
        panel.add(Button$2);
    }
    private void addVersion(JPanel panel)
    {
        Ver.setSize(20,20);
        Ver.setFont(new Font("ARIAL",Font.BOLD,10));
        Ver.setLocation(280,180);
        panel.add(Ver);
    }
    private void addActionListeners()
    {
        Button$1.addActionListener(e->{
            ttsWindow = new TTSWindow();
            dispose();
        });
        Button$2.addActionListener(e->{
            sttWindow = new STTWindow();
            dispose();

        });
    }

}
