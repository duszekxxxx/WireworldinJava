package Wireworld.Logic;

/**
 Klasa która stanowi jeden ze stanów zwany Conductorem
 */
public class Conductor implements States {

    private int elementNumber;

    public Conductor(int elementNumber) {
        this.elementNumber = elementNumber;
    }

    public Conductor() {
        //required empty conductor (for Logic)
    }

    @Override
    public int getElementNumber() {
        return elementNumber;
    }
}
