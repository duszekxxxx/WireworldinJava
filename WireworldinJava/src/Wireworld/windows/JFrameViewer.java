/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.windows;

import Wireworld.Logic.BoardGame;
import Wireworld.toolsAndSettings.SettingsContainer;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Orion
 */
public class JFrameViewer extends javax.swing.JFrame {

    private final int refreshTime;
    private final int generationsCount;

    /**
     * Creates new form JFrameViewer
     *
     * @param settingsContainer
     * @param board
     * @param array
     */
    public JFrameViewer(SettingsContainer settingsContainer, BoardGame board) {
        initComponents();
        refreshTime = settingsContainer.getRefreshTime();
        generationsCount = settingsContainer.getGenerationCount();
        setUpComponents(settingsContainer, board);
        buttonsControler(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelCurrentGeneration = new javax.swing.JLabel();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonStart = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldGoTo = new javax.swing.JTextField();
        jButtonGoTo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonSaveGeneration = new javax.swing.JButton();
        jLabelCommunicats = new javax.swing.JLabel();
        jButtonMayBeMoreGenerations = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jSliderZoom = new javax.swing.JSlider();
        jLabelZoom = new javax.swing.JLabel();
        jScrollPaneWithVisualizationPanel = new javax.swing.JScrollPane();
        jPanelRealTimeVisualization1 = new Wireworld.windows.JPanelRealTimeVisualization();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WireWorld");

        jLabelCurrentGeneration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCurrentGeneration.setText("0");

        jButtonPrevious.setText("<");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generacja");

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Przejdź do generacji");

        jTextFieldGoTo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonGoTo.setText("Przejdź");
        jButtonGoTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGoToActionPerformed(evt);
            }
        });

        jButtonSaveGeneration.setText("Zapisz generację");
        jButtonSaveGeneration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveGenerationActionPerformed(evt);
            }
        });

        jLabelCommunicats.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCommunicats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonMayBeMoreGenerations.setText("More...?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldGoTo)
                    .addComponent(jButtonGoTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jButtonSaveGeneration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCurrentGeneration, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCommunicats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonMayBeMoreGenerations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrevious)
                    .addComponent(jLabelCurrentGeneration)
                    .addComponent(jButtonNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldGoTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGoTo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSaveGeneration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonMayBeMoreGenerations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCommunicats, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSliderZoom.setMajorTickSpacing(25);
        jSliderZoom.setMaximum(500);
        jSliderZoom.setMinorTickSpacing(25);
        jSliderZoom.setSnapToTicks(true);
        jSliderZoom.setValue(100);

        jLabelZoom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelZoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelZoom.setText("Zoom: 100 [%]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelZoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelZoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderZoom, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPaneWithVisualizationPanel.setMaximumSize(null);
        jScrollPaneWithVisualizationPanel.setMinimumSize(null);
        jScrollPaneWithVisualizationPanel.setName(""); // NOI18N

        jPanelRealTimeVisualization1.setPreferredSize(new java.awt.Dimension(1000, 236));

        javax.swing.GroupLayout jPanelRealTimeVisualization1Layout = new javax.swing.GroupLayout(jPanelRealTimeVisualization1);
        jPanelRealTimeVisualization1.setLayout(jPanelRealTimeVisualization1Layout);
        jPanelRealTimeVisualization1Layout.setHorizontalGroup(
            jPanelRealTimeVisualization1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanelRealTimeVisualization1Layout.setVerticalGroup(
            jPanelRealTimeVisualization1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );

        jScrollPaneWithVisualizationPanel.setViewportView(jPanelRealTimeVisualization1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneWithVisualizationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneWithVisualizationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        int currentValue = Integer.parseInt(jLabelCurrentGeneration.getText());
        if (currentValue < generationsCount) {
            refreshVisualization("upper");
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        int currentValue = Integer.parseInt(jLabelCurrentGeneration.getText());
        if (currentValue > 0) {
            refreshVisualization("lower");
        }

    }//GEN-LAST:event_jButtonPreviousActionPerformed
    private int loopCounter = 0;
    private boolean isLoopStart = false;
    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        Thread show;
        show = new Thread() {
            @Override
            public void run() {
                try {
                    loopCounter = Integer.parseInt(jLabelCurrentGeneration.getText());
                    while (loopCounter < generationsCount && isLoopStart) {
                        sleep(refreshTime);
                        //Checking isLoopStart again, cause sb could click stop when sleep was carried
                        if (isLoopStart) {
                            loopCounter++;
                            refreshVisualization("upper");
                            /*if (Thread.interrupted()) {
                            throw new InterruptedException();
                            }*/
                        }
                    }
                    jButtonStart.setText("Start");
                } catch (InterruptedException e) {
                    jLabelCommunicats.setText("Wykonywanie pętli wyświetlania zostało przerwane");
                }
            }
        };
        startButtonChanger(show);
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonGoToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGoToActionPerformed
        try {
            int settedValue = Integer.parseInt(jTextFieldGoTo.getText());
            if (settedValue >= 0 && settedValue <= generationsCount) {
                refreshVisualization(settedValue);
            } else {
                jLabelCommunicats.setText("Niepoprawna wartość!");
            }
        } catch (NumberFormatException e) {
            jLabelCommunicats.setText("Musisz podać liczbę!");
        }
    }//GEN-LAST:event_jButtonGoToActionPerformed

    private void jButtonSaveGenerationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveGenerationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveGenerationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGoTo;
    private javax.swing.JButton jButtonMayBeMoreGenerations;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSaveGeneration;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCommunicats;
    private javax.swing.JLabel jLabelCurrentGeneration;
    private javax.swing.JLabel jLabelZoom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Wireworld.windows.JPanelRealTimeVisualization jPanelRealTimeVisualization1;
    private javax.swing.JScrollPane jScrollPaneWithVisualizationPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSliderZoom;
    private javax.swing.JTextField jTextFieldGoTo;
    // End of variables declaration//GEN-END:variables

    private class sliderActionListner implements javax.swing.event.ChangeListener {

        @Override
        public void stateChanged(ChangeEvent ce) {
            JSlider source = (JSlider) ce.getSource();
            if (!source.getValueIsAdjusting()) {
                int value = (int) source.getValue();
                jLabelZoom.setText("Zoom: " + value + " [%]");
                jPanelRealTimeVisualization1.zoom(value);
                jPanelRealTimeVisualization1.repaint();
                jScrollPaneWithVisualizationPanel.repaint();
            }
        }
    }

    private void refreshVisualization(String change) {
        int generation = Integer.parseInt(jLabelCurrentGeneration.getText());
        switch (change) {
            case "lower":
                generation -= 1;
                break;
            case "upper":
                generation += 1;
                break;
            default:
                generation = 0;
        }
        jLabelCurrentGeneration.setText("" + generation);
        buttonsControler(generation);
        jLabelCommunicats.setText("");
        jPanelRealTimeVisualization1.refreshJPanel(generation);
        jPanelRealTimeVisualization1.repaint();
    }

    private void refreshVisualization(int generation) {
        jLabelCurrentGeneration.setText("" + generation);
        buttonsControler(generation);
        jLabelCommunicats.setText("");
        jPanelRealTimeVisualization1.refreshJPanel(generation);
        jPanelRealTimeVisualization1.repaint();
    }

    private void buttonsControler(int generation) {
        if (generation == generationsCount && jButtonNext.isEnabled()) {
            jButtonNext.setEnabled(false);
            jButtonStart.setEnabled(false);
        } else if (generation != generationsCount && !jButtonNext.isEnabled()) {
            jButtonNext.setEnabled(true);
            jButtonStart.setEnabled(true);
        }
        if (generation == 0 && jButtonPrevious.isEnabled()) {
            jButtonPrevious.setEnabled(false);
        } else if (generation != 0 && !jButtonPrevious.isEnabled()) {
            jButtonPrevious.setEnabled(true);
        }
    }

    private void setUpComponents(SettingsContainer settingsContainer, BoardGame board) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wwIcon.png")));
        jSliderZoom.setMajorTickSpacing(settingsContainer.getZoomMajor());
        jSliderZoom.setMinorTickSpacing(settingsContainer.getZoomMinor());
        jSliderZoom.setPaintTicks(true);
        jSliderZoom.setPaintLabels(true);
        jSliderZoom.addChangeListener(new sliderActionListner());
        jPanelRealTimeVisualization1.setUpJPanel(settingsContainer, board, jLabelCommunicats);
        jScrollPaneWithVisualizationPanel.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        jScrollPaneWithVisualizationPanel.repaint();
        jScrollPaneWithVisualizationPanel.repaint();
    }

    private void startButtonChanger(Thread show) {
        if (jButtonStart.getText().equals("Start")) {
            jButtonStart.setText("Stop");
            isLoopStart = true;
            show.start();
        } else {
            isLoopStart = false;
            show.interrupt(); // I don't know it is good or not - TO DO: read about it
            jButtonStart.setText("Start");
        }
    }
}
