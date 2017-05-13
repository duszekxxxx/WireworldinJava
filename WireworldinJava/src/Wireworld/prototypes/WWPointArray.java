/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.prototypes;

import java.awt.List;
import java.util.ArrayList;
import Wireworld.prototypes.WWPoint;
/**
 *
 * @author Orion
 */
public class WWPointArray {
    private ArrayList<WWPoint> list;

    public WWPointArray() {
        list = new ArrayList<WWPoint>();
    }
    public void add(WWPoint point){
        list.add(point);
    }
    public byte get(int x, int y){
        for(int i =0;i<list.size();i++){
            if(list.get(i).getX()==x && list.get(i).getY()==y)
                return list.get(i).getValue();
        }
        return 5;
    }
}
