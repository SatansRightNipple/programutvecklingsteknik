package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FifteenModel implements Boardgame{

    int[][] board = new int[4][4];
    String move = "";

    FifteenModel () {
        createBoard();
    }

    private void createBoard() {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i <= 15; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        int idx = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = numbers.get(idx);
                idx++;
            }
        }

    }

    public boolean move(int col, int row) {

        int[] surround = {1,-1};

        try {
            int _test = board[col][row];
        } catch (ArrayIndexOutOfBoundsException e) {
            move = "Please choose a position within the board!";
            return false;
        }

        for(int i = 0; i<2; i++) {
            try {
                if (board[col+surround[i]][row] == 0) {
                    board[col+surround[i]][row] = board[col][row];
                    board[col][row] = 0;
                    move = "OK";
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }

        for(int i = 0; i<2; i++) {
            try {
                if (board[col][row+surround[i]] == 0) {
                    move = "OK";
                    board[col][row+surround[i]] = board[col][row];
                    board[col][row] = 0;
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
        }
        move = "Please choose a position next to the empty one!";
        return false;
    }

    public String getStatus(int col, int row) {
        int num = board[col][row];
        if(num == 0) {
            return "  ";
        } else if (num<10){
            return " " + String.valueOf(num);
        } else {
            return String.valueOf(num);
        }
    }

    public String getMessage() {
        return move;
    }
}
