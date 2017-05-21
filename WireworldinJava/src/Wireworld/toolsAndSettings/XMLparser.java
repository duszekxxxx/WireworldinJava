
package Wireworld.toolsAndSettings;

import Wireworld.Logic.Board;
import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLparser {

    public static BoardGame parser(File file) {
        BoardGame board;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            NodeList nodeHorizontalSize = doc.getElementsByTagName("horizontalSize");
            int horizontalSize = Integer.valueOf(nodeHorizontalSize.item(0).getTextContent());
            NodeList nodeVerticalSize = doc.getElementsByTagName("verticalSize");
            int verticalSize = Integer.valueOf(nodeHorizontalSize.item(0).getTextContent());
            board = new Board(horizontalSize, verticalSize);
            for (int k = 0; k > board.getVerticalSize(); k++) {
                for (int m = 0; m > board.getHorizontalSize(); m++) {
                    board.setPointOnBoard(new EmptyCell(), k, m);
                }
            }
            NodeList Points = doc.getElementsByTagName("Points");
            Node nPoints = Points.item(0);
            NodeList States = nPoints.getChildNodes();
            for (int i = 0; i < States.getLength(); i++) {
                if (States.item(i).getNodeName().contentEquals("Conductor")) {
                    NodeList Point = States.item(i).getChildNodes();
                    for (int j = 0; j < Point.getLength(); j++) {

                        if (Point.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element ePoint = (Element) Point.item(j);
                            int x = Integer.valueOf(ePoint.getAttribute("x"));
                            int y = Integer.valueOf(ePoint.getAttribute("y"));
                            board.setPointOnBoard(new Conductor(), x, y);
                        }
                    }
                }
                if (States.item(i).getNodeName().contentEquals("Head")) {
                    NodeList Point = States.item(i).getChildNodes();
                    for (int j = 0; j < Point.getLength(); j++) {

                        if (Point.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element ePoint = (Element) Point.item(j);
                            int x = Integer.valueOf(ePoint.getAttribute("x"));
                            int y = Integer.valueOf(ePoint.getAttribute("y"));
                            board.setPointOnBoard(new ElectronHead(), x, y);
                        }
                    }
                }
                if (States.item(i).getNodeName().contentEquals("Tail")) {
                    NodeList Point = States.item(i).getChildNodes();
                    for (int j = 0; j < Point.getLength(); j++) {

                        if (Point.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element ePoint = (Element) Point.item(j);
                            int x = Integer.valueOf(ePoint.getAttribute("x"));
                            int y = Integer.valueOf(ePoint.getAttribute("y"));
                            board.setPointOnBoard(new ElectronTail(), x, y);
                        }
                    }
                }
            }
            return board;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLparser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
