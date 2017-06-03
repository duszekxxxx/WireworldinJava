/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import static Wireworld.toolsAndSettings.SettingsTools.findColor;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Klasa służy do parsowania pliku z ustawieniami
 */
public class XMLSettingsFileLoader {

    private final JLabel jLabelException;
    private final SettingsContainer settingsContainer;

    /**
     * Konstruktor parsera
     *
     * @param jLabelException etykieta do wyświetlania komunikatów
     * @param settingsContainer kontener ustawień
     */
    public XMLSettingsFileLoader(JLabel jLabelException, SettingsContainer settingsContainer) {
        this.jLabelException = jLabelException;
        this.settingsContainer = settingsContainer;
    }

    /**
     * Metoda wczytuje plik do pamięci i zmienia go na instancje klasy Document
     *
     * @param xmlFile uchwyt na plik
     * @return zwraca wczytany plik
     */
    public Document getXMLDocument(File xmlFile) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            jLabelException.setText("Błąd przy wczytywaniu pliku ustawień " + settingsContainer.getPath());
        }
        return document;
    }

    /**
     * Metoda służy do parsowania pliku xml i zapisu do kontenera ustawień
     *
     * @param document dokument z wczytanym plikiem
     */
    public void xmlRead(Document document) {
        NodeList configurationList = document.getElementsByTagName("configuration");
        NodeList visualSettingsList = document.getElementsByTagName("visualSettings");
        if (configurationList.getLength() == 0 || visualSettingsList.getLength() == 0) {
            jLabelException.setText("Nieprawidłowa zawartość pliku ustawień! " + settingsContainer.getPath());
        }
        Element configurationElement = (Element) configurationList.item(0);
        Element visualSettingsElement = (Element) visualSettingsList.item(0);
        parseXMLFileData(configurationElement, visualSettingsElement);
    }

    /**
     * Metoda odpowiedzialna za pobranie danych o określonych tagach z dokumentu
     *
     * @param configurationElement element XML zawierający informacje o głównej
     * konfiguracji
     * @param visualSettingsElement element XML zawierający informacje o
     * konfiguracji wizualnej
     */

    private void parseXMLFileData(Element configurationElement, Element visualSettingsElement) {
        String generationCountText = configurationElement.getElementsByTagName("generationCount").item(0).getTextContent();
        String refreshTimeText = configurationElement.getElementsByTagName("refreshTime").item(0).getTextContent();
        String cellSizeText = visualSettingsElement.getElementsByTagName("cellSize").item(0).getTextContent();
        String frameWidthText = visualSettingsElement.getElementsByTagName("frameWidth").item(0).getTextContent();
        String distanceBetweenCellsText = visualSettingsElement.getElementsByTagName("distanceBetweenCells").item(0).getTextContent();
        String zoomMajorText = visualSettingsElement.getElementsByTagName("zoomMajor").item(0).getTextContent();
        String zoomMinorText = visualSettingsElement.getElementsByTagName("zoomMinor").item(0).getTextContent();
        String boarderColorText = visualSettingsElement.getElementsByTagName("boarderColor").item(0).getTextContent();
        setUpFields(generationCountText, refreshTimeText, cellSizeText, frameWidthText, distanceBetweenCellsText, zoomMajorText, zoomMinorText, boarderColorText);
    }

    /**
     * Metoda zamienia sparsowany tekst na odpowiednie wartości dodawane do
     * kontenera ustawień
     *
     * @param generationCountText ilość generacji
     * @param refreshTimeText czas odświeżania
     * @param cellSizeText rozmiar komórki
     * @param frameWidthText szerokość ramki
     * @param distanceBetweenCellsText odległość między komórkami
     * @param zoomMajorText zoom- podziałka główna
     * @param zoomMinorText zoom - podziałka pomocnicza
     * @param boarderColorText kolor tła planszy
     */
    public void setUpFields(String generationCountText, String refreshTimeText, String cellSizeText,
            String frameWidthText, String distanceBetweenCellsText, String zoomMajorText, String zoomMinorText, String boarderColorText) {
        try {
            settingsContainer.setGenerationCount(Integer.parseInt(generationCountText));
            settingsContainer.setRefreshTime(Integer.parseInt(refreshTimeText));
            settingsContainer.setCellSize(Integer.parseInt(cellSizeText));
            settingsContainer.setFrameWidth(Integer.parseInt(frameWidthText));
            settingsContainer.setDistanceBetweenCells(Integer.parseInt(distanceBetweenCellsText));
            settingsContainer.setZoomMajor(Integer.parseInt(zoomMajorText));
            settingsContainer.setZoomMinor(Integer.parseInt(zoomMinorText));
            settingsContainer.setBoarderColor(findColor(boarderColorText));
            settingsContainer.setLoaded(true);
        } catch (NumberFormatException e) {
            jLabelException.setText("Nieprawidłowa zawartość pliku ustawień " + settingsContainer.getPath());
        } catch (IllegalArgumentException e) {
            jLabelException.setText(e.getMessage() + " " + settingsContainer.getPath());
        }
    }
}
