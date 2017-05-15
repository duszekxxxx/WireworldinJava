/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import java.awt.Color;
import java.io.File;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class Tools {

    public static boolean checkExtension(File file, String xml, JLabel jLabelExceptions) {
        try {
            String extension = file.getName();
            String[] tmp = extension.split(Pattern.quote("."));
            if (file == null || !tmp[1].equals("xml")) {
                jLabelExceptions.setText("Nieprawidłowy plik");
                return false;
            } else {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            jLabelExceptions.setText("Brak rozszerzenia pliku lub błędna nazwa");
            return false;
        }
    }

    public static SettingsContainer checkSettingsFieldsValue(SettingsContainer settingsContainer, JLabel jLabelException,
            String cellSize, String distanceBetweenCells, String frameWidth, String boarderColor, String zoomMinor, String zoomMajor) {
        int distanceBetweenCellsValue;
        int cellSizeValue;
        int frameWidthValue;
        int zoomMinorValue;
        int zoomMajorValue;
        Color colorBoarderColor;
        try {
            distanceBetweenCellsValue = Integer.parseInt(distanceBetweenCells);
            cellSizeValue = Short.parseShort(cellSize);
            frameWidthValue = Integer.parseInt(frameWidth);
            colorBoarderColor = settingsContainer.findColor(boarderColor);
            zoomMinorValue = Integer.parseInt(zoomMinor);
            zoomMajorValue = Integer.parseInt(zoomMajor);
        } catch (NumberFormatException e) {
            jLabelException.setText("Nieporawne wartości pól. Musisz podać liczby!");
            return null;
        }
        if (distanceBetweenCellsValue < 0) {
            jLabelException.setText("Odległość między komórkami nie może być mniejszy niż 0!");
            return null;
        } else if (cellSizeValue < 1) {
            jLabelException.setText("Wielkość komórek nie może być mniejsza niż 1!");
            return null;
        } else if (frameWidthValue < 0) {
            jLabelException.setText("Szerokość ramki nie może być mniejsza niż 0!");
            return null;
        } else if (zoomMinorValue < 10) {
            jLabelException.setText("Podziałka pomocnicza nie może być mniejsza niż 10!");
            return null;
        } else if (zoomMinorValue > zoomMajorValue) {
            jLabelException.setText("Podziałka pomocnicza nie może być większa niż podziałka główna!");
        } else if (frameWidthValue < 0) {
            jLabelException.setText("Szerokość ramki nie może być mniejsza niż 0!");
            return null;
        }
        settingsContainer.setCellSize(cellSizeValue);
        settingsContainer.setDistanceBetweenCells(distanceBetweenCellsValue);
        settingsContainer.setFrameWidth(frameWidthValue);
        settingsContainer.setBoarderColor(colorBoarderColor);
        settingsContainer.setZoomMajor(zoomMajorValue);
        settingsContainer.setZoomMinor(zoomMinorValue);
        return settingsContainer;
    }

    public static SettingsContainer checkSettingsFieldsValue(SettingsContainer settingsContainer, JLabel jLabelException,
            String generationCount, String refreshTime) {
        int refreshTimeValue;
        int generationCountValue;

        try {
            refreshTimeValue = Integer.parseInt(refreshTime);
            generationCountValue = Integer.parseInt(generationCount);
        } catch (NumberFormatException e) {
            jLabelException.setText("Nieporawne wartości pól. Musisz podać liczby!");
            return null;
        }

        if (refreshTimeValue < 1) {
            jLabelException.setText("Czas odświerzania nie może być mniejszy niż 1!");
            return null;
        } else if (generationCountValue < 0) {
            jLabelException.setText("Liczba generacji nie może być mniejsza niż 0!");
            return null;
        }
        settingsContainer.setRefreshTime(refreshTimeValue);
        settingsContainer.setGenerationCount(generationCountValue);
        return settingsContainer;
    }
}
