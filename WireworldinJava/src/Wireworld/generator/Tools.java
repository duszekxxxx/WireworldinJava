/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.generator;

import Wireworld.Logic.States;
import Wireworld.elements.Diode;
import Wireworld.elements.Element;
import Wireworld.elements.SingleConductor;
import static Wireworld.windows.jFrameGenerator.setComunicat;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class Tools implements PicValues {

    private static String type = null;
    private static boolean elementChoosen;
    private static boolean deleteOperation;
    private static JLabel previousLabel;
    private static Element element = null;

    public static void setType(String myType) {
        type = myType;
        elementChoosen = true;
        deleteOperation = false;
    }

    public static void clear() {
        if (previousLabel != null) {
            element.drawBackOnMap(previousLabel);
        }
        previousLabel = null;
    }

    public static void setDeleteOperation() {
        setType("");
        deleteOperation = true;
        clear();
    }

    public void changeElement(JLabel label, boolean isConstant) {
        if (elementChoosen && deleteOperation == false) {
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

    public void deleteElement(JLabel label) {

        String name = label.getName();
        String loc[] = name.split("x");
        int x = Integer.parseInt(loc[0]);
        int y = Integer.parseInt(loc[1]);
        States s = WireWorldManager.getInstance().getBoard().getPointOnBoard(x, y);
        int number = s.getElementNumber();
        String elementType = s.getElementType();
        switch (elementType) {
            case "Diode":
                (new Diode()).deleteElement(label, number);
                break;
            case "SingleConductor":
                (new SingleConductor()).deleteElement(label, number);
                break;
            default:
                setComunicat("Wybrano nieobsługiwany element", false);
                break;
        }

    }

    public boolean isDeleteOperation() {
        return deleteOperation;
    }

    private Element getElementByType() {
        switch (type) {
            case "Diode":
                return null;//return new Diode();
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
