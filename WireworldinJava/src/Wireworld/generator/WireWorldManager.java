/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.generator;

import Wireworld.Logic.Board;
import Wireworld.elements.ElementsList;


/**
 *
 * @author Orion
 */
public class WireWorldManager {

    private static WireWorldManager ourInstance = null;
    private Board board;
    private final ElementsList elementsList;

    public static synchronized WireWorldManager getInstance() {
        if (null == ourInstance) {
            ourInstance = new WireWorldManager();
        }
        return ourInstance;
    }

    private WireWorldManager() {
        elementsList = new ElementsList();
    }

    public Board getBoard() {
        return board;
    }

    public ElementsList getElementsList() {
        return elementsList;
    }

    public void setNewBoard(int x, int y) {
        board = new Board(x, y);
    }

}
