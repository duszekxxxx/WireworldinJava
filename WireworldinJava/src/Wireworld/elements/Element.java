/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.EmptyCell;
import Wireworld.generator.WireWorldManager;
import Wireworld.windows.JFrameGenerator;
import javax.swing.JLabel;

/**
 *Nadrzędna klasa, która stanowi wyjście do implementacji poszczególnych elementów, rysowania w generatorze;
 */
public abstract class Element {

    protected final int mapHorizontalSize;
    protected final int mapVerticalSize;
    protected final ElementsTools tools;
    protected final BoardGame board;
    protected final ElementsListInterface elementsList;
    private static int elementCounter = 0;
    private int positionX;
    private int positionY;
    private int myNumber;
    private final String type;

    public Element(String type) {
        mapVerticalSize = WireWorldManager.getInstance().getBoard().getVerticalSize();
        mapHorizontalSize = WireWorldManager.getInstance().getBoard().getHorizontalSize();
        elementsList = WireWorldManager.getInstance().getElementsList();
        board = WireWorldManager.getInstance().getBoard();
        tools = new ElementsTools();
        this.type = type;
    }
    /**
     *Metoda ta służy do wyświetlenia, gdzie będzie narysowany element w generatorze 
     * @param label przycisk od którego zaczyna się rysowanie obiektu
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
     *Metoda ta cofa rysowanie elementów, które nie mają zostać narysowane
     * @param label przycisk od którego zaczyna się rysowanie obiektu
     */
    public void drawBackOnMap(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (checkBoundaryConditions(x, y)) {
            drawElement(label, x, y, "changeBack");
        }
    }
    /**
     *Metoda ta służy do narysowania w wyznaczonym miejscu danego obiektu
     * @param label przycisk od którego zaczyna się rysowanie obiektu
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
     *Metoda ta służy do usuwania konkretnego elementu
     * @param label przycisk od którego zaczyna się usuwanie
     */
    public void deleteElement(JLabel label) {
        changePointsStatusOnBoard(positionX, positionY, "emptyCell");
        drawElement(label, positionX, positionY, "changeBack");
        elementsList.deleteElement(myNumber);
        JFrameGenerator.setComunicat("Element został usunięty!", true);

    }

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

    public abstract boolean isConectedToOther(int x, int y);

    public abstract boolean isColision(int x, int y);

    public abstract void changePointsStatusOnBoard(int x, int y, String type);

    public abstract boolean checkBoundaryConditions(int x, int y);

    public abstract void drawElement(JLabel label, int x, int y, String type);

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public String getType() {
        return type;
    }

    protected boolean isSthConectedAtEnd(int endX, int endY) {
        if (endX < mapHorizontalSize - 1 && (board.getPointOnBoard(endX + 1, endY)) instanceof Conductor) {
            return true;
        } else if (endY < mapVerticalSize + 1 && (board.getPointOnBoard(endX - 1, endY + 1)) instanceof Conductor) {
            return true;
        } else if (endY < mapVerticalSize - 1 && (board.getPointOnBoard(endX - 1, endY - 1)) instanceof Conductor) {
            return true;
        }
        return false;
    }
}
