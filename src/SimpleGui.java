import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui implements ActionListener {
    JFrame frame;
    JButton button ;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }
    public void go(){
        frame = new JFrame();
        button = new JButton("click meee");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event){
        button.setText("I've been clicked");
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        //g.getColor(Color.orange);
        //g.fillRect(20,50,100,100);
        Graphics2D g2d = (Graphics2D) g;
        int red =(int) (Math.random() * 255);
        int green= (int) (Math.random() * 255);
        int blue = (int) (Math.random() *255);
        Color startColor = new Color(red, green, blue);
        red =(int) (Math.random() * 255);
        green=(int) (Math.random() * 255);
        blue=(int) (Math.random() * 255);
        Color endColor = new Color (red, green, blue) ;
        GradientPaint gradient = new GradientPaint(70,70,startColor, 150,150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70,70,100,100) ;
    }
}