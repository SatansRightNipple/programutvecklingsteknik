package lab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int size;
    private Square[][] board;        // Square är subklass till JButton
    private JTextField mess = new JTextField();  // JLabel funkar också

    ViewControl (Boardgame gm, int n){  // OK med fler parametrar om ni vill!
        game = gm;
        size = n;

        setVisible (true );
        setSize (450 ,450);
        setBackground(Color.pink);
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel(new GridLayout(size, size));

        board = new Square[size][size];

        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                Square slot = new Square(i,j);
                slot.addActionListener(this);
                slot.setText(game.getStatus(i,j));
                board[i][j] = slot;
                buttonsPanel.add(slot);
            }
        }

        add(buttonsPanel, BorderLayout.CENTER);
        add(mess, BorderLayout.PAGE_END);
    }

    public void actionPerformed(ActionEvent e) {
        Square button = (Square) e.getSource();

        int col = button.getCol();
        int row = button.getRow();

        boolean move = game.move(col,row);

        if (move) {
            updateSlots();
        }
        mess.setText(game.getMessage());
    }

    public void updateSlots() {
        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                board[i][j].setText(game.getStatus(i,j));
            }
        }
    }

    public static void main(String[] args) {
        int size1 = 10;
        Boardgame game1 = new MockSpel();
        ViewControl window1 = new ViewControl(game1, size1);

        int size2 = 4;
        Boardgame game2 = new FifteenModel();
        ViewControl window2 = new ViewControl(game2, size2);

        int size3 = 3;
        Boardgame game3 = new TicTacToe();
        ViewControl window3 = new ViewControl(game3, size3);

        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window1.setVisible(true);
        window2.setVisible(true);
        window3.setVisible(true);
    }
}
