
package Wireworld.Logic;

public interface BoardGame {
    public States getPointOnBoard(int x ,int y);
    public void setEmptyCellsOnBoard();
    public void setPointOnBoard(States value,int x, int y);
    public int getVerticalSize();
    public int getHorizontalSize();
}
