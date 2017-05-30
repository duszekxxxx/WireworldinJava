/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.Logic;

/**
 * Interfejs komunikacji grafiki z logiką
 */
public class LogicOperator {

    private GameLogic logic = new Logic();
    private BoardGame[] boardArray;

    /**
     * Metoda pozwala na tablicy n-kolejnych generacji
     *
     * @param board plansza od której zaczyna się generowanie
     * @param n ilość plansz do wygenerowania kolejnych generacji
     */
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

    /**
     * Metoda pozwala na dostanie sie do okreśłonej generacji
     *
     * @param i numer generacji
     * @return zwraca plansze z generacją
     */
    public BoardGame getGeneration(int i) {
        return boardArray[i];
    }
}
