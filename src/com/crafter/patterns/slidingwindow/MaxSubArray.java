package com.crafter.patterns.slidingwindow;

import java.util.ArrayList;
import java.util.List;
/* Explanation
    Problem:
    Find the maximum sum of any contiguous subarray of size k.

    Pattern Used:
    Fixed Size Sliding Window

    Core Idea:
    Instead of recalculating the sum of every subarray (O(n*k)),
    we maintain a running window sum and slide the window forward.

    Invariant:
    At every step, 'windowSum' represents the sum of exactly k elements.

    How Sliding Works:
    1. First, calculate sum of first k elements.
    2. Then for every new index 'end':
         - Add arr[end]       → new element entering window
         - Subtract arr[end-k] → element leaving window
    3. Update maxSum.

    Why arr[end - k]?
    When window moves right:
        New window ends at 'end'
        Window size is fixed at k
        So the element leaving is exactly k positions behind 'end'

        removedIndex = end - k

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Learning:
    Never recompute window sum.
    Reuse previous computation by removing one element
    and adding one element.
*/

public class MaxSubArray {

    public static void main(String []args){

        int [] arr = {2, 1, 5, 1, 3, 2};
        int k =3;
        getMaxSubArraySumSidingWindow(arr, k);

    }
    public static void getMaxSubArraySumSidingWindow(int [] arr, int k){
        
        if(k > arr.length) return;
        int windowSum = 0;
        // Step 1: Build first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Step 2: Slide the window
        for (int end = k; end < arr.length; end++) {

            windowSum = windowSum 
                        - arr[end - k]   // remove left
                        + arr[end];      // add right

            maxSum = Math.max(maxSum, windowSum);
        }

    }
}
