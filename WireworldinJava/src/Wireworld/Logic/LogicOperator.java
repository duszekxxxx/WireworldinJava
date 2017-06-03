package Wireworld.Logic;

/**
 * Klasa odpowiedzalna za komunikacę grafiki z logiką
 */
public class LogicOperator {

    private final GameLogic logic = new Logic();
    private BoardGame[] boardArray;

    /**
     * Metoda tworzy tablicę n-kolejnych generacji
     *
     * @param board plansza na podatwie której generowane są kolejne generacje
     * @param n liczba generacji,które mają zostać wygenerowane
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
     * Metoda pozwala na pobranie okreśłonej generacji z wcześniej wygenerowanej
     * tablicy
     *
     * @param i numer generacji
     * @return zwraca plansze z generacją
     */
    public BoardGame getGeneration(int i) {
        if (i < boardArray.length && i >= 0) {
            return boardArray[i];
        } else {
            throw new IllegalArgumentException("LogicOperator.getGeneration: "
                    + "wrong generation number");
        }

    }
}
