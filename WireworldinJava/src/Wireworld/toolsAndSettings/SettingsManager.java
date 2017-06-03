/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import javax.swing.JLabel;

/**
 * Singleton zawierający kontener ustawień SettingsContainer
 */
public class SettingsManager {

    private static SettingsManager ourInstance = null;
    private SettingsContainer settingsContainer;

    /**
     * Konstruktor tworzy nową instancje klasy Settings Manager
     *
     * @return zwraca instancje klasy
     */
    public static synchronized SettingsManager getInstance() {
        if (null == ourInstance) {
            ourInstance = new SettingsManager();
        }
        return ourInstance;
    }

    /**
     * Metoda zwraca kontener ustawień
     *
     * @return zwraca kontener ustawień
     */
    public SettingsContainer getSettingsContainer() {
        return settingsContainer;
    }

    /**
     * Metoda zmienia trzymany w Singletonie kontener na nowy
     *
     * @param newSettings nowy kontener ustawień
     */
    public void setSettingsContainer(SettingsContainer newSettings) {
        this.settingsContainer = newSettings;
    }

    /**
     * Metoda tworzy nowy kontener ustawień z pliku
     *
     * @param path ścieżka do pliku
     * @param jLabelException etykieta do wyświetlania błędów
     */
    public void setSettingsContainer(String path, JLabel jLabelException) {
        this.settingsContainer = new SettingsContainer(path, jLabelException);
    }

}
