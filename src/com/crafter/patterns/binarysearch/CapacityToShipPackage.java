package com.crafter.patterns.binarysearch;

public class CapacityToShipPackage {

    public static void main(String[] args) {

        int[] weights = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int targetDays = 5;
        // i th day's weight is weight[i]
        // for 1 index weight = 2

        int maxCapacity = getMaxCapacity(weights);
        System.out.println("maxcapacity : " + maxCapacity);

        int minCapacity = getMinCapacity(weights);
        System.out.println("minCapacity : " + minCapacity);

        int capacity= getCapacityToShip(weights, minCapacity, maxCapacity, targetDays);

       
    }
    private static int getCapacityToShip(int[] weights, int minCapacity, int maxCapacity, int targetDays){

        if(minCapacity > maxCapacity){
            return minCapacity;
        }
        int mid = (maxCapacity + minCapacity)/2;

        boolean result = checkIfValidCapacity(weights, targetDays, mid);

        if(result){
            return getCapacityToShip(weights, minCapacity, mid-1, targetDays);
        }else{
            return getCapacityToShip(weights, mid+1, maxCapacity, targetDays);
        }

        
    }

    private static boolean checkIfValidCapacity(int[] weights, int targetDays, int currentCapacity) {

        // minimum 1 day is always needed
        int actualDays = 1;
    
        // current load of the ship for that day
        int load = 0;
    
        for(int j = 0; j < weights.length; j++){
    
            // check if adding current package exceeds ship capacity
            if((load + weights[j]) > currentCapacity){
    
                // if exceeded, move package to next day
                actualDays++;
    
                // start new day load with current package weight
                // because current package still needs to be shipped
                load = weights[j];
    
            }else{
    
                // if capacity is not exceeded,
                // add current package to today's load
                load += weights[j];
            }
    
        }
    
        // if actual days needed is within targetDays,
        // then this capacity is valid
        if(targetDays >= actualDays ){
            return true;
        }
    
        // otherwise capacity is too small
        return false;
    }
    private static int getMinCapacity(int[] weights) {
        // TODO Auto-generated method stub
        int min = 0;
        for (int i : weights) {
            min = Math.max(min, i);
        }
        return min;
    }

    private static int getMaxCapacity(int[] weights) {
        // TODO Auto-generated method stub
        int max = 0;
        for (int i : weights) {
            max = max + i;
        }
        return max;
    }

}
