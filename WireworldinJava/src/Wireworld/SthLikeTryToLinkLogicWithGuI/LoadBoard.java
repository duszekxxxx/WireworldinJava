/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SthLikeTryToLinkLogicWithGuI;

import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;
import java.io.File;

/**
 *
 * @author Orion
 */
public class LoadBoard {
    public static Board LoadBoardFromFile(File file){
        Board myBoardToTest = new Board(100,100);
        for(int i = 0;i < 100;i++){
            for(int j =0 ; j < 100; j++ ){
                myBoardToTest.setPointOnBoard(new EmptyCell(), i, j);
            }
        }
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 0);
        myBoardToTest.setPointOnBoard(new ElectronHead(), 5, 1);
        myBoardToTest.setPointOnBoard(new ElectronTail(), 5, 2);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 3);
        return myBoardToTest;
    }
}
