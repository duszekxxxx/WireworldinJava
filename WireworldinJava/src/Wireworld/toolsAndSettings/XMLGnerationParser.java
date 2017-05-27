package Wireworld.toolsAndSettings;

import Wireworld.Logic.Board;
import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.ElectronTail;
import Wireworld.Logic.EmptyCell;
import Wireworld.Logic.GameLogic;
import Wireworld.elements.Diode;
import Wireworld.elements.ElementsList;
import Wireworld.elements.GateOR;
import Wireworld.elements.GateXOR;
import Wireworld.elements.SingleConductor;
import Wireworld.generator.WireWorldManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLGnerationParser {

    public static BoardGame board;
    public static Document doc;
    private static ElementsList list;

    /*public static BoardGame parser(File file) {
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
            //loadElements(board);
            
            NodeList Points = doc.getElementsByTagName("point");
            Node nPoints = Points.item(0);
            NodeList States = nPoints.getChildNodes();
            for (int i = 0; i < States.getLength(); i++) {
                if (States.item(i).getNodeName().contentEquals("Element")) {
                    NodeList Point = States.item(i).getChildNodes();
                    for (int j = 0; j < Point.getLength(); j++) {
                        if (Point.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element ePoint = (Element) Point.item(j);
                            int x = Integer.valueOf(ePoint.getAttribute("x"));
                            int y = Integer.valueOf(ePoint.getAttribute("y"));
                            String elemName = ePoint.getAttribute("y");
                            board.setPointOnBoard(new Conductor(), x, y);
                        }
                    }
                } else if (States.item(i).getNodeName().contentEquals("Head")) {
                    NodeList Point = States.item(i).getChildNodes();
                    for (int j = 0; j < Point.getLength(); j++) {
                        if (Point.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element ePoint = (Element) Point.item(j);
                            int x = Integer.valueOf(ePoint.getAttribute("x"));
                            int y = Integer.valueOf(ePoint.getAttribute("y"));
                            board.setPointOnBoard(new ElectronHead(), x, y);
                        }
                    }
                } else if (States.item(i).getNodeName().contentEquals("Tail")) {
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
            Logger.getLogger(XMLGnerationParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/
    public static BoardGame parser(File file, JLabel label) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        list = new ElementsList();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();
            createBoard();
            loadElements();
            loadStates();
            WireWorldManager.getInstance().setLoadedList(list);
            return board;
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            label.setText("Nie udało się wczytać pliku");
        }
        return null;
    }

    private static void loadElements() {
        NodeList diodes = doc.getElementsByTagName("Diode");
        for (int i = 0; i < diodes.getLength(); i++) {
            addDiode((Element) diodes.item(i));
        }
        NodeList gatesXOR = doc.getElementsByTagName("GateXOR");
        for (int i = 0; i < gatesXOR.getLength(); i++) {
            addGateXOR((Element) gatesXOR.item(i));
        }
        NodeList gatesOR = doc.getElementsByTagName("GateOR");
        for (int i = 0; i < gatesOR.getLength(); i++) {
            addGateOR((Element) gatesOR.item(i));
        }
        NodeList singleConductors = doc.getElementsByTagName("SingleConductor");
        for (int i = 0; i < singleConductors.getLength(); i++) {
            addConductor((Element) singleConductors.item(i));
        }
    }

    private static void createBoard() {
        NodeList nodeHorizontalSize = doc.getElementsByTagName("horizontalSize");
        int horizontalSize = Integer.valueOf(nodeHorizontalSize.item(0).getTextContent());
        NodeList nodeVerticalSize = doc.getElementsByTagName("verticalSize");
        int verticalSize = Integer.valueOf(nodeVerticalSize.item(0).getTextContent());
        board = new Board(horizontalSize, verticalSize);
        for (int k = 0; k < board.getHorizontalSize(); k++) {
            for (int m = 0; m < board.getVerticalSize(); m++) {
                board.setPointOnBoard(new EmptyCell(), k, m);
            }
        }
        WireWorldManager.getInstance().setBoard(board);
    }

    private static void addDiode(Element element) {
        int x = Integer.parseInt(element.getAttribute("x"));
        int y = Integer.parseInt(element.getAttribute("y"));
        String type = element.getAttribute("type");
        Diode diode = new Diode(type);
        diode.changePointsStatusOnBoard(x, y, "conductor");
        list.addElement(diode);
    }

    private static void addGateXOR(Element element) {
        int x = Integer.parseInt(element.getAttribute("x"));
        int y = Integer.parseInt(element.getAttribute("y"));
        GateXOR gate = new GateXOR();
        gate.changePointsStatusOnBoard(x, y, "conductor");
        list.addElement(gate);
    }

    private static void addGateOR(Element element) {
        int x = Integer.parseInt(element.getAttribute("x"));
        int y = Integer.parseInt(element.getAttribute("y"));
        GateOR gate = new GateOR();
        gate.changePointsStatusOnBoard(x, y, "conductor");
        list.addElement(gate);
    }

    private static void addConductor(Element element) {
        int x = Integer.parseInt(element.getAttribute("x"));
        int y = Integer.parseInt(element.getAttribute("y"));
        SingleConductor conductor = new SingleConductor();
        conductor.changePointsStatusOnBoard(x, y, "conductor");
        list.addElement(conductor);
    }

    private static void loadStates() {
        /*NodeList points = doc.getElementsByTagName("point");
        for (int i = 0; i < points.getLength(); i++) {
            Element point = (Element) points.item(i);
            int x = Integer.parseInt(point.getAttribute("x"));
            int y = Integer.parseInt(point.getAttribute("y"));
            if()
            board.setPointOnBoard(new Conductor(), x, y);
        }*/
        NodeList Points = doc.getElementsByTagName("Points");
        Node nPoints = Points.item(0);
        NodeList States = nPoints.getChildNodes();
        for (int i = 0; i < States.getLength(); i++) {
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
            } else if (States.item(i).getNodeName().contentEquals("Tail")) {
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
    }

}
