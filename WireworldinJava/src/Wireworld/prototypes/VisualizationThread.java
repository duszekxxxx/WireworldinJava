/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.prototypes;

import javax.swing.JButton;

/**
 *
 * @author Orion
 */
public class VisualizationThread extends Thread {
  /*  private int loopCounter;
    private int generationsCount;
    private JButton jButtonStart;
    private boolean isLoopStart;
    private long refreshTime;
    
    public VisualizationThread(int loopCounter){
        this.loopCounter=loopCounter;
        isLoopStart=false;
    }
    @Override
    public void run() {
        try {
            while (loopCounter < generationsCount && isLoopStart) {
                sleep(refreshTime);
                //Checking isLoopStart again, cause sb could click stop when sleep was carried
                if (isLoopStart) {
                    loopCounter++;
                    refreshVisualization("upper");

                }
            }
            jButtonStart.setText("Start");
        } catch (InterruptedException e) {
            ;//do nothing
        }
    }
*/
}
