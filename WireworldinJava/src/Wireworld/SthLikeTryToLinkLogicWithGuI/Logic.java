
package SthLikeTryToLinkLogicWithGuI;

import Wireworld.Logic.*;


public class Logic implements GameLogic{
    
    @Override
    public BoardGame makeGame(BoardGame board){
        Board changedBoard = new Board(board.getHorizontalSize(),board.getVerticalSize());
        for(int x=0; x<board.getVerticalSize(); x++){
            for(int y=0; y < board.getVerticalSize(); y++){
                changedBoard.setPointOnBoard(changeState(board.getPointOnBoard(x, y)), x, y);
            } 
        }
        
        
        return board;
    }
    
    private States changeState(States state){
        if(state instanceof ElectronHead){
            return new ElectronTail();
        }
        else if(state instanceof ElectronTail){
            return new Conductor();
        }
         else if(state instanceof EmptyCell){
            return state;
        }
         else if(state instanceof Conductor){
            
        }
        return new ElectronHead();
    }
    
}
