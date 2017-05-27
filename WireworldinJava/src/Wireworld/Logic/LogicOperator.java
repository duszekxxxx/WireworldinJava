/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.Logic;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.GameLogic;
import Wireworld.Logic.Logic;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class LogicOperator {

    private GameLogic logic = new Logic();
    private BoardGame[] boardArray;

    public void generate(BoardGame board, int n) {
        Thread generating;
        generating = new Thread() {
            @Override
            public void run() {
                boardArray = new BoardGame[n + 1];
                boardArray[0] = board;
                for (int i = 0; i < (n); i++) {
                    boardArray[i + 1] = logic.makeGame(boardArray[i]);
                }
            }
        };
        generating.start();
    }

    public BoardGame getGeneration(int i, JLabel label) {
        return boardArray[i];
    }
}
