/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Orion
 */
public class ElementsList implements ElementsListInterface {

    private ArrayList<Element> list;

    public ElementsList() {
        list = new ArrayList<>();
    }

    @Override
    public void addElement(Element element) {
        list.add(element);
    }

    @Override
    public void deleteElement(int number) {
        for(int i =0; i < list.size(); i++){
            if((list.get(i)).getMyNumber() == number){
                list.remove(i);
            }
        }
    }

    public Element getElement(int i) {
        return list.get(i);
    }

    public Iterator getIterator() {
        return list.iterator();
    }
}
