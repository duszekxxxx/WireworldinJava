package Wireworld.elements;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.EmptyCell;
import Wireworld.generator.WireWorldManager;
import Wireworld.windows.JFrameGenerator;
import javax.swing.JLabel;

/**
 * Nadrzędna klasa, która stanowi wyjście do implementacji poszczególnych
 * elementów wraz z metodami odpowiedzialnymi za rysowanie w generatorze;
 */
public abstract class Element {

    /**
     * Wielkość horyzontalna planszy
     */
    protected final int mapHorizontalSize = WireWorldManager.getInstance().getBoard().getHorizontalSize();

    /**
     * Wielkość wertykalna planszy
     */
    protected final int mapVerticalSize = WireWorldManager.getInstance().getBoard().getVerticalSize();

    /**
     * Objekt zawierający narzędzai wspólne dla metod klas podrzędnych
     */
    protected final ElementsTools tools = new ElementsTools();
    ;

    /**
     * Plansza, na której ustawiane i usuwane są elementy
     */
    protected final BoardGame board = WireWorldManager.getInstance().getBoard();

    /**
     * Lista elementów znajdujących się na planszy
     */
    protected final ElementsListInterface elementsList = WireWorldManager.getInstance().getElementsList();
    private static int elementCounter = 0;
    private int positionX;
    private int positionY;
    private int myNumber;
    private final String type;

    /**
     * Konstruktor przypisujący typ elementu
     *
     * @param type nazwa typu elementu
     */
    public Element(String type) {
        this.type = type;
    }

    /**
     * Metoda ta służy do rysowania elementu na podglądzie(w generatorze)
     *
     * @param label punkt (etykieta, którą wybrano), od którego zaczyna się
     * rysowanie obiektu
     */
    public void drawOnMap(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (!isColision(x, y) && isConectedToOther(x, y) && checkBoundaryConditions(x, y)) {
            drawElement(label, x, y, "valid");
        } else if (checkBoundaryConditions(x, y)) {
            drawElement(label, x, y, "invalid");
        }
    }

    /**
     * Metoda ta służy do cofania zmainy koloru etykiet przy podglądzie
     * ustawianego elementu na planszy w generatorze(jeżeli element nie został
     * umieszczony na stałe na planszy)
     *
     *
     * @param label punkt (etykieta, którą wybrano), od którego zaczyna się
     * rysowanie obiektu
     */
    public void drawBackOnMap(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (checkBoundaryConditions(x, y)) {
            drawElement(label, x, y, "changeBack");
        }
    }

    /**
     * Metoda ta służy do narysowania w wyznaczonym miejscu danego obiektu
     *
     * @param label punkt (etykieta, którą wybrano), od którego zaczyna się
     * rysowanie obiektu
     */
    public void drawOnMapAndSave(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (!isColision(x, y) && isConectedToOther(x, y) && checkBoundaryConditions(x, y)) {
            drawElement(label, x, y, "valid");
            changePointsStatusOnBoard(x, y, "conductor");
            elementsList.addElement(this);
            myNumber = elementCounter++;
            positionX = x;
            positionY = y;
            JFrameGenerator.setComunicat("Element został dodany pomyślnie!", true);
        } else if (isColision(x, y)) {
            JFrameGenerator.setComunicat("Nie można umieścić elementu: kolizja!", false);
        } else if (!isConectedToOther(x, y)) {
            JFrameGenerator.setComunicat("Nie można umieścić elementu: brak połączenia między elementami lub lewą ścianą!", false);
        } else if (checkBoundaryConditions(x, y)) {
            JFrameGenerator.setComunicat("Nie można umieścić elementu: element wykracza poza granice!", false);
        }
    }

    /**
     * Metoda ta służy do usuwania konkretnego elementu
     *
     * @param label punkt(etykieta, którą wybrano), który jest częścią elementu,
     * który ma zostać usunięty
     */
    public void deleteElement(JLabel label) {
        changePointsStatusOnBoard(positionX, positionY, "emptyCell");
        drawElement(label, positionX, positionY, "changeBack");
        elementsList.deleteElement(myNumber);
        JFrameGenerator.setComunicat("Element został usunięty!", true);

    }

    /**
     * Metoda służy do wstawiania odpowiedniego stanu do podanej komórki
     *
     * @param x współrzędna x komórki
     * @param y współrzędna y komórki
     * @param type nazwa stanu
     */
    protected void setNewState(int x, int y, String type) {
        switch (type) {
            case "emptyCell":
                board.setPointOnBoard(new EmptyCell(), x, y);
                break;
            case "conductor":
                board.setPointOnBoard(new Conductor(elementCounter), x, y);
                break;
            default:
                throw new IllegalArgumentException("picChange: invalid type. Type argument can be sat as: emptyCell, conductor ");
        }
    }

    /**
     * Metoda sprawdza czy element jest połączony z punktem na którym znajduje
     * się element planszy
     *
     * @param x współrzędna x początku elementu
     * @param y współrzędna y początku elementu
     * @return prawdę, jeżeli jest połączony z innym elementem w przeciwnym
     * wypadku zwraca false
     */
    public abstract boolean isConectedToOther(int x, int y);

    /**
     * Sprawdza czy wystęuje kolizja z innymi elementami planszy
     *
     * @param x współrzędna x początku elementu
     * @param y współrzędna y początku elementu
     * @return prawdę, jeżeli wystęuje kolzija z innym elementem w przeciwnym
     * wypadku zwraca false
     */
    public abstract boolean isColision(int x, int y);

    /**
     * Metoda ustawia lub usuwa element z planszy poprzez zmianę statusu
     * odpowiednich elementów ( z Empty Cell na Conductor lub odwrotnie)
     *
     * @param x współrzędna x początku elementu
     * @param y współrzędna y początku elementu
     * @param type nowy status danej komórki
     */
    public abstract void changePointsStatusOnBoard(int x, int y, String type);

    /**
     * Metoda sprawdza czy dany punkt nie wychodzi poza granice planszy
     *
     * @param x współrzędna y początku elementu
     * @param y współrzędna x początku elementu
     * @return zwraca prawdę jeżeli punkt mieści się w granicach, fałsz w
     * przeciwnym wypadku
     */
    public abstract boolean checkBoundaryConditions(int x, int y);

    /**
     * Metoda służy do rysowania(od podanego punktu) elementu na planszy
     *
     * @param label etykieta do wyświetlania błędów
     * @param x współrzedna x-owa punktu od którego zacyzna się rysowanie
     * @param y współrzedna y-owa punktu od którego zacyzna się rysowanie
     * @param type rodzaj elementu do narysownaia
     */
    public abstract void drawElement(JLabel label, int x, int y, String type);

    /**
     * Metoda zwraca pozycje x-ową początku danego elementu
     *
     * @return zwraca pozycje x-ową
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Metoda zwraca pozycje y-ową początku danego elementu
     *
     * @return zwraca pozycje y-ową
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Metoda zwraca numer elementu
     *
     * @return zwraca numer elementu
     */
    public int getMyNumber() {
        return myNumber;
    }

    /**
     * Metoda zwraca nazwę rodzaj elementu
     *
     * @return zwraca nazwę rodzaju elementu
     */
    public String getType() {
        return type;
    }

}
