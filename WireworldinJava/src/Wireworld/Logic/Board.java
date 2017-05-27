package Wireworld.Logic;

import java.util.ArrayList;

public class Board implements BoardGame {

    private final States[][] board;
    int verticalSize;
    int horizontalSize;

    public Board() {
        this(100, 100);
    }

    public Board(int horizontalSize, int verticalSize) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.board = new States[horizontalSize][verticalSize];
    }

    @Override
    public States getPointOnBoard(int x, int y) {
        if (x < 0 || x >= this.horizontalSize || y < 0 || y >= this.verticalSize) {
            return null;
        }
        return board[x][y];
    }

    @Override
    public void setPointOnBoard(States value, int x, int y) {
        if (x >= 0 && x < this.horizontalSize && y >= 0 && y < this.verticalSize) {
            this.board[x][y] = value;
        } else {
            throw new IllegalArgumentException("Value of x and y must be from 0 to veticalSize( or horizontalSize) - 1");
        }
    }

    @Override
    public int getVerticalSize() {
        return verticalSize;
    }

    @Override
    public int getHorizontalSize() {
        return horizontalSize;
    }
}
