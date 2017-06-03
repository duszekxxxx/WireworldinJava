package Wireworld.elements;

import Wireworld.Logic.Conductor;
import javax.swing.JLabel;

/**
 * Klasa relaizująca implementacje elementu: bramki OR
 */
public class GateOR extends Element {

    /**
     * Konstruktor tworzący element o nazwie "GateOR"
     */
    public GateOR() {
        super("GateOR");
    }

    @Override
    public boolean isConectedToOther(int x, int y) {
        if (x == 0) {
            return true;
        } else if (checkUpConection(x, y)) {
            return true;
        }
        return checkDownConection(x, y);
    }

    /**
     * Metoda sprawdzająca połączenie przy górnym końcu elementu
     *
     * @param x - współrzędna x początku elementu
     * @param y - współrzędna y początku elementu
     * @return Zwaraca prawda, jeśli istnieje połączenie z innym elementem. W
     * przeciwnym wypadku zwraca fałsz.
     */
    private boolean checkUpConection(int x, int y) {
        if ((board.getPointOnBoard(x - 1, y - 2)) instanceof Conductor) {
            return true;
        } else if ((board.getPointOnBoard(x, y - 3)) instanceof Conductor) {
            return true;
        } else if ((board.getPointOnBoard(x, y - 1)) instanceof Conductor) {
            return true;
        }
        return false;
    }

    /**
     * Metoda sprawdzająca połączenie przy dolnym końcu elementu
     *
     * @param x - współrzędna x początku elementu
     * @param y - współrzędna y początku elementu
     * @return Zwaraca prawda, jeśli istnieje połączenie z innym elementem. W
     * przeciwnym wypadku zwraca fałsz.
     */
    private boolean checkDownConection(int x, int y) {
        if ((board.getPointOnBoard(x - 1, y)) instanceof Conductor) {
            return true;
        } else if ((board.getPointOnBoard(x, y + 1)) instanceof Conductor) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isColision(int x, int y) {
        int i = 0;
        while (i < 3) {
            if ((board.getPointOnBoard(x + i, y)) instanceof Conductor) {
                return true;
            } else if ((board.getPointOnBoard(x + i, y - 2)) instanceof Conductor) {
                return true;
            }
            i++;
        }
        while (i < 5) {
            if ((board.getPointOnBoard(x + i, y + 1)) instanceof Conductor) {
                return true;
            } else if ((board.getPointOnBoard(x + i, y - 3)) instanceof Conductor) {
                return true;
            }
            i++;
        }
        if ((board.getPointOnBoard(x + i, y)) instanceof Conductor) {
            return true;
        } else if ((board.getPointOnBoard(x + i, y - 2)) instanceof Conductor) {
            return true;
        }
        i--;
        while (i < 14) {
            if ((board.getPointOnBoard(x + i, y - 1)) instanceof Conductor) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public void changePointsStatusOnBoard(int x, int y, String type) {
        int i = 0;
        while (i < 3) {
            setNewState(x + i, y, type);
            setNewState(x + i, y - 2, type);
            i++;
        }
        while (i < 5) {
            setNewState(x + i, y + 1, type);
            setNewState(x + i, y - 3, type);
            i++;
        }
        setNewState(x + i, y, type);
        setNewState(x + i, y - 2, type);
        i--;
        while (i < 14) {
            setNewState(x + i, y - 1, type);
            i++;
        }
    }

    @Override
    public boolean checkBoundaryConditions(int x, int y) {
        return x >= 0 && y >= 3 && y < mapVerticalSize - 1 && x < mapHorizontalSize - 13;
    }

    @Override
    public void drawElement(JLabel label, int x, int y, String type) {
        int i = 0;
        while (i < 3) {
            tools.picChange(x + i, y, label, type);
            tools.picChange(x + i, y - 2, label, type);
            i++;
        }
        while (i < 5) {
            tools.picChange(x + i, y + 1, label, type);
            tools.picChange(x + i, y - 3, label, type);
            i++;
        }
        tools.picChange(x + i, y, label, type);
        tools.picChange(x + i, y - 2, label, type);
        i--;
        while (i < 14) {
            tools.picChange(x + i, y - 1, label, type);
            i++;
        }
    }
}
