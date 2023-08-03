package lab2;
import java.util.Random;

public class MockSpel implements Boardgame{

    private int[][] board = new int[10][10];
    private String move;

    MockSpel () {
        for(int i = 0; i<10 ; i++) {
            for (int j = 0; j<10 ; j++) {
                board[i][j] = 0;
            }
        }
    }

    public boolean move(int col, int row) {
        Random random = new Random();
        int num = random.nextInt(100);
        board[col][row] = num;
        move = Integer.toString(num);
        return true;
    }

    public String getStatus(int col, int row) {
        return Integer.toString(board[col][row]);
    }

    @Override
    public String getMessage() {
        return "Congratualtions, your new number is " + move;
    }
    
}
