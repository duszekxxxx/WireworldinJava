/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.Conductor;
import Wireworld.generator.WireWorldManager;
import java.awt.Component;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *Klasa służy do 
 */
public class ElementsTools {

    public void picChange(int valueX, int valueY, JLabel label, String type) {
        JLabel elemLabel = findLabelByName(label.getParent(), valueX + "x" + valueY);
        switch (type) {
            case "valid":
                elemLabel.setIcon(new ImageIcon(getClass().getResource("../pConductor.png")));
                break;
            case "invalid":
                elemLabel.setIcon(new ImageIcon(getClass().getResource("../pInvalid.png")));
                break;
            case "changeBack":
                if (isSetted(valueX, valueY)) {
                    elemLabel.setIcon(new ImageIcon(getClass().getResource("../pConductor.png")));
                } else {
                    elemLabel.setIcon(new ImageIcon(getClass().getResource("../pBlank.png")));
                }
                break;
            default:
                throw new IllegalArgumentException("picChange: invalid type. Type argument can be sat as: valid, invalid or changeBack");
        }
    }

    private JLabel findLabelByName(Container parent, String name) {
        if (name != null && parent != null) {
            for (Component child : parent.getComponents()) {
                if (child instanceof JLabel) {
                    JLabel label = (JLabel) child;
                    if (name.equals(label.getName())) {
                        return label;
                    }
                }
            }
        }
        return null;
    }

    public int getX(String name) {
        String loc[] = name.split("x");
        return Integer.parseInt(loc[0]);
    }

    public int getY(String name) {
        String loc[] = name.split("x");
        return Integer.parseInt(loc[1]);
    }

    public boolean isSetted(int x, int y) {
        return WireWorldManager.getInstance().getBoard().getPointOnBoard(x, y) instanceof Conductor;
    }
}
