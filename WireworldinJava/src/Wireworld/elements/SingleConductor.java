/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.Conductor;
import javax.swing.JLabel;

/**
/**
 *Klasa relaizująca implementacje elementu: bramki OR
 */
public class SingleConductor extends Element {

    public SingleConductor() {
        super("SingleConductor");
    }

    @Override
    public boolean isColision(int x, int y) {
        return (board.getPointOnBoard(x, y)) instanceof Conductor;
    }

    @Override
    public boolean isConectedToOther(int x, int y) {
        if (x == 0) {
            return true;
        } else {
            if ((board.getPointOnBoard(x - 1, y)) instanceof Conductor) {
                return true;
            } else if ((board.getPointOnBoard(x + 1, y)) instanceof Conductor) {
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
    public void changePointsStatusOnBoard(int x, int y, String type) {
        setNewState(x, y, type);
    }

    @Override
    public boolean checkBoundaryConditions(int x, int y) {
        return x >= 0 && y >= 0 && y < mapVerticalSize && x < mapHorizontalSize;
    }

    @Override
    public void drawElement(JLabel label, int x, int y, String type) {
        tools.picChange(x, y, label, type);
    }
}
