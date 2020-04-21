import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JFrame window;
    JPanel panel;
    JLabel label;

    // set the default frame and panel
    public MyFrame() {
        window = new JFrame();
        window.setSize(600,200);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        label = new JLabel();
        panel.add(label);

        window.setContentPane(panel);
    }
}
