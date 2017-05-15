/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

/**
 *
 * @author Orion
 */
public class ElementsList {

    private Element[] list;
    int currentLength;

    public ElementsList() {
        list = new Element[2];
        currentLength = 0;
    }

    public void addElement(Element element) {
        if (currentLength == list.length) {
            doubleSize();
        }
        list[currentLength++] = element;
    }

    public void deleteElement(int i) {
        list[i] = null;
    }

    //do it when user wants to save generated Board
    public void clearList() {
        int nonNullCounter = 0;
        Element[] newList = new Element[list.length];
        for (Element listLoop : list) {
            if (listLoop != null) {
                newList[nonNullCounter] = listLoop;
                nonNullCounter++;
            }
        }
        Element[] finalList = new Element[nonNullCounter];
        System.arraycopy(newList, 0, finalList, 0, nonNullCounter);
        list = finalList;
    }

    private void doubleSize() {
        Element[] newList = new Element[2 * currentLength];
        System.arraycopy(list, 0, newList, 0, currentLength);
        list = newList;
    }
}
