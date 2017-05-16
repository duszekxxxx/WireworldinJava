/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import Wireworld.Logic.Board;
import Wireworld.generator.WireWorldManager;
import Wireworld.windows.JFrameGenerator;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public abstract class Element {

    protected static int elementCounter = 0;
    protected final int mapHorizontalSize;
    protected final int mapVerticalSize;
    protected final ElementsTools tools;
    protected final Board board;
    protected final ElementsList elementsList;

    public Element() {
        mapVerticalSize = WireWorldManager.getInstance().getBoard().getVerticalSize();
        mapHorizontalSize = WireWorldManager.getInstance().getBoard().getHorizontalSize();
        elementsList = WireWorldManager.getInstance().getElementsList();
        board = WireWorldManager.getInstance().getBoard();
        tools = new ElementsTools();
    }

    public void drawOnMap(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (!isColision(x, y) && isConectedToOther(x, y) && checkBoundaryConditions(x, y)) {
            drawingOnMap(label, x, y, true);
        } else if (checkBoundaryConditions(x, y)) {
            drawingOnMap(label, x, y, false);
        }
    }

    public void drawOnMapAndSave(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (!isColision(x, y) && isConectedToOther(x, y) && checkBoundaryConditions(x, y)) {
            drawingOnMap(label, x, y, true);
            settingPointsOnBoard(x, y);
            elementsList.addElement(this);
            increaseCounter();
            JFrameGenerator.setComunicat("Element został dodany pomyślnie!", true);
        } else if (isColision(x, y)) {
            JFrameGenerator.setComunicat("Nie można umieścić elementu: kolizja!", false);
        } else if (!isConectedToOther(x, y)) {
            JFrameGenerator.setComunicat("Nie można umieścić elementu: brak połączenia między elementami lub lewą ścianą!", false);
        } else if (checkBoundaryConditions(x, y)) {
            JFrameGenerator.setComunicat("Nie można umieścić elementu: element wykracza poza granice!", false);
        }
    }

    public void drawBackOnMap(JLabel label) {
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (checkBoundaryConditions(x, y)) {
            boolean setted = tools.isSetted(x, y);
            drawingBackOnMap(label, x, y, setted);
        }
    }

    public void deleteElement(JLabel label, int number) {
        //Checking if it is on the last added element
        int x = tools.getX(label.getName());
        int y = tools.getY(label.getName());
        if (checkDeletionPosibility(x, y)) {
            drawingBackOnMap(label, x, y, false);
            deletePointsFromBoard(x, y);
            elementsList.deleteElement(number);
            JFrameGenerator.setComunicat("Element został dodany usunięty!", true);
        } else {
            JFrameGenerator.setComunicat("Element nie może mieć przyłączone nic z prawej strony", true);
        }
    }

    public abstract boolean isConectedToOther(int x, int y);

    public abstract boolean isColision(int x, int y);

    public abstract void drawingOnMap(JLabel label, int x, int y, boolean isAlright);

    public abstract void drawingBackOnMap(JLabel label, int x, int y, boolean isAlright);

    public abstract void settingPointsOnBoard(int x, int y);

    public abstract boolean checkBoundaryConditions(int x, int y);

    public abstract void deletePointsFromBoard(int x, int y);
    
    public abstract boolean checkDeletionPosibility(int x , int y);

    public void increaseCounter() {
        elementCounter++;
    }

    public int getCounter() {
        return elementCounter;
    }
    
}
