/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.Conductor;
import Wireworld.Logic.EmptyCell;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class SingleConductor extends Element {

    @Override
    public boolean isColision(int x, int y) {
        return (board.getPointOnBoard(x, y)) instanceof Conductor;
    }

    @Override
    public boolean isConectedToOther(int x, int y) {
        if (x == 0) {
            return true;
        } else if ((board.getPointOnBoard(x - 1, y)) instanceof Conductor) {
            return true;
        }
        return false;
    }

    @Override
    public void drawingOnMap(JLabel label, int x, int y, boolean isAlright) {
        if (isAlright) {
            tools.picChange(x, y, label);
        } else {
            tools.picChangeInvalid(x, y, label);
        }
    }

    @Override
    public void settingPointsOnBoard(int x, int y) {
        board.setPointOnBoard(new Conductor(super.getCounter(), 0, "SingleConductor"), x, y);
    }

    @Override
    public boolean checkBoundaryConditions(int x, int y) {
        return x > 0 || y < mapVerticalSize || x < mapHorizontalSize;
    }

    @Override
    public void drawingBackOnMap(JLabel label, int x, int y, boolean isSetted) {
        if (isSetted) {
            tools.picChange(x, y, label);
        } else {
            tools.picChangeBack(x, y, label);
        }
    }

    @Override
    public void deletePointsFromBoard(int x, int y) {
        board.setPointOnBoard(new EmptyCell(), x, y);
    }

    @Override
    public boolean checkDeletionPosibility(int x, int y) {
        boolean condition1 = x >= 0 && x < (mapHorizontalSize - 1);
        boolean condition2 = y >= 0 && y < (mapVerticalSize - 1);
        if(x < (mapHorizontalSize - 1)){
            boolean condition3 = (board.getPointOnBoard(x+1, y)) instanceof EmptyCell;
            return condition1 && condition2 && condition3;
        } else{
            return condition1 && condition2; 
        }
    }
}
