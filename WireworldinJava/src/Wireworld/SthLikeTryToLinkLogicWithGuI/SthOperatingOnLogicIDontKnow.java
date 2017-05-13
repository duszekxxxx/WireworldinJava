/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.SthLikeTryToLinkLogicWithGuI;

import Wireworld.Logic.Board;
import Wireworld.Logic.BoardGame;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.GameLogic;
import Wireworld.Logic.Logic;
import com.sun.swing.internal.plaf.basic.resources.basic;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class SthOperatingOnLogicIDontKnow {

    private GameLogic logic = new Logic();
    private BoardGame[] boardArray;

    public void generate(BoardGame board, int n) { // w oddzielnym wątku
        Thread generating = new Thread() {
            @Override
            public void run() {
                boardArray = new BoardGame[n + 1];
                boardArray[0] = board;
                for (int i = 0; i < (n); i++) {
                    boardArray[i+1] = logic.makeGame(boardArray[i]);
                    testShow(boardArray, i);
                }
            }
        };
        generating.start();
    }

    public BoardGame getGeneration(int i, JLabel label) {
        int j = 0;
        while (boardArray[i] == null) {
            if (i == 0) {
                label.setText("Czekaj  ");
            }
            for (int k = j; k < 5; k++) {
                label.setText(label.getText() + ".");
            }
            j++;
        }
        return boardArray[i];
    }

    private void testShow(BoardGame[] boardArray, int i) {
        System.out.println("Generacja: " + i);
        int hight = boardArray[i].getVerticalSize();
        int width = boardArray[i].getHorizontalSize();
        for (int j = 0; j < hight; j++) {
            for(int k =0; k < width; k++){
                //System.out.println(boardArray[i].getPointOnBoard(j, k)+"");
            }
            System.out.println("\n");
        }
    }
}
