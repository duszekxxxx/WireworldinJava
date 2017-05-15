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
import java.awt.event.ActionEvent;
import javax.swing.*;

public class JFrameGenerator extends JFrame implements PicValues {

    // It should not be public
    private static JButton jButtonDiode;
    private static JButton jButtonStart;
    private static JButton jButtonConductor;
    private static JLabel jLabelInfo;
    private static JButton jButtonDelete;

    public JFrameGenerator(int boardHorizontalSize, int boardVerticalSize) {
        super("Drag and Drop Images"); //Change it later
        drawJFrameElements();
        drawBoard(boardHorizontalSize, boardVerticalSize);
        setLayout(null);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*   public static void main(String[] args) {
        container = new JFrameGenerator(5, 20);
        container.setVisible(true);
    }*/
    private void drawJFrameElements() {

        jButtonConductor = new JButton();
        jButtonConductor.setText("Przewodnik");
        jButtonConductor.setBounds(5, MAP_TOP_Y, 150, 30);
        jButtonConductor.addMouseListener(new ElementMouseListener("SingleConductor"));

        jButtonDiode = new JButton();
        jButtonDiode.setText("Dioda");
        jButtonDiode.setBounds(5, MAP_TOP_Y + 35, 150, 30);
        jButtonDiode.addMouseListener(new ElementMouseListener("Diode"));

        jButtonDelete = new JButton();
        jButtonDelete.setText("Usuń element");
        jButtonDelete.setBounds(5, MAP_TOP_Y + 70, 150, 30);
        jButtonDelete.addActionListener((ActionEvent ae) -> {
            setComunicat("", true);
            Tools.setDeleteOperation();
        });

        jButtonStart = new JButton();
        jButtonStart.setText("Dalej...");
        jButtonStart.setBounds(5, MAP_TOP_Y + 105, 150, 30);
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
        add(jButtonConductor);
        add(jButtonDiode);
        add(jLabelInfo);
        add(jButtonStart);
    }

    private void drawBoard(int mapHorizontalSize, int mapVerticalSize) {
        Board board = new Board(mapHorizontalSize, mapVerticalSize);
        for (int y = 0; y < mapVerticalSize; y++) {
            for (int x = 0; x < mapHorizontalSize; x++) {
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
