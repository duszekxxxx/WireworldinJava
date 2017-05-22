/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.windows;

import Wireworld.Logic.Board;
import Wireworld.Logic.EmptyCell;
import Wireworld.generator.CellMouseListener;
import Wireworld.generator.ElementMouseListener;
import Wireworld.generator.PicValues;
import Wireworld.generator.Tools;
import Wireworld.generator.WireWorldManager;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Orion
 */
public class JFrameGenerator extends JFrame implements PicValues {

    private JButton jButtonNormalDiode;
    private JButton jButtonReversedDiode;
    private JButton jButtonGateXOR;
    private JButton jButtonGateOR;
    private JButton jButtonStart;
    private JButton jButtonConductor;
    private JButton jButtonDelete;
    private static JLabel jLabelInfo;

    public JFrameGenerator(int boardHorizontalSize, int boardVerticalSize) {
        super("WireWorld Generator");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../wwIcon.png")));
        drawJFrameElements();
        drawBoard(boardHorizontalSize, boardVerticalSize);
        setLayout(null);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void drawJFrameElements() {

        jButtonConductor = new JButton();
        jButtonConductor.setText("Przewodnik");
        jButtonConductor.setBounds(5, MAP_TOP_Y, 150, 30);
        jButtonConductor.addMouseListener(new ElementMouseListener("SingleConductor"));

        jButtonNormalDiode = new JButton();
        jButtonNormalDiode.setText("Dioda");
        jButtonNormalDiode.setBounds(5, MAP_TOP_Y + 35, 150, 30);
        jButtonNormalDiode.addMouseListener(new ElementMouseListener("NormalDiode"));

        jButtonReversedDiode = new JButton();
        jButtonReversedDiode.setText("Dioda Odwrócona");
        jButtonReversedDiode.setBounds(5, MAP_TOP_Y + 70, 150, 30);
        jButtonReversedDiode.addMouseListener(new ElementMouseListener("ReversedDiode"));

        jButtonGateXOR = new JButton();
        jButtonGateXOR.setText("Bramka XOR");
        jButtonGateXOR.setBounds(5, MAP_TOP_Y + 105, 150, 30);
        jButtonGateXOR.addMouseListener(new ElementMouseListener("GateXOR"));

        jButtonGateOR = new JButton();
        jButtonGateOR.setText("Bramka OR");
        jButtonGateOR.setBounds(5, MAP_TOP_Y + 140, 150, 30);
        jButtonGateOR.addMouseListener(new ElementMouseListener("GateOR"));

        jButtonDelete = new JButton();
        jButtonDelete.setText("Usuń element");
        jButtonDelete.setBounds(5, MAP_TOP_Y + 175, 150, 30);
        jButtonDelete.addActionListener((ActionEvent ae) -> {
            setComunicat("Naciśnij na element, który chcesz usunąć!", true);
            Tools.setDeleteOperation();
        });

        jButtonStart = new JButton();
        jButtonStart.setText("Dalej...");
        jButtonStart.setBounds(5, MAP_TOP_Y + 210, 150, 30);
        jButtonStart.addActionListener((ActionEvent ae) -> {
            setComunicat("", true);
            Tools.setStartCurrent();
            java.awt.EventQueue.invokeLater(() -> {
                new JFrameViewer().setVisible(true);
            });
            setVisible(false);
            dispose();
        });

        jLabelInfo = new JLabel();
        jLabelInfo.setBounds(MAP_TOP_X, 5, 600, 15);
        jLabelInfo.setText("Wybierz przycisk opisujący element, a następnie umieść element na planszy");

        add(jButtonDelete);
        add(jButtonStart);
        add(jButtonConductor);
        add(jButtonNormalDiode);
        add(jButtonReversedDiode);
        add(jButtonGateXOR);
        add(jButtonGateOR);
        add(jLabelInfo);

    }

    private void drawBoard(int mapHorizontalSize, int mapVerticalSize) {
        Board board = new Board(mapHorizontalSize, mapVerticalSize);
        for (int x = 0; x < mapHorizontalSize; x++) {
            for (int y = 0; y < mapVerticalSize; y++) {
                JLabel pic;
                pic = new JLabel();
                pic.setName(x + "x" + y);
                pic.setBounds(MAP_TOP_X + (CELLSIZE + CELLSPACE) * x, MAP_TOP_Y + (CELLSIZE + CELLSPACE) * y, CELLSIZE, CELLSIZE);
                board.setPointOnBoard(new EmptyCell(), x, y);
                pic.setIcon(new ImageIcon(getClass().getResource("../pBlank.png")));
                pic.addMouseListener(new CellMouseListener());
                add(pic);
            }
        }
        WireWorldManager.getInstance().setBoard(board);
    }

    public static void setComunicat(String message, boolean isPositive) {
        jLabelInfo.setText(message);
        if (isPositive) {
            jLabelInfo.setForeground(Color.green);
        } else {
            jLabelInfo.setForeground(Color.red);
        }
    }
}
