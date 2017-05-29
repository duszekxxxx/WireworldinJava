/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import javax.swing.JLabel;


/**
 *
 * @author Orion
 */
public class SettingsManager {

    private static SettingsManager ourInstance = null;
    private SettingsContainer settingsContainer;

    public static synchronized SettingsManager getInstance() {
        if (null == ourInstance) {
            ourInstance = new SettingsManager();
        }
        return ourInstance;
    }

    public SettingsContainer getSettingsContainer() {
        return settingsContainer;
    }

    public void setSettingsContainer(String path, JLabel jLabelException) {
        this.settingsContainer = new SettingsContainer(path, jLabelException);
    }
    public void setSettingsContainer(SettingsContainer newSettings) {
        this.settingsContainer = newSettings;
    }

}
