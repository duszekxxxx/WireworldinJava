
package Wireworld.Logic;


public class Board implements BoardGame{
    
    
    private final States [][] board;
    int verticalSize;
    int horizontalSize;
    
    public Board(){
       this(100,100);
    }

   
    
    public Board(int horizontalSize,int verticalSize){
        this.horizontalSize=horizontalSize;
        this.verticalSize = verticalSize; 
        this.board = new States[horizontalSize][verticalSize];
           
    }
    
     
    @Override
    public States getPointOnBoard(int x, int y)  {
        if(x>=this.horizontalSize && y>=this.verticalSize);
        return board[x][y];
    }

   @Override
    public void setPointOnBoard(States value,int x, int y) {
        this.board[x][y] = value;
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
