/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.windows;

import Wireworld.logicConector.LogicOperator;
import Wireworld.Logic.Board;
import Wireworld.Logic.BoardGame;
import Wireworld.Logic.Conductor;
import Wireworld.Logic.ElectronHead;
import Wireworld.Logic.EmptyCell;
import Wireworld.Logic.States;
import Wireworld.generator.WireWorldManager;
import Wireworld.toolsAndSettings.SettingsContainer;
import Wireworld.toolsAndSettings.SettingsManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

/**
 *
 * @author Orion
 */
public class JPanelRealTimeVisualization extends javax.swing.JPanel {

    private int columns;
    private int rows;
    private int generation;
    //private GameLogic logic;
    private LogicOperator logic;
    private int currentCellSize;
    private SettingsContainer settingsContainer;
    private int currentDistanceBetweenCells;
    private int zoom;
    private int currentBoardWidth;
    private JLabel jLabeCommunicats;

    public JPanelRealTimeVisualization() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /*Correct this when it will be conected with logic*/
    public void setUpJPanel(JLabel jLabeCommunicats) {
        Board board = WireWorldManager.getInstance().getBoard();
        SettingsContainer settingsContainer = SettingsManager.getInstance().getSettingsContainer();
        logic = new LogicOperator();
        logic.generate(board, settingsContainer.getGenerationCount());
        this.columns = board.getHorizontalSize();
        this.rows = board.getVerticalSize();
        
        this.settingsContainer = settingsContainer;
        currentCellSize = settingsContainer.getCellSize();
        currentDistanceBetweenCells = settingsContainer.getDistanceBetweenCells();
        this.jLabeCommunicats = jLabeCommunicats;
        currentBoardWidth = settingsContainer.getFrameWidth();
        zoom=100;
        Dimension panelSize = new Dimension(getPanelHeight(), getPanelWidth());
        setPreferredSize(panelSize);
    }

    public void refreshJPanel(int generation) {
        this.generation = generation;
    }

    public void zoom(int zoom) {
        currentCellSize = settingsContainer.getCellSize() * zoom / 100;
        if (settingsContainer.getCellSize() > 0 && currentCellSize == 0) {
            currentCellSize = 1;
        }
        currentDistanceBetweenCells = settingsContainer.getDistanceBetweenCells() * zoom / 100;
        if (settingsContainer.getDistanceBetweenCells() > 0 && currentDistanceBetweenCells == 0) {
            currentDistanceBetweenCells = 1;
        }
        currentBoardWidth = settingsContainer.getFrameWidth() * zoom / 100;
        Dimension newSize = new Dimension(getPanelHeight(), getPanelWidth());
        setPreferredSize(newSize);
        this.zoom = zoom;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (zoom > 0) {
            BoardGame board = logic.getGeneration(generation, jLabeCommunicats);
            Graphics2D g2d = (Graphics2D) g;
            int currentWidth = currentBoardWidth;
            int currentHeight = currentBoardWidth;
            g2d.setColor(settingsContainer.getBoarderColor());
            g2d.fillRect(0, 0, getPanelHeight(), getPanelWidth());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    States value = board.getPointOnBoard(j, i);
                    g2d.setColor(checkCellColor(value));
                    g2d.fillRect(currentHeight, currentWidth, currentCellSize, currentCellSize);
                    currentWidth += currentCellSize + currentDistanceBetweenCells;
                }
                currentHeight += currentCellSize + currentDistanceBetweenCells;
                currentWidth = currentBoardWidth;
            }
        }
    }

    private Color checkCellColor(States value) {
        if (value instanceof EmptyCell) {
            return Color.BLACK;
        } else if (value instanceof Conductor) {
            return Color.YELLOW;
        } else if (value instanceof ElectronHead) {
            return Color.BLUE;
        } else {
            return Color.RED;
        }
    }

    private int getPanelHeight() {
        int result = currentBoardWidth*2;
        result += rows * currentCellSize;
        result += (rows - 1) * +currentDistanceBetweenCells;
        return result;
    }

    private int getPanelWidth() {
        int result = currentBoardWidth*2;
        result += columns * currentCellSize;
        result += (columns - 1) * +currentDistanceBetweenCells;
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
