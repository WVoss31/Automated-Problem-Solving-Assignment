/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domains.farmer;

import framework.problem.State;
import java.util.Objects;

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
        if (other == null) {return false;}
        else if (!thisState.farmer.equals(this.farmer) || !thisState.wolf.equals(thisState.wolf)
                || !thisState.goat.equals(this.goat) || !thisState.cabbage.equals(this.cabbage)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.farmer);
        hash = 83 * hash + Objects.hashCode(this.wolf);
        hash = 83 * hash + Objects.hashCode(this.goat);
        hash = 83 * hash + Objects.hashCode(this.cabbage);
        return hash;
    }
    
    @Override
    public String toString() {
        String riverString = "   |  |   \n";
        String farmerString = " F |  |   \n";
        String wolfString = " W |  |   \n";
        String goaString = " G |  |   \n";
        String cabString = " C |  |   \n";
        String emptyString = "   |  |   ";
        
        if (farmer.equals("East")) { farmerString = "   |  | F \n"; }
        if (wolf.equals("East")) { wolfString = "   |  | W \n"; }
        if (goat.equals("East")) { goaString = "   |  | G \n"; }
        if (cabbage.equals("East")) { cabString = "   |  | C \n"; }
        return riverString + farmerString + wolfString + goaString + cabString + emptyString;
    }
    
    public final String getFarmer() {
        return farmer;
    }
    
    public final String getWolf() {
        return wolf;
    }
    
    public final String getGoat() {
        return goat;
    }
    
    public final String getCabbage() {
        return cabbage;
    }
    
    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;
    
}
