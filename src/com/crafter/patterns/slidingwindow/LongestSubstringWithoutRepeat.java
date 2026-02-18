package com.crafter.patterns.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String [] args){

        // Input string
        String str = "abcabcdca";

        // Convert string to character array for easier index access
        char [] arr = str.toCharArray();

        // left  -> start of sliding window
        // right -> end of sliding window (expanding pointer)
        int left = 0, right = 0;

        // ml -> stores maximum length found so far
        // Initialize to 0 because window length can never be negative
        int ml = 0;

        // This set represents the CURRENT WINDOW.
        // It always contains UNIQUE characters between left and right.
        Set<Character> set = new HashSet<>();

        /*
         Sliding Window Core Idea:
         
         1. Expand the window by moving 'right'.
         2. If a duplicate character is found,
            shrink the window from the left
            until the duplicate is removed.
         3. After restoring uniqueness,
            calculate window length.
         4. Track maximum length seen so far.
         
         IMPORTANT INVARIANT:
         At any point in time, the set must contain
         only unique characters inside the window.
        */

        while (right < arr.length ){

            /*
             If current character already exists in the set,
             it means the window has a duplicate.
             
             To restore the invariant (unique window),
             keep removing characters from the left
             until the duplicate is gone.
             
             We use 'while' (not 'if') because
             duplicate may not disappear after removing
             just one character.
            */
            while(set.contains(arr[right])){
                set.remove(arr[left]);  // remove leftmost character from window
                left++;                 // shrink window from left
            }

            /*
             Now the window is valid (no duplicates).
             We can safely include current character.
            */
            set.add(arr[right]);

            /*
             Current window size calculation:
             window length = right - left + 1
             
             +1 because both left and right are inclusive.
            */
            int currentLength = (right - left) + 1;

            // Update maximum length found so far
            ml = Math.max(currentLength, ml);

            // Expand window by moving right pointer
            right++;
        }

        // Print the maximum length of substring without repeating characters
        System.out.println(ml);
    }
}
