package lab2;

import java.awt.Color;
import javax.swing.JButton;

public class Square extends JButton{

    private int col;
    private int row;

    Square(int i, int j) {
        col = i;
        row = j;
        setBackground(Color.pink);
        setOpaque(true);
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
