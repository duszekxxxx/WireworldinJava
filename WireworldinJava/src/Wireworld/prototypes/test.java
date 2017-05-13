/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wireworld.prototypes;

import java.io.File;

/**
 *
 * @author Orion
 */
public class test {
    public static void main(String[] args){
        ExampleGne logic = new ExampleGne(new File("a"));
        logic.generate(10);
        for(int i =0;i<10;i++){
            WWPointArray array=logic.getGeneration(i);
            for(int j=0;j<10;j++){
                for(int k =0;k<10;k++){
                    System.out.print(array.get(j, k));
                }
                System.out.print("\n");
            }
            System.out.print("\n\n\n");
        }
    }
}
