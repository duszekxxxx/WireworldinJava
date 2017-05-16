/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.generator.PicValues;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class Diode extends Element implements PicValues {
    //It's not ready yet
    //
    //
    //
    //
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
    public boolean isColision(int x, int y) {
        for (int i = 0; i < 7; i++) {
            if ((board.getPointOnBoard(x + i, y)) instanceof Conductor) {
                return true;
            }
        }
        for (int i = 8; i < 14; i++) {
            if ((board.getPointOnBoard(x + i, y)) instanceof Conductor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void drawingOnMap(JLabel label, int x, int y, boolean isAlright) {
        if (isAlright) {
            tools.picChange(x, y, label);
            tools.picChange(x, y + 1, label);
            tools.picChange(x, y + 2, label);
            tools.picChange(x, y + 3, label);
            tools.picChange(x, y + 4, label);
            tools.picChange(x, y + 5, label);
            tools.picChange(x, y + 6, label);
            tools.picChange(x, y + 6, label);
            tools.picChange(x, y + 6, label);
            tools.picChange(x, y + 7, label);
            tools.picChange(x, y + 7, label);
            tools.picChange(x, y + 8, label);
            tools.picChange(x, y + 9, label);
            tools.picChange(x, y + 10, label);
            tools.picChange(x, y + 11, label);
            tools.picChange(x, y + 12, label);
            tools.picChange(x, y + 13, label);
        } else {
            tools.picChangeInvalid(x, y, label);
            tools.picChangeInvalid(x, y + 1, label);
            tools.picChangeInvalid(x, y + 2, label);
            tools.picChangeInvalid(x, y + 3, label);
            tools.picChangeInvalid(x, y + 4, label);
            tools.picChangeInvalid(x, y + 5, label);
            tools.picChangeInvalid(x, y + 6, label);
            tools.picChangeInvalid(x, y + 6, label);
            tools.picChangeInvalid(x, y + 6, label);
            tools.picChangeInvalid(x, y + 7, label);
            tools.picChangeInvalid(x, y + 7, label);
            tools.picChangeInvalid(x, y + 8, label);
            tools.picChangeInvalid(x, y + 9, label);
            tools.picChangeInvalid(x, y + 10, label);
            tools.picChangeInvalid(x, y + 11, label);
            tools.picChangeInvalid(x, y + 12, label);
            tools.picChangeInvalid(x, y + 13, label);
        }
    }

    @Override
    public void drawingBackOnMap(JLabel label, int x, int y, boolean isAlright) {
        if (isAlright) {
            tools.picChange(x, y, label);
            tools.picChange(x, y + 1, label);
            tools.picChange(x, y + 2, label);
            tools.picChange(x, y + 3, label);
            tools.picChange(x, y + 4, label);
            tools.picChange(x, y + 5, label);
            tools.picChange(x, y + 6, label);
            tools.picChange(x, y + 6, label);
            tools.picChange(x, y + 6, label);
            tools.picChange(x, y + 7, label);
            tools.picChange(x, y + 7, label);
            tools.picChange(x, y + 8, label);
            tools.picChange(x, y + 9, label);
            tools.picChange(x, y + 10, label);
            tools.picChange(x, y + 11, label);
            tools.picChange(x, y + 12, label);
            tools.picChange(x, y + 13, label);
        } else {
            tools.picChangeBack(x, y, label);
            tools.picChangeBack(x, y + 1, label);
            tools.picChangeBack(x, y + 2, label);
            tools.picChangeBack(x, y + 3, label);
            tools.picChangeBack(x, y + 4, label);
            tools.picChangeBack(x, y + 5, label);
            tools.picChangeBack(x, y + 6, label);
            tools.picChangeBack(x, y + 6, label);
            tools.picChangeBack(x, y + 6, label);
            tools.picChangeBack(x, y + 7, label);
            tools.picChangeBack(x, y + 7, label);
            tools.picChangeBack(x, y + 8, label);
            tools.picChangeBack(x, y + 9, label);
            tools.picChangeBack(x, y + 10, label);
            tools.picChangeBack(x, y + 11, label);
            tools.picChangeBack(x, y + 12, label);
            tools.picChangeBack(x, y + 13, label);
        }
    }

    @Override
    public void settingPointsOnBoard(int x, int y) {
        board.setPointOnBoard(new ElectronTail(), x, y);
        board.setPointOnBoard(new ElectronHead(), x, y + 1);
        board.setPointOnBoard(new Conductor(), x, y + 2);
        board.setPointOnBoard(new Conductor(), x, y + 3);
        board.setPointOnBoard(new Conductor(), x, y + 4);
        board.setPointOnBoard(new Conductor(), x, y + 5);
        board.setPointOnBoard(new Conductor(), x, y + 6);
        board.setPointOnBoard(new Conductor(), x, y + 6);
        board.setPointOnBoard(new Conductor(), x, y + 6);
        board.setPointOnBoard(new Conductor(), x, y + 7);
        board.setPointOnBoard(new Conductor(), x, y + 7);
        board.setPointOnBoard(new Conductor(), x, y + 8);
        board.setPointOnBoard(new Conductor(), x, y + 9);
        board.setPointOnBoard(new Conductor(), x, y + 10);
        board.setPointOnBoard(new Conductor(), x, y + 11);
        board.setPointOnBoard(new Conductor(), x, y + 12);
        board.setPointOnBoard(new Conductor(), x, y + 13);
    }

    @Override
    public boolean checkBoundaryConditions(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePointsFromBoard(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkDeletionPosibility(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
