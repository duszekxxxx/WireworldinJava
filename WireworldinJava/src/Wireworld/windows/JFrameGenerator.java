/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.windows;

import Wireworld.Logic.Board;
import Wireworld.generator.CellMouseListener;
import Wireworld.generator.ElementMouseListener;
import static Wireworld.generator.PicValues.CELLSIZE;
import Wireworld.generator.Tools;
import Wireworld.generator.WireWorldManager;
import static Wireworld.windows.JFrameGenerator.setComunicat;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Orion
 */
public class JFrameGenerator extends javax.swing.JFrame {

    public JFrameGenerator(int boardHorizontalSize, int boardVerticalSize) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../wwIcon.png")));
        setListners();
        drawBoard(boardHorizontalSize, boardVerticalSize);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //clearing all if user do sth earlier
        Tools.clearAll();
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
        jButtonNewConductor = new javax.swing.JButton();
        jButtonNewDiode = new javax.swing.JButton();
        jButtonNewRDiode = new javax.swing.JButton();
        jButtonNewGateXOR = new javax.swing.JButton();
        jButtonNewGateOR = new javax.swing.JButton();
        jButtonDeleteElem = new javax.swing.JButton();
        jButtonGenerate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelInformation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WireWorld Generator");
        setPreferredSize(new java.awt.Dimension(720, 400));

        jButtonNewConductor.setText("Przewodnik");
        jButtonNewConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewConductorActionPerformed(evt);
            }
        });

        jButtonNewDiode.setText("Dioda");

        jButtonNewRDiode.setText("Dioda odwrócona");

        jButtonNewGateXOR.setText("Bramka XOR");

        jButtonNewGateOR.setText("Bramka OR");

        jButtonDeleteElem.setText("Usuń");

        jButtonGenerate.setText("Generuj");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNewConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNewDiode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNewRDiode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNewGateXOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNewGateOR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDeleteElem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonNewConductor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewDiode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewRDiode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewGateXOR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNewGateOR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteElem)
                .addGap(39, 39, 39)
                .addComponent(jButtonGenerate)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInformation.setText("a");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInformation)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNewConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNewConductorActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteElem;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonNewConductor;
    private javax.swing.JButton jButtonNewDiode;
    private javax.swing.JButton jButtonNewGateOR;
    private javax.swing.JButton jButtonNewGateXOR;
    private javax.swing.JButton jButtonNewRDiode;
    private static javax.swing.JLabel jLabelInformation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    private void drawBoard(int mapHorizontalSize, int mapVerticalSize) {
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.LINE_AXIS));
        add(jPanel2);
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(mapVerticalSize, mapHorizontalSize, CELLSIZE, CELLSIZE));
        Board board = new Board(mapHorizontalSize, mapVerticalSize);
        board.setEmptyCellsOnBoard();
        // First y, next x - it is caused order of adding labels to Panel
        for (int y = 0; y < mapVerticalSize; y++) {
            for (int x = 0; x < mapHorizontalSize; x++) {
                JLabel pic;
                pic = new JLabel();
                pic.setName(x + "x" + y);
                pic.setIcon(new ImageIcon(getClass().getResource("../pBlank.png")));
                pic.addMouseListener(new CellMouseListener());
                boardPanel.add(pic);
            }
        }
        jPanel2.add(new JScrollPane(boardPanel));
        WireWorldManager.getInstance().setBoard(board);
        jLabelInformation.setText("Wybierz przycisk opisujący element, a następnie umieść element na planszy");

    }

    private void setListners() {

        jButtonNewConductor.addMouseListener(new ElementMouseListener("SingleConductor"));

        jButtonNewDiode.addMouseListener(new ElementMouseListener("NormalDiode"));

        jButtonNewRDiode.addMouseListener(new ElementMouseListener("ReversedDiode"));

        jButtonNewGateXOR.addMouseListener(new ElementMouseListener("GateXOR"));

        jButtonNewGateOR.addMouseListener(new ElementMouseListener("GateOR"));

        jButtonDeleteElem.addActionListener((ActionEvent ae) -> {
            setComunicat("Naciśnij na element, który chcesz usunąć!", true);
            Tools.setDeleteOperation();
        });

        jButtonGenerate.addActionListener((ActionEvent ae) -> {
            setComunicat("", true);
            Tools.setStartCurrent();
            java.awt.EventQueue.invokeLater(() -> {
                new JFrameViewer().setVisible(true);
            });
            setVisible(false);
            dispose();
        });
    }

    public static void setComunicat(String message, boolean isPositive) {
        jLabelInformation.setText(message);
        if (isPositive) {
            jLabelInformation.setForeground(Color.green);
        } else {
            jLabelInformation.setForeground(Color.red);
        }
    }
}
