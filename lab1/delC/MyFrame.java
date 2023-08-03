package lab1.delC;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame{

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
        add(b2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }



    public static void main (String[] u) {
        MyButton b1 = new MyButton("hej", "hejdå", Color.RED, Color.BLUE);
        MyButton b2 = new MyButton("Tryck inte", "Tryck nu", Color.ORANGE, Color.PINK);
        MyFrame frame = new MyFrame(b1, b2);

    }
}
