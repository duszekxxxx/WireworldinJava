/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.generator;

import Wireworld.Logic.BoardGame;
import Wireworld.elements.ElementsList;
import Wireworld.elements.ElementsListInterface;


/**
 *
 * @author Orion
 */
public class WireWorldManager {

    private static WireWorldManager ourInstance = null;
    private BoardGame board;
    private ElementsListInterface elementsList;

    public static synchronized WireWorldManager getInstance() {
        if (null == ourInstance) {
            ourInstance = new WireWorldManager();
        }
        return ourInstance;
    }

    private WireWorldManager() {
        elementsList = new ElementsList();
    }

    public BoardGame getBoard() {
        return board;
    }

    public ElementsListInterface getElementsList() {
        return elementsList;
    }
    
    public void setLoadedList(ElementsList elementsList){
        this.elementsList = elementsList;
    }

    public void setBoard(BoardGame board) {
        this.board = board;
    }

}
