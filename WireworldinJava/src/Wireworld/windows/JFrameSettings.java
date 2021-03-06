package Wireworld.windows;

import java.awt.Toolkit;
import Wireworld.toolsAndSettings.SettingsContainer;
import static Wireworld.toolsAndSettings.FramesTools.checkSettingsFieldsValue;
import Wireworld.toolsAndSettings.SettingsManager;
import static Wireworld.toolsAndSettings.SettingsTools.findColorName;

/**
 * Okno odpowiada za wyświetlanie i zmianę ustawień programu
 */
public class JFrameSettings extends javax.swing.JFrame {

    private final SettingsContainer settingsContainer;

    /**
     * Konstruktor JFrameSettings
     */
    public JFrameSettings() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../wwIcon.png")));
        this.settingsContainer = SettingsManager.getInstance().getSettingsContainer();
        if (settingsContainer.isLoaded()) {
            setUpFields();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSettingsPart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFrameWidth = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDistanceBetweenCells = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCellSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxBoarderColor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldZoomMajor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldZoomMinor = new javax.swing.JTextField();
        jPanelSaveAndValidation = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jLabelException = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WireWorld - Ustawienia wyglądu");
        setLocationByPlatform(true);

        jLabel1.setText("Szerokość ramki[px]");

        jTextFieldFrameWidth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFrameWidth.setText("10");
        jTextFieldFrameWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFrameWidthActionPerformed(evt);
            }
        });

        jLabel2.setText("Odstęp między komórkami[px]");

        jTextFieldDistanceBetweenCells.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDistanceBetweenCells.setText("2");

        jLabel3.setText("Domyślna wielkość komórek[px]");

        jTextFieldCellSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCellSize.setText("20");

        jLabel4.setText("Kolor tła planszy");

        jComboBoxBoarderColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Color.WHITE", "Color.BLACK", "Color.GRAY", "Color.GREEN" }));

        jLabel6.setText("Zoom - podziałka główna");

        jTextFieldZoomMajor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldZoomMajor.setText("50");

        jLabel7.setText("Zoom - podziałka pomocnicza");

        jTextFieldZoomMinor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldZoomMinor.setText("25");

        javax.swing.GroupLayout jPanelSettingsPartLayout = new javax.swing.GroupLayout(jPanelSettingsPart);
        jPanelSettingsPart.setLayout(jPanelSettingsPartLayout);
        jPanelSettingsPartLayout.setHorizontalGroup(
            jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                        .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                                        .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(22, 22, 22))
                                    .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(21, 21, 21)))
                                .addGap(6, 6, 6))
                            .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCellSize)
                            .addComponent(jTextFieldDistanceBetweenCells)
                            .addComponent(jTextFieldFrameWidth)
                            .addComponent(jComboBoxBoarderColor, 0, 163, Short.MAX_VALUE)))
                    .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jTextFieldZoomMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldZoomMinor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelSettingsPartLayout.setVerticalGroup(
            jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSettingsPartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldFrameWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDistanceBetweenCells, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCellSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxBoarderColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldZoomMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSettingsPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldZoomMinor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jButtonSave.setText("Zapisz");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabelException.setForeground(new java.awt.Color(255, 0, 0));
        jLabelException.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelSaveAndValidationLayout = new javax.swing.GroupLayout(jPanelSaveAndValidation);
        jPanelSaveAndValidation.setLayout(jPanelSaveAndValidationLayout);
        jPanelSaveAndValidationLayout.setHorizontalGroup(
            jPanelSaveAndValidationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaveAndValidationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSaveAndValidationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelException, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelSaveAndValidationLayout.setVerticalGroup(
            jPanelSaveAndValidationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSaveAndValidationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelException, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelSettingsPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSaveAndValidation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSettingsPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSaveAndValidation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if (valueChecker() != null) {
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jTextFieldFrameWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFrameWidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFrameWidthActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBoxBoarderColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelException;
    private javax.swing.JPanel jPanelSaveAndValidation;
    private javax.swing.JPanel jPanelSettingsPart;
    private javax.swing.JTextField jTextFieldCellSize;
    private javax.swing.JTextField jTextFieldDistanceBetweenCells;
    private javax.swing.JTextField jTextFieldFrameWidth;
    private javax.swing.JTextField jTextFieldZoomMajor;
    private javax.swing.JTextField jTextFieldZoomMinor;
    // End of variables declaration//GEN-END:variables

    private SettingsContainer valueChecker() {
        String cellSize = jTextFieldCellSize.getText();
        String distanceBetweenCells = jTextFieldDistanceBetweenCells.getText();
        String frameWidth = jTextFieldFrameWidth.getText();
        String boarderColor = jComboBoxBoarderColor.getSelectedItem().toString();
        String zoomMinor = jTextFieldZoomMinor.getText();
        String zoomMajor = jTextFieldZoomMajor.getText();

        return checkSettingsFieldsValue(settingsContainer, jLabelException,
                cellSize, distanceBetweenCells, frameWidth, boarderColor, zoomMinor, zoomMajor);
    }

    private void setUpFields() {
        jTextFieldCellSize.setText(settingsContainer.getCellSize() + "");
        jTextFieldDistanceBetweenCells.setText(settingsContainer.getDistanceBetweenCells() + "");
        jTextFieldFrameWidth.setText(settingsContainer.getFrameWidth() + "");
        jComboBoxBoarderColor.setSelectedItem(findColorName(settingsContainer.getBoarderColor()));
        jTextFieldZoomMajor.setText(settingsContainer.getZoomMajor() + "");
        jTextFieldZoomMinor.setText(settingsContainer.getZoomMinor() + "");
    }
}
