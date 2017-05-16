/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.logicConector;

import Wireworld.Logic.Board;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;
import Wireworld.generator.WireWorldManager;
import java.io.File;
import java.util.Random;

/**
 *
 * @author Orion
 */
public class LoadBoard {
    //It's not ready yet
    //
    //
    //
    //

    public static void loadBoardFromFile(File file) {
        Board myBoardToTest = new Board(14, 14);
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                myBoardToTest.setPointOnBoard(new EmptyCell(), i, j);
            }
        }
        myBoardToTest.setPointOnBoard(new ElectronTail(), 5, 0);
        myBoardToTest.setPointOnBoard(new ElectronHead(), 5, 1);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 2);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 3);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 4);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 5);
        myBoardToTest.setPointOnBoard(new Conductor(), 4, 6);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 6);
        myBoardToTest.setPointOnBoard(new Conductor(), 6, 6);
        myBoardToTest.setPointOnBoard(new Conductor(), 4, 7);
        myBoardToTest.setPointOnBoard(new Conductor(), 6, 7);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 8);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 9);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 10);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 11);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 12);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 13);

        /*myBoardToTest.setPointOnBoard(new ElectronTail(), 5, 0);
        myBoardToTest.setPointOnBoard(new ElectronHead(), 5, 1);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 2);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 3);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 4);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 5);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 6);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 7);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 8);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 9);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 10);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 11);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 12);
        myBoardToTest.setPointOnBoard(new Conductor(), 5, 13);*/
 /*myBoardToTest.setPointOnBoard(new Conductor(), 5, 0);
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
        }*/
        WireWorldManager.getInstance().setBoard(myBoardToTest);
    }
}
