package Wireworld.generator;

import Wireworld.Logic.BoardGame;
import Wireworld.elements.ElementsList;
import Wireworld.elements.ElementsListInterface;


/**
 *Singleton służący do przechowywania struktur gry: listy elementów i planszy
 */
public class WireWorldManager {

    private static WireWorldManager ourInstance = null;
    private BoardGame board;
    private ElementsListInterface elementsList;

    /**
     *Zwraca i tworzy nową instancje klasy
     * @return zwraca instancje klasy
     */
    public static synchronized WireWorldManager getInstance() {
        if (null == ourInstance) {
            ourInstance = new WireWorldManager();
        }
        return ourInstance;
    }

    private WireWorldManager() {
        elementsList = new ElementsList();
    }

    /**
     *Zwraca plansze gry przechowywaną w strukturze
     * @return zwraca plansze gry
     */
    public BoardGame getBoard() {
        return board;
    }
    /**
     * Zwraca liste lementów przechowywaną w strukturze
     * @return zwraca liste elementów
     */
    public ElementsListInterface getElementsList() {
        return elementsList;
    }
    /**
     *Przypisuje nową - wczytaną - liste elementów do struktury
     * @param elementsList przypisywana lista elementów 
     */
    public void setLoadedList(ElementsList elementsList){
        this.elementsList = elementsList;
    }
    /**
     *Ustawia plansze w strukturze
     * @param board plansza do załadownaia do struktury
     */
    public void setBoard(BoardGame board) {
        this.board = board;
    }

}
