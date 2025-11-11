
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CaesarFrame extends JFrame {

    private static Object[] createBox() {
        Object[] array = new Object[26]; 

        for (int i = 0; i < 26; i++) {
            array[i] = (char) ('A' + i); 
        }

        return array;
    }

    private JTextField input = new JTextField(20);
    private JTextField output = new JTextField(20);
    private JButton button = new JButton("Code!");
    private JComboBox box = new JComboBox(createBox());
    
    public CaesarFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initialize() {
        this.setTitle("SwingLab");
        this.setSize(400, 110);
        this.setResizable(false);
        output.setEditable(false);
        
        
        JPanel upperPanel = new JPanel();
        upperPanel.add(box);
        upperPanel.add(input);
        upperPanel.add(button);
        
        upperPanel.setOpaque(false);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Output:"));
        bottomPanel.add(output);
        bottomPanel.setOpaque(false);
        

        this.add(upperPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
        button.addActionListener(new OkButtonActtionListener());
        
        this.setVisible(true);

    }

    private class OkButtonActtionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Caesar c = new Caesar();
            String text = input.getText();
            char offset = (char) box.getSelectedItem();
            output.setText(c.caesarCode(text, offset));


        }

    }
    
}
