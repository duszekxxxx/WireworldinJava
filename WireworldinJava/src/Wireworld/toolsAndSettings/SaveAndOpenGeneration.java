package Wireworld.toolsAndSettings;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.elements.Element;
import Wireworld.elements.ElementsListInterface;
import Wireworld.generator.WireWorldManager;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;

public class SaveAndOpenGeneration {

    public static void saveToFile(File file, BoardGame board) {

        try (PrintWriter zapis = new PrintWriter(file)) {
            zapis.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                    + "<save>\n"
                    + "\t<horizontalSize>" + board.getHorizontalSize() + "</horizontalSize>\n"
                    + "\t<verticalSize>" + board.getVerticalSize() + "</verticalSize>\n"
                    + "\t<Elements>\n");
            zapis.append(loadElements());
            zapis.println("\t</Elements>\n\t<Head>");
            for (int i = 0; i < board.getHorizontalSize(); i++) {
                for (int j = 0; j < board.getVerticalSize(); j++) {
                    if (board.getPointOnBoard(i, j) instanceof ElectronHead) {
                        zapis.print("\t\t<point x=\"" + i + "\" y=\"" + j + "\"></point>\n");
                    }
                }
            }
            zapis.println("\n\t</Head>\n\t<Tail>");
            for (int i = 0; i < board.getHorizontalSize(); i++) {
                for (int j = 0; j < board.getVerticalSize(); j++) {
                    if (board.getPointOnBoard(i, j) instanceof ElectronTail) {
                        zapis.print("\t\t<point x=\"" + i + "\" y=\"" + j + "\"></point>\n");
                    }
                }
            }
            zapis.print("\n\t</Tail>");
            zapis.print("\n</save>");
            zapis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static BoardGame openFile(File file) {
        BoardGame board = XMLparser.parser(file);
        return board;
    }

    private static String loadElements() {
        StringBuilder sb = new StringBuilder();
        Iterator it = (WireWorldManager.getInstance().getElementsList()).getIterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String[] name = (e.getType()).split("\\s+");
            if (name.length > 1) {
                sb.append("\t\t<").append(name[1]).append(">\n");
            } else {
                sb.append("\t\t<").append(name[0]).append(">\n");
            }
            sb.append("\t\t\t<x>").append(e.getPositionX()).append("</x>\n");
            sb.append("\t\t\t<y>").append(e.getPositionY()).append("</y>\n");
            if (name.length > 1) {
                sb.append("\t\t\t<type>").append(name[0]).append("</type>\n");
                sb.append("\t\t</").append(name[1]).append(">\n");
            } else {
                sb.append("\t\t</").append(name[0]).append(">\n");
            }

        }
        return sb.toString();
    }
}
