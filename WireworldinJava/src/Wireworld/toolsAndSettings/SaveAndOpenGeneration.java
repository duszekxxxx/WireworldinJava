

package Wireworld.toolsAndSettings;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import java.io.PrintWriter;


public class SaveAndOpenGeneration {
    public static void saveToFile(String FileName, BoardGame board){

         try (PrintWriter zapis = new PrintWriter(FileName+".xml")) {
                zapis.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<save>\n" +
                        "<horizontalSize>"+board.getHorizontalSize()+"</horizontalSize>\n"+
                        "<verticalSize>"+board.getVerticalSize()+"</verticalSize>\n"+
                "	<Points>\n" +
                "		<Conductor>");
                for(int i=0;i<board.getHorizontalSize();i++){
                    for(int j=0;j<board.getVerticalSize();j++){
                        if(board.getPointOnBoard(i, j) instanceof Conductor){
                            zapis.print("<point x=\""+i+"\" y=\""+j+"\"></point>");
                        }
                    }
                   
                }
                 zapis.println("\n</Conductor>\n<Head>");
                 for(int i=0;i<board.getHorizontalSize();i++){
                    for(int j=0;j<board.getVerticalSize();j++){
                        if(board.getPointOnBoard(i, j) instanceof ElectronHead){
                            zapis.print("<point x=\""+i+"\" y=\""+j+"\"></point>");
                        }
                    }
                 }
                 zapis.println("\n</Head>\n<Tail>");
                  for(int i=0;i<board.getHorizontalSize();i++){
                    for(int j=0;j<board.getVerticalSize();j++){
                        if(board.getPointOnBoard(i, j) instanceof ElectronTail){
                            zapis.print("<point x=\""+i+"\" y=\""+j+"\"></point>");
                        }
                    }
                 }
                 zapis.print("\n</Tail>\n</Points>\n<Objects>");
                 
                 
                 zapis.print("\n</Objects></save>");
                 zapis.close();
         }
         catch(Exception e){
            
        }
        
    }
      public static BoardGame openFile(String FileName){
        
          
          BoardGame board = XMLparser.parser(FileName);
          return board;
    }
    
    
    
}
