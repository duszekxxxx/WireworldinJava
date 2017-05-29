
package Wireworld.Logic;

/**Interfejs stworzenie logiki gry*/
public interface GameLogic {
    /**Metoda rozgrywa grę poprzez sprawdzenie poszczególnych stanów i ich zmianę
     * @param board plansza na której rozgrywa się gra
     * @return zwraca plansze po przetworzeniu przez logikę gry
     */
    public BoardGame makeGame(BoardGame board);
}
