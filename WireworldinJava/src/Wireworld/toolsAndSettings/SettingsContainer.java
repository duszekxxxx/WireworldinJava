/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.toolsAndSettings;

import java.awt.Color;
import java.io.File;
import javax.swing.JLabel;
import org.w3c.dom.Document;

/**
 *
 * @author Orion
 */
public class SettingsContainer {

    private int generationCount;
    private int refreshTime;
    private int cellSize;
    private int frameWidth;
    private int distanceBetweenCells;
    private int zoomMajor;
    private int zoomMinor;
    private Color boarderColor;
    private boolean loaded;
    private final String path;

    public SettingsContainer(String path, JLabel jLabelException) {
        this.path = path;
        XMLSettingsFileLoader loader = new XMLSettingsFileLoader(jLabelException, this);
        Document document = loader.getXMLDocument(new File(path));
        if (document != null) {
            loader.xmlRead(document);
        }
    }

    public int getGenerationCount() {
        return generationCount;
    }

    public void setGenerationCount(int generationCount) {
        if (generationCount < 0) {
            throw new IllegalArgumentException("Liczba generacji nie może być mniejsza niż 0!");
        } else {
            this.generationCount = generationCount;
        }

    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        if (refreshTime < 1) {
            throw new IllegalArgumentException("Czas odświerzania nie może być mniejszy niż 1!");
        } else {
            this.refreshTime = refreshTime;
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        if (cellSize < 1) {
            throw new IllegalArgumentException("Wielkość komórek nie może być mniejsza niż 1!");
        } else {
            this.cellSize = cellSize;
        }
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        if (frameWidth < 0) {
            throw new IllegalArgumentException("Szerokość ramki nie może być mniejsza niż 0!");
        } else {
            this.frameWidth = frameWidth;
        }
    }

    public int getDistanceBetweenCells() {
        return distanceBetweenCells;
    }

    public void setDistanceBetweenCells(int distanceBetweenCells) {
        if (distanceBetweenCells < 0) {
            throw new IllegalArgumentException("Odległość między komórkami nie może być mniejszy niż 0!");
        } else {
            this.distanceBetweenCells = distanceBetweenCells;
        }
    }

    public Color getBoarderColor() {
        return boarderColor;
    }

    public void setBoarderColor(Color boarderColor) {
        this.boarderColor = boarderColor;
    }

    public int getZoomMajor() {
        return zoomMajor;
    }

    public void setZoomMajor(int zoomMajor) {
        if (zoomMajor < 10) {
            throw new IllegalArgumentException("Podziałka główna nie może być mniejsza niż 10!");
        } else {
            this.zoomMajor = zoomMajor;
        }
    }

    public int getZoomMinor() {
        return zoomMinor;
    }

    public void setZoomMinor(int zoomMinor) {
        if (zoomMinor < 0) {
            throw new IllegalArgumentException("Wartość podziałki głównej nie może być mniejsza niż 0!");
        } else if (zoomMajor < zoomMinor) {
            throw new IllegalArgumentException("Podziałka pomocnicza nie może być większa niż podziałka główna!");
        } else {
            this.zoomMinor = zoomMinor;
        }
    }

    public String getPath() {
        return path;
    }
}
