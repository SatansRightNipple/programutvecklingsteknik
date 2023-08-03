package lab1.Extra;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame implements ActionListener{

    private MyButton[] knappar;
    private int antal;

    MyFrame (String[] u) {

        antal = Integer.parseInt(u[0]);
        int idx = 1;

        knappar = new MyButton[antal];

        for(int i = 0; i<antal ; i++) {
            knappar[i] = new MyButton(u[idx], u[idx+1], Color.BLACK, Color.WHITE);
            idx = idx + 2;
        }

        setVisible (true );
        setSize (300 ,300);
        setBackground(Color.pink);

        setLayout(new FlowLayout());

        for(int i = 0; i < antal; i++) {
            add(knappar[i]);
            knappar[i].addActionListener(this);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public static void main (String[] u) {

        MyFrame frame = new MyFrame(u);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for(int i = 0; i < antal; i++) {
            if (source != knappar[i]) {
                knappar[i].toggleState();
            }
        }
    }
}

// how to run (from prutten folder):
// javac lab1/Extra/MyButton.java lab1/Extra/MyFrame.java
// java lab1.Extra.MyFrame 4 on off hi bye sib ouz run walk
