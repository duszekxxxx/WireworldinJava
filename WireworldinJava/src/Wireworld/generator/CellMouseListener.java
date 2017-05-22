/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.generator;

import Wireworld.Logic.States;
import static Wireworld.windows.JFrameGenerator.setComunicat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class CellMouseListener implements MouseListener {

    private static final Tools tools = new Tools();

    @Override
    public void mouseClicked(MouseEvent me) {
        if (tools.isDeleteOperation()) {
            tools.deleteElement((JLabel) me.getComponent());
        } else {
            tools.changeElement((JLabel) me.getComponent(), true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (!tools.isDeleteOperation()) {
            tools.changeElement((JLabel) me.getComponent(), false);
        }
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }
}
