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
 * Klasa zawierająca narzędzia służące do operowania generatorem, tj. operowanie
 * doadawaniem, usuwaniem elementów, podgląd
 *
 */
public class Tools implements PicValues {

    private static String type = null;
    private static boolean elementChoosen;
    private static JLabel previousLabel;
    private static Element element = null;
    private static boolean deleteOperation = false;

    /**
     * Metoda ustawiająca typ wybranego przyciskiem elementu do ustaiwnia na
     * plaszy
     *
     * @param myType Typ ustawianego elementu
     */
    public static void setType(String myType) {
        type = myType;
        elementChoosen = true;
        element = null;
        deleteOperation = false;
    }

    /**
     * Metoda powodująca zresetowanie parametrów ustawiania elementu
     */
    public static void clear() {
        if (previousLabel != null) {
            element.drawBackOnMap(previousLabel);
        }
        previousLabel = null;
    }

    /**
     * Metoda powodująca zresetowanie parametrów ustawiania elementu wraz
     * dodatkową zmianą typu na "Nothing"
     */
    public static void clearAll() {
        clear();
        setType("Nothing");
    }

    /**
     * Metoda dodająca prąd na komórkach przyległych do lewego końca planszy,
     * gdy plansza zostanie zatwierdzona
     */
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

    /**
     * Metoda wykonująca przesunięcie elementu na podglądzie planszy
     *
     * @param label etykieta na której znajduje się obecnie kursor
     * @param isConstant parametr określający czy zapisać element na stałe(dla
     * wartości true), czy tylko umożliwić podgląd(dla wartości false)
     */
    public void moveElementOnMap(JLabel label, boolean isConstant) {
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

    /**
     * Metoda tworząca nowy element na podstawie podanej nazwy
     *
     * @return Zwraca nowy Element
     */
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
            case "Nothing":
                return null;
            default:
                setComunicat("Wybrano nieobsługiwany element", false);
                return null;
        }
    }

    /**
     * Metoda wywołująca rysowanie elementu w podglądzie generatora
     *
     * @param isConstant parametr określający czy zapisać element na stałe(dla
     * wartości true), czy tylko umożliwić podgląd
     * @param label etykieta na której znajduje się obecnie kursor
     */
    private void drawingControl(JLabel label, boolean isConstant) {
        if (element != null) {
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

    /**
     * Metoda zwraca true, jeżeli wybrano opcję usuwania elementów, w przeciwnym
     * wypadku zwraca false
     *
     * @return Zwraca true jeśli tak, false jeśli nie
     */
    public boolean isDeleteOperation() {
        return deleteOperation;
    }

    /**
     * Metoda ustaiająca obecną operację na usuwanie elementu
     */
    public static void setDeleteOperation() {
        clear();
        setType("");
        deleteOperation = true;
    }

    /**
     * Metoda realizująca usuwanie elementu z mapy
     *
     * @param jLabel Etykieta stanowiąca jeden z punktów elementu w podglądzie
     * generatora
     */
    public void deleteElement(JLabel jLabel) {
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
