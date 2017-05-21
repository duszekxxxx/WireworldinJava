/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import static Wireworld.toolsAndSettings.SettingsTools.findColor;
import java.awt.Color;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class FramesTools {

    public static boolean checkExtension(File file, String expectedExt, JLabel jLabelExceptions) {
        try {
            String extension = file.getName();
            String[] tmp = extension.split(Pattern.quote("."));
            if (file == null || !tmp[1].equals(expectedExt)) {
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

        try {
            settingsContainer.setCellSize(Short.parseShort(cellSize));
            settingsContainer.setDistanceBetweenCells(Integer.parseInt(distanceBetweenCells));
            settingsContainer.setFrameWidth(Integer.parseInt(frameWidth));
            settingsContainer.setBoarderColor(findColor(boarderColor));
            settingsContainer.setZoomMajor(Integer.parseInt(zoomMajor));
            settingsContainer.setZoomMinor(Integer.parseInt(zoomMinor));
        } catch (NumberFormatException e) {
            jLabelException.setText("Nieporawne wartości pól. Musisz podać liczby!");
            return null;
        } catch (IllegalArgumentException e) {
            jLabelException.setText(e.getMessage());
            return null;
        }
        return settingsContainer;
    }

    public static SettingsContainer checkSettingsFieldsValue(SettingsContainer settingsContainer, JLabel jLabelException,
            String generationCount, String refreshTime) {

        try {
            settingsContainer.setRefreshTime(Integer.parseInt(refreshTime));
            settingsContainer.setGenerationCount(Integer.parseInt(generationCount));
        } catch (NumberFormatException e) {
            jLabelException.setText("Nieporawne wartości pól. Musisz podać liczby!");
            return null;
        } catch (IllegalArgumentException e) {
            jLabelException.setText(e.getMessage());
            return null;
        }
        return settingsContainer;
    }
}
