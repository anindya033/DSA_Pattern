package com.crafter.patterns.twopointer;

public class RemoveDuplicateTwoPointer {

    public static void main(String [] args){
        int[] nums = {1, 1, 2};
        int newLength = removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {

        int firstCounter = 0 ;
        int secondCounter =1;

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        for(int i = secondCounter; i < nums.length; i++){

            if(nums[firstCounter] == nums[i]){
                continue;
            } else {
                firstCounter++;
                nums[firstCounter] = nums[i];

            }

        }
        System.out.println("New length: " + (firstCounter + 1));
        return firstCounter + 1;

    }

}
