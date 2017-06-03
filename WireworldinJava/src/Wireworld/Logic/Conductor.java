package Wireworld.Logic;

/**
 * Klasa która stanowi jeden ze stanów zwany Conductorem
 */
public class Conductor implements States {

    private int elementNumber;

    /**
     * Konstruktor ustawiający numer elementu
     *
     * @param elementNumber numer elementu do któego należy konstruktor
     */
    public Conductor(int elementNumber) {
        this.elementNumber = elementNumber;
    }

    /**
     * Pusty konstruktor (wymagany)
     */
    public Conductor() {
        //required empty conductor (for Logic)
    }

    @Override
    public int getElementNumber() {
        return elementNumber;
    }
}
