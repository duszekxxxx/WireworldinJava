/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.elements;

import java.util.Iterator;

/**
 *
 * @author Orion
 */
public interface ElementsListInterface {

    public void addElement(Element element);

    public void deleteElement(int number);

    public Element getElement(int i);

    public Iterator getIterator();

}
