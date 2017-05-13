/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.prototypes;

/**
 *
 * @author Orion
 */
public class WWPoint {

    private int x;
    private int y;
    private byte value;

    public WWPoint(int x, int y, byte value){
        this.value=value;
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public byte getValue() {
        return value;
    }

}
