package com.crafter.patterns.twopointer;

public class ContainerWithMostWater {
    //Time & Space Complexity
    //Time: O(n)
    //Space: O(1)
    public static void main(String [] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println("Max area: " + maxArea);
    }

    private static int maxArea(int[] height) {
        // TODO Auto-generated method stub
        //Formula for Area ;
        // Area = min(height[left], height[right]) * (right - left)
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(right > left){

            int area = Math.min(height[left], height[right]) * (right - left);

            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
