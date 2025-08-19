package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class STTWindow extends JFrame {
    JPanel mainPanel = new JPanel();
    private final TextArea textArea = new TextArea();
    private final JButton Narrate = new JButton("Speak");
    private final JButton Clear = new JButton("Clear");
    private final JButton Copy = new JButton("Copy");
    public STTWindow()
    {
        setLayout(null);
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        mainPanel.setSize(800,600);
        mainPanel.setLayout(null);
        mainPanel.setLocation(0,0);
        add(mainPanel);
        addTextArea(mainPanel);
        setVisible(true);
        SwingUtilities.invokeLater(()->{
            SpeakListener(this.Narrate,textArea,Clear,Copy);
        });
    }
    private void addTextArea(JPanel panel)
    {
        textArea.setEditable(false);
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
        Copy.setSize(120,25);
        Copy.setLocation(620,150);
        Copy.setFocusable(false);
        Copy.setBackground(Color.WHITE);
        ClearListener(Clear,textArea);
        panel.add(Narrate);
        panel.add(Copy);
        panel.add(Clear);
    }
    private void ClearListener(JButton button,TextArea Area)
    {
        button.addActionListener(e->{
            Area.setText("");
        });
    }
    private void SpeakListener(JButton button,TextArea area,JButton clrBtn,JButton cpyBtn)
    {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                area.setEnabled(false);
                clrBtn.setEnabled(false);
                cpyBtn.setEnabled(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                area.setEnabled(true);
                clrBtn.setEnabled(true);
                cpyBtn.setEnabled(true);
            }
        });
    }
}
