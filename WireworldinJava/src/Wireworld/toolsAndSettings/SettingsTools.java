/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JLabel;

/**
 * Klasa służy do eksportu ustawień, importu ustawień oraz zmiany nazwy koloru
 * na klase Color i na odwrót
 */
public class SettingsTools {

    /**
     * Metoda służy do zapisu ustawień z kontenera do pliku xml
     *
     * @param file uchwyt na plik
     * @param jLabelException etykieta na wyświetlanie błędów
     * @param settingsContainer kontener z ustawieniami
     */
    public static void saveSettings(File file, JLabel jLabelException, SettingsContainer settingsContainer) {
        try {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println("<?xml version=\"1.0\"?>");
                printWriter.println("<wireWorldConfigFile>");
                printWriter.println("\t<configuration>");
                printWriter.println("\t\t<generationCount>" + settingsContainer.getGenerationCount() + "</generationCount>");
                printWriter.println("\t\t<refreshTime>" + settingsContainer.getRefreshTime() + "</refreshTime>");
                printWriter.println("\t</configuration>");
                printWriter.println("\t<visualSettings>");
                printWriter.println("\t\t<cellSize>" + settingsContainer.getCellSize() + "</cellSize>");
                printWriter.println("\t\t<frameWidth>" + settingsContainer.getFrameWidth() + "</frameWidth>");
                printWriter.println("\t\t<distanceBetweenCells>" + settingsContainer.getDistanceBetweenCells() + "</distanceBetweenCells>");
                printWriter.println("\t\t<zoomMajor>" + settingsContainer.getZoomMajor() + "</zoomMajor>");
                printWriter.println("\t\t<zoomMinor>" + settingsContainer.getZoomMinor() + "</zoomMinor>");
                if (settingsContainer.getBoarderColor() != null) {
                    printWriter.println("\t\t<boarderColor>" + findColorName(settingsContainer.getBoarderColor()) + "</boarderColor>");
                } else {
                    throw new NullPointerException("Color can't be null");
                }
                printWriter.println("\t</visualSettings>");
                printWriter.println("</wireWorldConfigFile>");
                printWriter.close();
            }
            jLabelException.setText("");
        } catch (FileNotFoundException | NullPointerException ex) {
            jLabelException.setText("Błąd zapisywania pliku");
        }
    }

    /**
     * Metoda służy do załadowania ustawień z pliku
     *
     * @param path ścieżka do pliku
     * @param jLabelException etykieta do wyświetlania błędów
     * @return zwraca kontener z ustawieniami, jeżeli operacaj otwarcia się
     * powiedzie
     */
    public static SettingsContainer loadSettings(String path, JLabel jLabelException) {
        SettingsContainer settingsContainer = new SettingsContainer(path, jLabelException);
        if (settingsContainer.isLoaded()) {
            jLabelException.setText("");
            return settingsContainer;
        } else {
            jLabelException.setText("Nie udało się wczytać pliku ustawień!");
            return null;
        }
    }

    /**
     * Metoda zamienia nazwę koloru na instancję klasy Color
     *
     * @param parse nazwa koloru
     * @return instancja klasy Color
     */
    public static Color findColor(String parse) {
        switch (parse) {
            case "Color.GRAY":
                return Color.GRAY;
            case "Color.WHITE":
                return Color.WHITE;
            case "Color.BLACK":
                return Color.BLACK;
            case "Color.GREEN":
                return Color.GREEN;
            default:
                throw new IllegalArgumentException("Ustawienia: Zła wartośc koloru!");
        }
    }

    /**
     * Metoda zamienia instancję klasy Color na nazwę koloru
     *
     * @param color instancja klasy Color
     * @return nazwa koloru
     */
    public static String findColorName(Color color) {
        if (color.equals(Color.GRAY)) {
            return "Color.GRAY";
        } else if (color.equals(Color.WHITE)) {
            return "Color.WHITE";
        } else if (color.equals(Color.BLACK)) {
            return "Color.BLACK";
        } else if (color.equals(Color.GREEN)) {
            return "Color.GRAY";
        } else {
            return null;
        }
    }
}
