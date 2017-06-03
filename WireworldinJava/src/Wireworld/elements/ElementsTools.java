package Wireworld.elements;

import Wireworld.Logic.Conductor;
import Wireworld.generator.WireWorldManager;
import java.awt.Component;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Klasa służy do ustawiania grafiki dla danego stanu i prawidłowego położenia
 * jego na planszy
 */
public class ElementsTools {

    /**
     * Metoda zmienia kolor etykiety(odpowiadającej pojedyńczemu punktowi na
     * planszy) w podglądzei planszy generatora nowych plansz
     *
     * @param valueX współrzędna x punktu
     * @param valueY współrzędna y punktu
     * @param label etykieta, służąca do pobrania "rodzica" wszystkich etykiet
     * @param type rodzaj wyświetlanej grafiki
     */
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

    /**
     * Metoda odpowiedzilna za pobranie etykiety po jej nazwie
     *
     * @param name etykiety
     * @return zwraca etykietę
     */
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

    /**
     * Pobieranie wartości współrzędnej x wskazywanej przez kursor etykiety
     *
     * @param name zapisana współrzedna
     * @return zwraca współrzędną x
     */
    public int getX(String name) {
        String loc[] = name.split("x");
        return Integer.parseInt(loc[0]);
    }

    /**
     * Pobieranie wartości współrzędnej y wskazywanej przez kursor etykiety
     *
     * @param name zapisana współrzedna
     * @return zwraca współrzędną y
     */
    public int getY(String name) {
        String loc[] = name.split("x");
        return Integer.parseInt(loc[1]);
    }

    /**
     * Metoda sprawdza czy komórka której w generatorze zmienia się kolor przy
     * podglądzie ma zmieniony stan na planszy na Przewodnik
     *
     * @param x współrzędna x komórki
     * @param y współrzędna y komórki
     * @return zwraca prawdę, jeżeli komórka ma zminiony stan w przeciwnym
     * wypadku zwraca fałsz
     */
    public boolean isSetted(int x, int y) {
        return WireWorldManager.getInstance().getBoard().getPointOnBoard(x, y) instanceof Conductor;
    }
}
