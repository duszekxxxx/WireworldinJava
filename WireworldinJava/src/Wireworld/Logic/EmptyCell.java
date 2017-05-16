
package Wireworld.Logic;

public class EmptyCell implements States{

    @Override
    public String getElementType() {
        return "";
    }

    @Override
    public int getElementNumber() {
        return -1;
    }

    @Override
    public int getPartOfElementNumber() {
        return -1;
    }
    
}
