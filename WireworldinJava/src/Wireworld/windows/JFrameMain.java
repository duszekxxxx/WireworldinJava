/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.windows;

import Wireworld.Logic.BoardGame;
import Wireworld.generator.WireWorldManager;
import Wireworld.toolsAndSettings.FramesTools;
import Wireworld.toolsAndSettings.SettingsContainer;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static Wireworld.toolsAndSettings.FramesTools.checkSettingsFieldsValue;
import static Wireworld.toolsAndSettings.SaveAndOpenGeneration.openFile;
import Wireworld.toolsAndSettings.SettingsManager;
import static Wireworld.toolsAndSettings.SettingsTools.loadSettings;
import static Wireworld.toolsAndSettings.SettingsTools.saveSettings;

/**
 *Klasa odpowiada za okno główne ukazujące się tuż po włączeniu
 */
public class JFrameMain extends javax.swing.JFrame {

    private SettingsContainer settingsContainer;
    /**
     *Konstruktor ładuje usatwienia z pliku i ustawia ikonę programu
     */
    public JFrameMain() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../wwIcon.png")));
        SettingsManager.getInstance().setSettingsContainer("./src/Wireworld/defaultSettings.xml", jLabelCommunicats);
        settingsContainer = SettingsManager.getInstance().getSettingsContainer();
        if (settingsContainer.isLoaded()) {
            setUpFields();
        }
        setUpFileFilters();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserOpenFile = new javax.swing.JFileChooser();
        jOptionPaneAboutProgramInfo = new javax.swing.JOptionPane();
        jFileChooserConfigFile = new javax.swing.JFileChooser();
        jFileChooserConfigFileSaver = new javax.swing.JFileChooser();
        jPanelConfiguration = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldGenerationsCount = new javax.swing.JTextField();
        jTextFieldRefreshTime = new javax.swing.JTextField();
        jPanelButtonsAndComunicats = new javax.swing.JPanel();
        jButtonGenerate = new javax.swing.JButton();
        jButtonLoad = new javax.swing.JButton();
        jLabelCommunicats = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuConfig = new javax.swing.JMenu();
        jMenuItemImportConfig = new javax.swing.JMenuItem();
        jMenuItemExportConfig = new javax.swing.JMenuItem();
        jMenuItemSettings = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenu();

        jFileChooserOpenFile.setDialogTitle("");
        jFileChooserOpenFile.setDragEnabled(true);
        jFileChooserOpenFile.setName(""); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WireWorld");
        setLocationByPlatform(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Konfiguracja");

        jLabel2.setText("Czas odświerzania[ms]");

        jLabel3.setText("Domyślna liczba generacji");

        jTextFieldGenerationsCount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldGenerationsCount.setText("30");

        jTextFieldRefreshTime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRefreshTime.setText("500");

        javax.swing.GroupLayout jPanelConfigurationLayout = new javax.swing.GroupLayout(jPanelConfiguration);
        jPanelConfiguration.setLayout(jPanelConfigurationLayout);
        jPanelConfigurationLayout.setHorizontalGroup(
            jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGenerationsCount)
                            .addComponent(jTextFieldRefreshTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanelConfigurationLayout.setVerticalGroup(
            jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConfigurationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldRefreshTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldGenerationsCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButtonGenerate.setText("Generuj");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jButtonLoad.setText("Wczytaj");
        jButtonLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadActionPerformed(evt);
            }
        });

        jLabelCommunicats.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelCommunicats.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCommunicats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelButtonsAndComunicatsLayout = new javax.swing.GroupLayout(jPanelButtonsAndComunicats);
        jPanelButtonsAndComunicats.setLayout(jPanelButtonsAndComunicatsLayout);
        jPanelButtonsAndComunicatsLayout.setHorizontalGroup(
            jPanelButtonsAndComunicatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsAndComunicatsLayout.createSequentialGroup()
                .addComponent(jButtonGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsAndComunicatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCommunicats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelButtonsAndComunicatsLayout.setVerticalGroup(
            jPanelButtonsAndComunicatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsAndComunicatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCommunicats, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelButtonsAndComunicatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLoad)
                    .addComponent(jButtonGenerate))
                .addGap(36, 36, 36))
        );

        jMenuConfig.setText("Opcje");

        jMenuItemImportConfig.setText("Importuj plik konfiguracyjny");
        jMenuItemImportConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportConfigActionPerformed(evt);
            }
        });
        jMenuConfig.add(jMenuItemImportConfig);

        jMenuItemExportConfig.setText("Eksportuj plik konfiguracyjny");
        jMenuItemExportConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportConfigActionPerformed(evt);
            }
        });
        jMenuConfig.add(jMenuItemExportConfig);

        jMenuItemSettings.setText("Ustawienia wyglądu");
        jMenuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSettingsActionPerformed(evt);
            }
        });
        jMenuConfig.add(jMenuItemSettings);

        jMenuBar.add(jMenuConfig);

        jMenuAbout.setText("O programie");
        jMenuAbout.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenuAboutMenuSelected(evt);
            }
        });
        jMenuBar.add(jMenuAbout);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelButtonsAndComunicats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtonsAndComunicats, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        if (valueChecker() != null) {
            jLabelCommunicats.setText("");
            java.awt.EventQueue.invokeLater(() -> {
                new JFrameGenerateStart().setVisible(true);
            });
        }
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jButtonLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadActionPerformed
        int response = jFileChooserOpenFile.showOpenDialog(this);
        File file = jFileChooserOpenFile.getSelectedFile();
        if (file != null && response == JFileChooser.APPROVE_OPTION) {
            if (FramesTools.checkExtension(file, "xml", jLabelCommunicats)) {
                if (valueChecker() != null) {
                    BoardGame board = openFile(file, jLabelCommunicats);
                    if (board != null) {
                        WireWorldManager.getInstance().setBoard(board);
                        jLabelCommunicats.setText("");
                        java.awt.EventQueue.invokeLater(() -> {
                            new JFrameViewer().setVisible(true);
                        });
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonLoadActionPerformed

    private void jMenuItemImportConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportConfigActionPerformed
        int response = jFileChooserConfigFile.showOpenDialog(this);
        File file = jFileChooserConfigFile.getSelectedFile();
        if (file != null && response == JFileChooser.APPROVE_OPTION) {
            if (FramesTools.checkExtension(file, "xml", jLabelCommunicats)) {
                SettingsContainer newSettings = loadSettings(file.getPath(), jLabelCommunicats);
                if (newSettings != null) {
                    settingsContainer = newSettings;
                    SettingsManager.getInstance().setSettingsContainer(newSettings);
                    setUpFields();
                }
            }
        }
    }//GEN-LAST:event_jMenuItemImportConfigActionPerformed

    private void jMenuAboutMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenuAboutMenuSelected
        ImageIcon icon = new ImageIcon(getClass().getResource("../wwIcon.png"));
        JOptionPane.showMessageDialog(null, "WireWorld\n"
                + "Program wykonany na zajęcia projektowe JIMP2\n"
                + "Autorzy: Zarczuk Paweł, Milewski Patryk",
                "O programie", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_jMenuAboutMenuSelected

    private void jMenuItemExportConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportConfigActionPerformed
        int response = jFileChooserConfigFileSaver.showSaveDialog(this);
        File file = jFileChooserConfigFileSaver.getSelectedFile();
        if (file != null && response == JFileChooser.APPROVE_OPTION) {
            if (FramesTools.checkExtension(file, "xml", jLabelCommunicats) && valueChecker() != null) {
                saveSettings(file, jLabelCommunicats, settingsContainer);
            }
        }
    }//GEN-LAST:event_jMenuItemExportConfigActionPerformed

    private void jMenuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSettingsActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new JFrameSettings().setVisible(true);
        });
    }//GEN-LAST:event_jMenuItemSettingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JFrameMain().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonLoad;
    private javax.swing.JFileChooser jFileChooserConfigFile;
    private javax.swing.JFileChooser jFileChooserConfigFileSaver;
    private javax.swing.JFileChooser jFileChooserOpenFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCommunicats;
    private javax.swing.JMenu jMenuAbout;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuConfig;
    private javax.swing.JMenuItem jMenuItemExportConfig;
    private javax.swing.JMenuItem jMenuItemImportConfig;
    private javax.swing.JMenuItem jMenuItemSettings;
    private javax.swing.JOptionPane jOptionPaneAboutProgramInfo;
    private javax.swing.JPanel jPanelButtonsAndComunicats;
    private javax.swing.JPanel jPanelConfiguration;
    private javax.swing.JTextField jTextFieldGenerationsCount;
    private javax.swing.JTextField jTextFieldRefreshTime;
    // End of variables declaration//GEN-END:variables

    private SettingsContainer valueChecker() {
        String generationCount = jTextFieldGenerationsCount.getText();
        String refreshTime = jTextFieldRefreshTime.getText();
        return checkSettingsFieldsValue(settingsContainer, jLabelCommunicats,
                generationCount, refreshTime);
    }

    private void setUpFields() {
        jTextFieldRefreshTime.setText(settingsContainer.getRefreshTime() + "");
        jTextFieldGenerationsCount.setText(settingsContainer.getGenerationCount() + "");
    }

    private void setUpFileFilters() {
        FileFilter loadFileFilter = new FileNameExtensionFilter("WireWorld", "xml");
        jFileChooserOpenFile.addChoosableFileFilter(loadFileFilter);

        FileFilter configFileFilter = new FileNameExtensionFilter("WireWorld Configuration", "xml");
        jFileChooserConfigFile.addChoosableFileFilter(configFileFilter);
        jFileChooserConfigFileSaver.addChoosableFileFilter(configFileFilter);
    }
}
