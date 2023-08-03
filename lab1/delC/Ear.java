package lab1.delC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ear implements ActionListener{

    private MyButton b;
    
    Ear(MyButton b) {
        this.b = b;
        b.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        b.toggleState();
    }
}
