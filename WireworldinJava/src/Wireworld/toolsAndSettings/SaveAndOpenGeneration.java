package Wireworld.toolsAndSettings;

import Wireworld.Logic.BoardGame;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.elements.Element;
import Wireworld.generator.WireWorldManager;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.swing.JLabel;

public class SaveAndOpenGeneration {

    public static void saveToFile(File file, BoardGame board, JLabel label) {

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                    + "<Save>\n"
                    + "\t<horizontalSize>" + board.getHorizontalSize() + "</horizontalSize>\n"
                    + "\t<verticalSize>" + board.getVerticalSize() + "</verticalSize>\n"
                    + "\t<Elements>\n");
            pw.print(loadElements());
            pw.println("\t</Elements>");
            pw.println("\t<Points>");
            pw.println("\t\t<Head>");
            for (int i = 0; i < board.getHorizontalSize(); i++) {
                for (int j = 0; j < board.getVerticalSize(); j++) {
                    if (board.getPointOnBoard(i, j) instanceof ElectronHead) {
                        pw.print("\t\t\t<point x=\"" + i + "\" y=\"" + j + "\"></point>\n");
                    }
                }
            }
            pw.println("\t\t</Head>\n\t\t<Tail>");
            for (int i = 0; i < board.getHorizontalSize(); i++) {
                for (int j = 0; j < board.getVerticalSize(); j++) {
                    if (board.getPointOnBoard(i, j) instanceof ElectronTail) {
                        pw.print("\t\t\t<point x=\"" + i + "\" y=\"" + j + "\"></point>\n");
                    }
                }
            }
            pw.print("\t\t</Tail>");
            pw.print("\n\t</Points>");
            pw.print("\n</Save>");
            pw.close();
        } catch (Exception e) {
            label.setText("Nie udało się zapisać pliku");
        }

    }

    public static BoardGame openFile(File file, JLabel label) {
        return XMLGnerationParser.parser(file, label);
    }

    private static String loadElements() {
        StringBuilder sb = new StringBuilder();
        Iterator it = (WireWorldManager.getInstance().getElementsList()).getIterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            String[] name = (e.getType()).split("\\s+");
            if (name.length > 1) {
                sb.append("\t\t<").append(name[1]).append(" type = \"").append(name[0]).append("\"");
            } else {
                sb.append("\t\t<").append(name[0]);
            }
            sb.append(" x = \"").append(e.getPositionX()).append("\"");
            sb.append(" y = \"").append(e.getPositionY()).append("\"");
            sb.append(">");
            if (name.length > 1) {
                sb.append("</").append(name[1]).append(">\n");
            } else {
                sb.append("</").append(name[0]).append(">\n");
            }
        }
        return sb.toString();
    }
}
