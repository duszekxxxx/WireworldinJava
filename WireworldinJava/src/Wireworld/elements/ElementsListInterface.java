package Wireworld.elements;

import java.util.Iterator;

/**
 * Interfejs definujący liste elementów gry(bramke OR,bramke XOR itp.).
 */
public interface ElementsListInterface {

    /**
     * Metoda pozwalająca na dodanie elemntu do listy
     *
     * @param element element który ma byc dodany
     */
    public void addElement(Element element);

    /**
     * Metoda pozwala na usunięcie elementu z listy według podanej wartości
     * umiejscowienia na liście
     *
     * @param number numer elementu
     */
    public void deleteElement(int number);

    /**
     * MEtoda pozwalająca na dostanie się do określnego elementu lsity według
     * numeru na tej liście
     *
     * @param i numer elementu
     * @return zwraca element listy
     */

    public Element getElementByNumber(int i);

    /**
     * Metoda ta pozwala na łatwe iterowanie po liście zwracając iterator do tej
     * listy
     *
     * @return zwraca iterator listy
     */
    public Iterator getIterator();

}
