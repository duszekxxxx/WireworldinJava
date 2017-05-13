/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.prototypes;

import java.io.File;
import java.util.Random;

/**
 *
 * @author Orion
 */
public class ExampleGne {

    private File file;
    private WWPointArray[] maps;

    public ExampleGne(File file) {
        this.file = file;
    }

    public ExampleGne(WWPointArray array) {
    }

    public WWPointArray getGeneration(int i) {
        return maps[i];
    }

    public int getColumns() {
        return 10;
    }

    public int getRows() {
        return 10;
    }

    public void generate(int n) {
        n += 1;
        Random rand = new Random();
        maps = new WWPointArray[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new WWPointArray();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < n; j++) {
                maps[j].add(new WWPoint(3, i, (byte) rand.nextInt(3)));
            }
        }
    }
}
