/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klasa realizująca implementacje listy elementów gry
 */
public class ElementsList implements ElementsListInterface {

    private final ArrayList<Element> list;

    /**
     * Konstruktor tworzący domyślnie Arrayliste
     */
    public ElementsList() {
        list = new ArrayList<>();
    }

    @Override
    public void addElement(Element element) {
        list.add(element);
    }

    @Override
    public void deleteElement(int number) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i)).getMyNumber() == number) {
                list.remove(i);
            }
        }
    }

    @Override
    public Element getElementByNumber(int number) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i)).getMyNumber() == number) {
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public Iterator getIterator() {
        return list.iterator();
    }
}
