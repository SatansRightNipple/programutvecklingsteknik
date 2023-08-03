package lab2;

public interface Boardgame {
    boolean move(int col, int row);
    String getStatus(int col, int row);
    String getMessage();
}
