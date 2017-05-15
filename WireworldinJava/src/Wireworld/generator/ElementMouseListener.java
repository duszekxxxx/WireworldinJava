/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.generator;

import static Wireworld.windows.JFrameGenerator.setComunicat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Orion
 */
public class ElementMouseListener implements MouseListener {

    final private String type;

    public ElementMouseListener(String type) {
        this.type = type;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        setComunicat("", true);
        Tools.clear();
        Tools.setType(type);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
