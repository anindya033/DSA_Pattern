package com.crafter.patterns.stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        String str = ")";
        System.out.println("Valid Parantheses longest substring: " + isValid(str));
    }

    public static int isValid(String str) {

        // Convert string to char array for easy iteration
        char[] cArr = str.toCharArray();
        // Stores maximum length of valid parentheses substring
        int ml = 0;
        // Stack to store indices (not characters)
        Stack<Integer> stack = new Stack<>();
        // Push -1 as base index (helps calculate length from start)
        stack.push(-1);
        // Stores current valid substring length
        int length = 0;
        // Traverse the string
        for (int i = 0; i < cArr.length; i++) {

            // If opening bracket → push its index
            if (cArr[i] == '(') {
                stack.push(i);
            } else {
                // Closing bracket → try to match with last '('
                stack.pop();
                // If stack still has elements → valid substring exists
                if (!stack.isEmpty()) {

                    // Length = current index - last unmatched index
                    length = i - stack.peek();

                    // Update maximum length
                    ml = Math.max(length, ml);

                } else {

                    // Stack empty → no valid base
                    // Push current index as new starting boundary
                    stack.push(i);
                }
            }
        }

        // Return the longest valid substring length
        return ml;
    }

}
