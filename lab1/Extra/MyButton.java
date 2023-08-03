package lab1.Extra;
import java.awt.*;
import javax.swing.JButton;

public class MyButton extends JButton {

    private String[] text;
    private Color[] farg;
    private int idx = 0;

    MyButton (String t1, String t2, Color f1, Color f2) {
        text = new String[]{t1, t2};
        farg = new Color[]{f1, f2};

        setBackground(farg[idx]);
        setOpaque(true);
        setText(text[idx]);
    }

    public void toggleState() {
        idx++;
        setBackground(farg[idx%2]);
        setText(text[idx%2]);
    }
}