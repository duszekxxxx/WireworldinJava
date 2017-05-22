/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.generator;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;
import Wireworld.Logic.States;
import Wireworld.elements.Diode;
import Wireworld.elements.Element;
import Wireworld.elements.GateOR;
import Wireworld.elements.GateXOR;
import Wireworld.elements.SingleConductor;
import static Wireworld.windows.JFrameGenerator.setComunicat;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class Tools implements PicValues {

    private static String type = null;
    private static boolean elementChoosen;
    private static JLabel previousLabel;
    private static Element element = null;
    private static boolean deleteOperation = false;

    public static void setType(String myType) {
        type = myType;
        elementChoosen = true;
        element = null;
        deleteOperation = false;
    }

    public static void clear() {
        if (previousLabel != null) {
            element.drawBackOnMap(previousLabel);
        }
        previousLabel = null;
    }

    public static void setStartCurrent() {
        BoardGame board = WireWorldManager.getInstance().getBoard();
        for (int i = 0; i < board.getVerticalSize(); i++) {
            if (board.getPointOnBoard(0, i) instanceof Conductor) {
                board.setPointOnBoard(new ElectronTail(), 0, i);
            }
            if (board.getPointOnBoard(1, i) instanceof Conductor) {
                board.setPointOnBoard(new ElectronHead(), 1, i);
            }
        }
    }

    public void changeElement(JLabel label, boolean isConstant) {
        if (elementChoosen) {
            if (element == null) {
                element = getElementByType();
            }
            if (previousLabel != null) {
                element.drawBackOnMap(previousLabel);
            }
            clear();
            drawingControl(label, isConstant);
        }
    }

    private Element getElementByType() {
        switch (type) {
            case "ReversedDiode":
                return new Diode("Reversed");
            case "NormalDiode":
                return new Diode("Normal");
            case "SingleConductor":
                return new SingleConductor();
            case "GateXOR":
                return new GateXOR();
            case "GateOR":
                return new GateOR();
            default:
                setComunicat("Wybrano nieobsługiwany element", false);
                return null;
        }
    }

    private void drawingControl(JLabel label, boolean isConstant) {
        if (isConstant) {
            element.drawOnMapAndSave(label);
            previousLabel = null;
            elementChoosen = false;
            element = null;
        } else {
            element.drawOnMap(label);
            previousLabel = label;
        }
    }

    public boolean isDeleteOperation() {
        return deleteOperation;
    }

    public static void setDeleteOperation() {
        clear();
        setType("");
        deleteOperation = true;
    }

    void deleteElement(JLabel jLabel) {
        String loc[] = (jLabel.getName()).split("x");
        int x = Integer.parseInt(loc[0]);
        int y = Integer.parseInt(loc[1]);
        States state = WireWorldManager.getInstance().getBoard().getPointOnBoard(x, y);
        if (!(state instanceof EmptyCell)) {
            int number = state.getElementNumber();
            Element toDelete = WireWorldManager.getInstance().getElementsList().getElementByNumber(number);
            toDelete.deleteElement(jLabel);
        }
    }
}
