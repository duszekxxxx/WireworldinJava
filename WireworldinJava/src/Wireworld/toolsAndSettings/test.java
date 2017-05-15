/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import Wireworld.Logic.Board;
import Wireworld.Logic.BoardGame;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;

/**
 *
 * @author duszekxxxx
 */
public class test {

    public static void main(String argv[]) {

        Board plansza = new Board(10, 10);
        for (int i = 0; i < plansza.getHorizontalSize(); i++) {
            for (int j = 0; j < plansza.getVerticalSize(); j++) {
               plansza.setPointOnBoard(new EmptyCell(), i, j);
            }
        }
        plansza.setPointOnBoard(new Conductor(), 5, 5);
        for(int i =0;i<10;i++){
          plansza.setPointOnBoard(new Conductor(), i, 7);  
        }
        plansza.setPointOnBoard(new ElectronHead(), 9, 9);
        SaveAndOpenGeneration.saveToFile("generacja", plansza);
        
        BoardGame plansza2 = SaveAndOpenGeneration.openFile("generacja.xml");
        System.out.println("Vertical Size: "+plansza.getVerticalSize()+" Horizontal Size: "+plansza2.getHorizontalSize());
        for (int i = 0; i < plansza.getVerticalSize(); i++) {
            for (int j = 0; j < plansza.getHorizontalSize(); j++) {
                if (plansza2.getPointOnBoard(j, i) instanceof ElectronHead) {
                    System.out.print("H");
                } else if (plansza.getPointOnBoard(j, i) instanceof ElectronTail) {
                    System.out.print("T");
                } else if (plansza.getPointOnBoard(j, i) instanceof Conductor) {
                    System.out.print("C");
                } else if (plansza.getPointOnBoard(j, i) instanceof EmptyCell) {
                    System.out.print("B");
                }
            }
            System.out.print("\n"); 
        }    
    }

}
