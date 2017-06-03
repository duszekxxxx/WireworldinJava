package Wireworld.generator;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * Klasa implementująca MouseListner. Służy do wykrywania kliknięć myszki i
 * ruchu myszy po planszy w generatorze , aby wstawić, usunąć, umożliwić podgląd
 * elementu w generatorze
 */
public class CellMouseListener implements MouseListener {

    private static final Tools tools = new Tools();

    @Override
    public void mouseClicked(MouseEvent me) {
        if (tools.isDeleteOperation()) {
            tools.deleteElement((JLabel) me.getComponent());
        } else {
            tools.moveElementOnMap((JLabel) me.getComponent(), true);
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
            tools.moveElementOnMap((JLabel) me.getComponent(), false);
        }
    }

    @Override
    public void mouseExited(MouseEvent me
    ) {
    }
}
