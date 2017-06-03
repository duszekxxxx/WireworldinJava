package Wireworld.generator;

import static Wireworld.windows.JFrameGenerator.setComunicat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Klasa implementująca MouseListner i dostosowująca go do obsługi 
 * przycisków gwnwratora
 */
public class ElementButtonMouseListener implements MouseListener {

    final private String type;

    public ElementButtonMouseListener(String type) {
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
