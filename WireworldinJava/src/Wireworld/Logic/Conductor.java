package Wireworld.Logic;

public class Conductor implements States {

    private int elementNumber;
    private int partOfElementNumber;
    private String elementType;

    public Conductor(int elementNumber, int partOfElementNumber, String elementType) {
        this.elementNumber = elementNumber;
        this.partOfElementNumber = partOfElementNumber;
        this.elementType = elementType;
    }
    public Conductor(){
        
    }

    @Override
    public int getElementNumber() {
        return elementNumber;
    }

    @Override
    public String getElementType() {
        return elementType;
    }

    @Override
    public int getPartOfElementNumber() {
        return partOfElementNumber;
    }
}
