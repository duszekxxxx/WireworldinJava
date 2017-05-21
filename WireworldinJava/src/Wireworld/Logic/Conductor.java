package Wireworld.Logic;

public class Conductor implements States {

    private int elementNumber;

    public Conductor(int elementNumber) {
        this.elementNumber = elementNumber;
    }

    public Conductor() {

    }

    @Override
    public int getElementNumber() {
        return elementNumber;
    }
}
