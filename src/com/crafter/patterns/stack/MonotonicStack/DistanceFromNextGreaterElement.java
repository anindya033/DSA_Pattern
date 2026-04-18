package com.crafter.patterns.stack.MonotonicStack;

import java.util.Stack;

public class DistanceFromNextGreaterElement {

    public static void main(String [] args){

        int [] temperatures = new int [] {73,74,75,71,69,72,76,73};
        int [] returnArr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i < temperatures.length; i++){
            while((!stack.isEmpty()) && temperatures[i] > temperatures[stack.peek()]){
                int pop = stack.pop();
                int diff = i - pop;
                returnArr[pop] = diff;
                //top = stack.peek();
            }
            stack.push(i);
        }
        for(int idx : returnArr){
            System.out.println(idx);
        }
    }

}
