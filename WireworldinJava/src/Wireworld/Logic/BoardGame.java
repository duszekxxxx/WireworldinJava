
package Wireworld.Logic;

/**Intefejs, który implementuje klasa odpowiedzialna za przechowywanie stanów obiektów.*/
public interface BoardGame {
     /**Metoda pozwala na dostęp do określonej komórki planszy
    @param x współrżedna horyzontalna
    @param y współrzędna wertykalna
    @return zwraca obiekt stanu, który implementuje interfejs States
    */
    public States getPointOnBoard(int x ,int y);
     /**Metoda pozwala na ustawienie wszystkich komórek planszy na komórki puste*/
    public void setEmptyCellsOnBoard();
      /**Metoda pozwala na zapisanie stanu do określonej komórki planszy
    @param x współrżedna horyzontalna
    @param y współrzędna wertykalna
    @param value konkretny stan
    */
    public void setPointOnBoard(States value,int x, int y);
    /**Metoda pozwala na uzyskania wielkości wertykalnej plansz
     * @return zwraca wielkość wertykalną planszy*/
    public int getVerticalSize();
    /**Metoda pozwala na uzyskania wielkości horyzontalnej plansz
     * @return zwraca wielkość horyzontalną planszy*/
    public int getHorizontalSize();
}
