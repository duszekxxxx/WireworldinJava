package Wireworld.toolsAndSettings;

import java.awt.Color;
import java.io.File;
import javax.swing.JLabel;
import org.w3c.dom.Document;

/**
 * Klasa służy do przechowywania ustawień gry: ilość generacji, czas
 * odświeżania, rozmair komórki, rozmair ramki, odległość miedzy komórkami,
 * kolor tła planszy, zoom -podziałka główna, zoom - podziałka pomocnicza
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

    /**
     * Konstruktor wywołuje XMLSettingsFileLoader z apomocą którego wyczytuje
     * ustawienia z pliku
     *
     * @param path ścieżka do pliku
     * @param jLabelException etykieta do wyświetlania błędów
     */
    public SettingsContainer(String path, JLabel jLabelException) {
        this.path = path;
        XMLSettingsFileLoader loader = new XMLSettingsFileLoader(jLabelException, this);
        Document document = loader.getXMLDocument(new File(path));
        if (document != null) {
            loader.xmlRead(document);
        }
    }

    /**
     * Metoda zwraca ilośc generacji
     *
     * @return zwraca ilośc generacji
     */
    public int getGenerationCount() {
        return generationCount;
    }

    /**
     * Metoda ustawia ilośc generacji w kontenerze
     *
     * @param generationCount ilośc generacji
     */
    public void setGenerationCount(int generationCount) {
        if (generationCount < 0) {
            throw new IllegalArgumentException("Liczba generacji nie może być mniejsza niż 0!");
        } else {
            this.generationCount = generationCount;
        }

    }

    /**
     * Metoda zwraca czas odświeżania
     *
     * @return zwraca czas odświeżania
     */
    public int getRefreshTime() {
        return refreshTime;
    }

    /**
     * Metoda ustawia ilośc generacji w kontenerze
     *
     * @param refreshTime czas odświeżania
     */
    public void setRefreshTime(int refreshTime) {
        if (refreshTime < 1) {
            throw new IllegalArgumentException("Czas odświerzania nie może być mniejszy niż 1!");
        } else {
            this.refreshTime = refreshTime;
        }
    }

    /**
     * Metoda zwraca rozmiar komórki
     *
     * @return zwraca rozmiar komórki
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     * Metoda ustawia rozmiar komórki w kontenerze
     *
     * @param cellSize rozmiar komórki
     */
    public void setCellSize(int cellSize) {
        if (cellSize < 1) {
            throw new IllegalArgumentException("Wielkość komórek nie może być mniejsza niż 1!");
        } else {
            this.cellSize = cellSize;
        }
    }

    /**
     * Metoda zwraaca wartość oznaczającą czy zostały załadoawne wszystkie
     * ustawienia.
     *
     * @return zwraca true, jeżeli wszytskie ustawienia są załadowane, w
     * przeciwnym wypadku zwraca false
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * Metoda ustawia wartość oznaczającą czy zostały załadoawne wszystkie
     * ustawienia.
     *
     * @param loaded wartość logiczna załadowanych ustawień
     */
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    /**
     * Metoda zwraca szerokość ramki
     *
     * @return zwraca szerokość ramki
     */
    public int getFrameWidth() {
        return frameWidth;
    }

    /**
     * Metoda ustawia szerokość ramki w kontenerze
     *
     * @param frameWidth szerokość ramki
     */
    public void setFrameWidth(int frameWidth) {
        if (frameWidth < 0) {
            throw new IllegalArgumentException("Szerokość ramki nie może być mniejsza niż 0!");
        } else {
            this.frameWidth = frameWidth;
        }
    }

    /**
     * Metoda zwraca odległość między komórkami
     *
     * @return zwraca odległość między komórkami
     */
    public int getDistanceBetweenCells() {
        return distanceBetweenCells;
    }

    /**
     * Metoda ustawia odległość między komórkami w kontenerze
     *
     * @param distanceBetweenCells odległość między komórkami
     */
    public void setDistanceBetweenCells(int distanceBetweenCells) {
        if (distanceBetweenCells < 0) {
            throw new IllegalArgumentException("Odległość między komórkami nie może być mniejszy niż 0!");
        } else {
            this.distanceBetweenCells = distanceBetweenCells;
        }
    }

    /**
     * Metoda zwraca kolor tła
     *
     * @return zwraca kolor tła
     */
    public Color getBoarderColor() {
        return boarderColor;
    }

    /**
     * Metoda ustawia kolor tła w kontenerze
     *
     * @param boarderColor kolor tła
     */
    public void setBoarderColor(Color boarderColor) {
        this.boarderColor = boarderColor;
    }

    /**
     * Metoda zwraca zoom -podziałka główna
     *
     * @return zwraca zoom -podziałka główna
     */
    public int getZoomMajor() {
        return zoomMajor;
    }

    /**
     * Metoda ustawia zoom -podziałka główna w kontenerze
     *
     * @param zoomMajor zoom -podziałka główna
     */
    public void setZoomMajor(int zoomMajor) {
        if (zoomMajor < 10) {
            throw new IllegalArgumentException("Podziałka główna nie może być mniejsza niż 10!");
        } else {
            this.zoomMajor = zoomMajor;
        }
    }

    /**
     * Metoda zwraca zoom -podziałka pomocnicza
     *
     * @return zwraca zoom -podziałka pomocnicza
     */
    public int getZoomMinor() {
        return zoomMinor;
    }

    /**
     * Metoda ustawia zoom -podziałka pomocnicza w kontenerze
     *
     * @param zoomMinor zoom -podziałka pomocnicza
     */
    public void setZoomMinor(int zoomMinor) {
        if (zoomMinor < 0) {
            throw new IllegalArgumentException("Wartość podziałki głównej nie może być mniejsza niż 0!");
        } else if (zoomMajor < zoomMinor) {
            throw new IllegalArgumentException("Podziałka pomocnicza nie może być większa niż podziałka główna!");
        } else {
            this.zoomMinor = zoomMinor;
        }
    }

    /**
     * Metoda zwraca ścieżkę do pliku ustawień
     *
     * @return ścieżkę do pliku ustawień
     */
    public String getPath() {
        return path;
    }
}
