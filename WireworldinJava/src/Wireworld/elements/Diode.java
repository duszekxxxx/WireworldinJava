/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.Conductor;
import Wireworld.generator.PicValues;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class Diode extends Element implements PicValues {

    private final String diodeType;

    public Diode(String diodeType) {
        super(diodeType + " " + "Diode");
        if (diodeType.equals("Normal") || diodeType.equals("Reversed")) {
            this.diodeType = diodeType;
        } else {
            throw new IllegalArgumentException("Diode constructor: diodeType must be \"Normal\" or \"Reversed\"");
        }
    }

    @Override
    public boolean isConectedToOther(int x, int y) {
        if (x == 0) {
            return true;
        } else {
            if ((board.getPointOnBoard(x - 1, y)) instanceof Conductor) {
                return true;
            } else if ((board.getPointOnBoard(x, y - 1)) instanceof Conductor) {
                return true;
            } else if ((board.getPointOnBoard(x, y + 1)) instanceof Conductor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isColision(int x, int y) {
        for (int i = 0; i < 14; i++) {
            if (i != 6 && i != 7) {
                if ((board.getPointOnBoard(x + i, y)) instanceof Conductor) {
                    return true;
                }
            } else {
                if ((board.getPointOnBoard(x + i, y + 1)) instanceof Conductor) {
                    return true;
                } else if ((board.getPointOnBoard(x + i, y - 1)) instanceof Conductor) {
                    return true;
                }
            }
        }
        switch (diodeType) {
            case "Normal":
                if ((board.getPointOnBoard(x + 6, y)) instanceof Conductor) {
                    return true;
                }
                break;
            case "Reversed":
                if ((board.getPointOnBoard(x + 7, y)) instanceof Conductor) {
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public void changePointsStatusOnBoard(int x, int y, String type) {
        for (int i = 0; i < 14; i++) {
            if (i != 6 && i != 7) {
                setNewState(x + i, y, type);
            } else {
                setNewState(x + i, y - 1, type);
                setNewState(x + i, y + 1, type);
            }
        }
        switch (diodeType) {
            case "Normal":
                setNewState(x + 6, y, type);
                break;
            case "Reversed":
                setNewState(x + 7, y, type);
                break;
        }
    }

    @Override
    public boolean checkBoundaryConditions(int x, int y
    ) {
        return x > 1 || y < mapVerticalSize - 1 || y < 1 || x > mapHorizontalSize - 14;
    }

    @Override
    public void drawElement(JLabel label, int x, int y, String type
    ) {
        tools.picChange(x, y, label, type);
        tools.picChange(x + 1, y, label, type);
        tools.picChange(x + 2, y, label, type);
        tools.picChange(x + 3, y, label, type);
        tools.picChange(x + 4, y, label, type);
        tools.picChange(x + 5, y, label, type);
        tools.picChange(x + 6, y - 1, label, type);
        tools.picChange(x + 6, y + 1, label, type);
        tools.picChange(x + 7, y - 1, label, type);
        tools.picChange(x + 7, y + 1, label, type);
        tools.picChange(x + 8, y, label, type);
        tools.picChange(x + 9, y, label, type);
        tools.picChange(x + 10, y, label, type);
        tools.picChange(x + 11, y, label, type);
        tools.picChange(x + 12, y, label, type);
        tools.picChange(x + 13, y, label, type);

        switch (diodeType) {
            case "Normal":
                tools.picChange(x + 6, y, label, type);
                break;
            case "Reversed":
                tools.picChange(x + 7, y, label, type);
                break;
        }
    }

    @Override
    public boolean checkDeletionPosibility(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
