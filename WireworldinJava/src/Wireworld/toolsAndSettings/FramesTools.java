/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import static Wireworld.toolsAndSettings.SettingsTools.findColor;
import java.io.File;
import java.util.regex.Pattern;
import javax.swing.JLabel;

/**
 * Klasa ta służy jako klasa pomocnicza zawierająca metody do sprawdzenia
 * poprawności danych
 */
public class FramesTools {

    /**
     * Metoda sprawdza czy podany plik ma prawidłowe rozszerzenie wprowadzane
     * jako jeden z parmetrów
     *
     * @param file uchwyt do pliku
     * @param expectedExt oczekiwane rozszerzenie
     * @param jLabelExceptions etykieta na wyświetlanie błędów
     * @return zwraca wartość prawdy jeśli rozszerzenie jest prawidłowe w
     * przeciwnym wypadku zwraca false
     */
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

    /**
     * Metoda służy do zapisywania ustawień określanych w oknie Settings
     * do struktury settingsConatiner
     *
     * @param settingsContainer kontener do którego mają być zapisane ustawienia
     * @param jLabelException etykieta do której mają być wypisane błędy
     * @param cellSize rozmiar komórki
     * @param distanceBetweenCells odległość między komórkami
     * @param frameWidth szerokość ramki
     * @param boarderColor kolor tła
     * @param zoomMinor powiększenie podziałki pomocniczej
     * @param zoomMajor powiększenie podziałki głównej
     * @return kontener ze zmienioną zawartością
     */
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

    /**
     * *
     * Metoda ustawia pola refershTime i generationCount w settingsContainer
     *
     * @param settingsContainer do którego mają być zapisane ustawienia
     * @param jLabelException etykieta do której mają być wypisane błędy
     * @param generationCount ilość generacji
     * @param refreshTime czas doświeżania wyśwyietlania
     * @return kontener ze zmienioną zawartością
     */
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
