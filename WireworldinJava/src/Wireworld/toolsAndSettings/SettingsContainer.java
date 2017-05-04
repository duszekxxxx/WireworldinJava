/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolsAndSettings;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.swing.JLabel;

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

    //private 
    public SettingsContainer(String path, JLabel jLabelException) {
        String line;
        loaded = false;
        int counter = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            while ((line = bufferedReader.readLine()) != null) {
                String[] parses = line.split(Pattern.quote(" = "));
                switch (parses[0]) {
                    case "generationCount":
                        generationCount = Integer.parseInt(parses[1]);
                        if (generationCount < 0) {
                            throw new IllegalArgumentException("Field generationCount had to be above 0!");
                        }
                        counter++;
                        break;
                    case "refreshTime":
                        refreshTime = Integer.parseInt(parses[1]);
                        if (refreshTime < 1) {
                            throw new IllegalArgumentException("Field refreshTime had to be above 1!");
                        }
                        counter++;
                        break;
                    case "cellSize":
                        cellSize = Integer.parseInt(parses[1]);
                        if (cellSize < 1) {
                            throw new IllegalArgumentException("Field cellSize had to be above1!");
                        }
                        counter++;
                        break;
                    case "frameWidth":
                        frameWidth = Integer.parseInt(parses[1]);
                        if (frameWidth < 0) {
                            throw new IllegalArgumentException("Field frameWidth had to be above 0!");
                        }
                        counter++;
                        break;
                    case "distanceBetweenCells":
                        distanceBetweenCells = Integer.parseInt(parses[1]);
                        if (distanceBetweenCells < 0) {
                            throw new IllegalArgumentException("Field distanceBetweenCells had to be above 0!");
                        }
                        counter++;
                        break;
                    case "zoomMinor":
                        zoomMinor = Integer.parseInt(parses[1]);
                        if (zoomMinor < 0) {
                            throw new IllegalArgumentException("Field zoomMinor had to be above 0!");
                        }
                        counter++;
                        break;
                    case "zoomMajor":
                        zoomMajor = Integer.parseInt(parses[1]);
                        if (zoomMajor < 10) {
                            throw new IllegalArgumentException("Field zoomMajor had to be above 10!");
                        } else if (zoomMajor < zoomMinor) {
                            throw new IllegalArgumentException("Field zoomMajor had to be greater then zoomMinor!");
                        }
                        counter++;
                        break;
                    case "boarderColor":
                        boarderColor = findColor(parses[1]);
                        counter++;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown value");
                }
            }
            if (counter == 8) {
                loaded = true;
                jLabelException.setText("");
            }
        } catch (IOException | IllegalArgumentException e) {
            jLabelException.setText("Nieprawidłowa zawartość pliku ustawień");
        }
    }

    public SettingsContainer loadSettings(String path, JLabel jLabelException) {
        SettingsContainer settingsContainer = new SettingsContainer(path, jLabelException);
        if (settingsContainer.isLoaded()) {
            return settingsContainer;
        } else {
            return this;
        }
    }

    public void saveSettings(File file, JLabel jLabelException) {
        try {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println("generationCount = " + generationCount);
                printWriter.println("refreshTime = " + refreshTime);
                printWriter.println("cellSize = " + cellSize);
                printWriter.println("frameWidth = " + frameWidth);
                printWriter.println("distanceBetweenCells = " + distanceBetweenCells);
                printWriter.println("zoomMajor = " + zoomMajor);
                printWriter.println("zoomMinor = " + zoomMinor);
                if (boarderColor != null) {
                    printWriter.println("boarderColor = " + findColorName(boarderColor));
                } else {
                    throw new NullPointerException("Color can't be null");
                }
            }
            jLabelException.setText("");
        } catch (FileNotFoundException | NullPointerException ex) {
            jLabelException.setText("Błąd zapisywania pliku");
        }

    }

    public int getGenerationCount() {
        return generationCount;
    }

    public void setGenerationCount(int generationCount) {
        this.generationCount = generationCount;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getDistanceBetweenCells() {
        return distanceBetweenCells;
    }

    public void setDistanceBetweenCells(int distanceBetweenCells) {
        this.distanceBetweenCells = distanceBetweenCells;
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
        this.zoomMajor = zoomMajor;
    }

    public int getZoomMinor() {
        return zoomMinor;
    }

    public void setZoomMinor(int zoomMinor) {
        this.zoomMinor = zoomMinor;
    }

    public Color findColor(String parse) {
        switch (parse) {
            case "Color.GRAY":
                return Color.GRAY;
            case "Color.WHITE":
                return Color.WHITE;
            case "Color.BLACK":
                return Color.BLACK;
            case "Color.GREEN":
                return Color.GREEN;
            default:
                throw new IllegalArgumentException("Wrong color!");
        }
    }

    public String findColorName(Color color) {
        if (color.equals(Color.GRAY)) {
            return "Color.GRAY";
        } else if (color.equals(Color.WHITE)) {
            return "Color.WHITE";
        } else if (color.equals(Color.BLACK)) {
            return "Color.BLACK";
        } else if (color.equals(Color.GREEN)) {
            return "Color.GRAY";
        } else {
            return null;
        }
    }

}
