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
import Wireworld.elements.Diode;
import Wireworld.elements.Element;
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

    public static void setType(String myType) {
        type = myType;
        elementChoosen = true;
        element = null;
    }

    public static void clear() {
        if (previousLabel != null) {
            element.drawBackOnMap(previousLabel);
        }
        previousLabel = null;
    }

    /*public static void setDeleteOperation() {
        deleteOperation = true;
        clear();
        setType("");
    }*/

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
}
