/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.farmer;

import framework.problem.State;

/**
 *
 * @author walker
 */
public class FarmerState extends State {
    
    public FarmerState(String f, String w, String g, String c) {
        this.farmer = f;
        this.wolf = w;
        this.goat = g;
        this.cabbage = c;
    }
    
    @Override
    public boolean equals(Object other) {
        FarmerState thisState = (FarmerState) other;
        return thisState == other;
    }
    
    @Override
    public String toString() {
        String riverString = "   |  |   \n";
        String farmerString = " F |  |   \n";
        String wolfString = " W |  |   \n";
        String goaString = " G |  |   \n";
        String cabString = " C |  |   \n";
        String emptyString = "   |  |   ";
        
        if (farmer == "East") { farmerString = "   |  | F \n"; }
        if (wolf == "East") { wolfString = "   |  | W \n"; }
        if (goat == "East") { goaString = "   |  | G \n"; }
        if (cabbage == "East") { cabString = "   |  | C \n"; }
        return riverString + farmerString + wolfString + goaString + cabString + emptyString;
    }
    
    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;
    
}
