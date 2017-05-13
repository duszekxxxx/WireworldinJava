/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WireWorld.logicConector;

import Wireworld.Logic.Board;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;
import java.io.File;
import java.util.Random;

/**
 *
 * @author Orion
 */
public class LoadBoard {
    public static Board loadBoardFromFile(File file){
        Board myBoardToTest = new Board(10,30);
        for(int i = 0;i < 10; i++){
            for(int j =0 ; j < 30; j++ ){
                myBoardToTest.setPointOnBoard(new EmptyCell(), i, j);
            }
        }
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 0);
                for(int i=1; i < 30; i++){
            Random rand = new Random();
            int randInt = rand.nextInt(3);
            if(randInt == 0){
                myBoardToTest.setPointOnBoard(new ElectronHead(), 5, i);
            }else if (randInt == 1){
                myBoardToTest.setPointOnBoard(new ElectronTail(), 5, i);
            } else if(randInt == 2) {
                myBoardToTest.setPointOnBoard(new Conductor(), 5, i);
            }
                    
        }
        return myBoardToTest;
    }
}
