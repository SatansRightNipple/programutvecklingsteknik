package lab2;

public class TicTacToe implements Boardgame{
    
    private String[][] board = new String[3][3];
    private boolean flyttfas = false;
    private int player = 1;
    private String playerName = "";
    private String move = "";
    private boolean chooseEmptySlot = false;
    private int prevCol = 0;
    private int prevRow = 0;

    TicTacToe() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                board[i][j] = " ";
            }
        }
    }

    public boolean move(int col, int row) {

        if (player%2 == 0) {
            playerName = "2";
        } else {
            playerName = "1";
        } 

        try {
            String _test = board[col][row];
        } catch (ArrayIndexOutOfBoundsException e) {
            move = "please choose a square within the board!";
            return false;
        }

        if (player>6) {
            flyttfas = true;
        }

        if (!flyttfas) {
            return placeringMove(col,row);
        } else {
            return flyttfasMove(col,row);
        }
    }

    private boolean flyttfasMove(int col, int row) {
        if (!chooseEmptySlot) {
            if (player%2 == 1 && board[col][row] == "1" || player%2 == 0 && board[col][row] == "2") {
                move = "OK, now choose an empty square you want to move your piece.";
                chooseEmptySlot = true;
                prevCol = col;
                prevRow = row;
                return true;
            } else {
                move = "Please choose one of your pieces!";
                return false;
            }
        } else {

            Boolean legal = legalMove(col,row);

            if (legal) {
                board[col][row] = playerName;
                board[prevCol][prevRow] = " ";
                player++;
                move = "OK";
                chooseEmptySlot = false;
                return true;
            } else {
                move = "Please choose a square next to your piece you're going to move";
                return false;
            }

        }
    }

    private Boolean legalMove(int col, int row) {

        if (prevCol == 1 && prevRow == 1 && board[col][row] == " ") { //om pjäsen var i mitten och flyttas ut
            return true;
        } else if (Math.abs(prevCol-col) == 1 && row == prevRow || Math.abs(prevRow-row) == 1 && col == prevCol) { //om pjäsen var på sidorna eller hörnen och flyttas horizontelt eller vertikalt
            return true;
        } else if (prevCol == 0 && prevRow == 0 || prevCol == 0 && prevRow == 2 || prevCol == 2 && prevRow == 0 || prevCol == 2 && prevRow == 2) { //om pjäsen var på hörnen och flyttas till mitten
            if (col == 1 && row == 1 && board[row][col] == " ") {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean placeringMove(int col, int row) {
        if (board[col][row] == " ") {
            if (player%2 == 0) {
                board[col][row] = "2";
            } else {
                board[col][row] = "1";
            }
            player++;
            move = "OK";
            return true;
        } else {
            move = "Please choose a square that is empty!";
            return false;
        }
    }

    public String getStatus(int col, int row) {
        return board[col][row];
    }

    @Override
    public String getMessage() {
        if (move == "OK") {
            if (player%2 == 0) {
                move = "OK, now it's player 2's turn.";
            } else {
                move = "OK, now it's player 1's turn.";
            }
        }
        return move;
    }

}
