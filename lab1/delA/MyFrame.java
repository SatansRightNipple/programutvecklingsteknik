package lab1.delA;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame implements ActionListener{

    MyButton b1;
    MyButton b2;

    MyFrame (MyButton b1, MyButton b2) {
        setVisible (true );
        setSize (300 ,300);
        setBackground(Color.black);
        this.b1 = b1;
        this.b2 = b2;

        setLayout(new FlowLayout());

        add(b1);
        b1.addActionListener(this);
        add(b2);
        b2.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == b1) {
            b1.toggleState();
        } else if (source == b2) {
            b2.toggleState();
        }
    }

    public static void main (String[] u) {
        MyButton b1 = new MyButton("hej", "hejdå", Color.RED, Color.BLUE);
        MyButton b2 = new MyButton("Tryck inte", "Tryck nu", Color.ORANGE, Color.PINK);
        MyFrame frame = new MyFrame(b1, b2);

    }
}
