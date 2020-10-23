package Task1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TextFieldTest extends JFrame
{
    private JTextField input=new JTextField("",2);
    private JButton btn=new JButton("Проверить");
    public int solution;
    public int k=0;
    public TextFieldTest() {
        super("Угадай число");
        this.setBounds(150, 150, 300, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,3,2,2));
        Random random =new Random();
        solution=random.nextInt(21);
        btn.addActionListener(new EventListener());
        container.add(input);
        container.add(btn);
    }
    class EventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";

            String value = input.getText();
            int v = Integer.parseInt(value);


            if (v != solution && k<2) {
                if (v > solution)
                    message+="Your number is greater";

                else
                    message+="Your number is lower";
                JOptionPane.showMessageDialog(null,message);
                k++;
                input.setText("");

            } else {
                if (v==solution)
                    message+="Congrats! You got it right!";

                else
                    message+="Sorry, you lost";
                JOptionPane.showMessageDialog(null,message);
                remove(input);
                remove(btn);
            }
        }
    }
    public static void main(String[] args) {
        TextFieldTest app= new TextFieldTest();
        app.setVisible(true);
    }
}

