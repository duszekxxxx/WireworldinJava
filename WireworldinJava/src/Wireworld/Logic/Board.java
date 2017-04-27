
package Wireworld.Logic;


public class Board {
    
    
    private final States [][] board;
    int verticalSize;
    int horizontalSize;
    
    public Board(int horizontalSize,int verticalSize){
        this.board = new States[horizontalSize][verticalSize];
        this.horizontalSize=horizontalSize;
        this.verticalSize = verticalSize;    
    }

    
    public States getBoard(int x, int y)  {
        if(x>=this.horizontalSize && y>=this.verticalSize);
        return board[x][y];
    }

   
    public void setBoard(States value,int x, int y) {
        this.board[x][y] = value;
    }
}
