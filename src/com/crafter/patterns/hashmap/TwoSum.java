package com.crafter.patterns.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static void main (String [] args){
        System.out.println("Hello");

        //------------TWO SUM PROBLEM-----------

        List<Integer> list = new ArrayList<>();
        int target = 9;
        list = Arrays.asList(1,2,4,5,6);

        HashMap<Integer, Integer> map = new HashMap<>();
        int extra = 0;
        for(int i = 0; i < list.size(); i++){
            extra = target - list.get(i);
            System.out.println("---------------------------------------------------------");
            System.out.println("Extra: "+extra);
            if(map.containsKey(extra)){
                
                System.out.println("Two sum value found on : "+i+" and "+ map.get(extra)+" index");
                break;
            }
            map.put(list.get(i),i );
            
            System.out.println("MAP : "+map);
        }
        
        

    }
    
}
