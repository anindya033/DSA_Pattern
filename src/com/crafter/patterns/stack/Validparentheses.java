package com.crafter.patterns.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Validparentheses {

    public static void main(String[] args) throws Exception {
        String str = "(((";
        boolean isValid = isValidsUsingMap(str);
        System.out.println("Is Valid : " + isValid);
    }

    public static boolean isValidsUsingMap(String str) throws Exception {
        char[] charArr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char c : charArr) {
            // Closing bracket
            if (map.containsKey(c)) {
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();
                if (map.get(c) != top)
                    return false;
            }
            // Opening bracket
            else {
                stack.push(c);
            }
        }

        if (stack.size() > 0) {
            return false;
        }
        return true;
    }

    public static boolean isValid(String str) throws Exception {

        char[] charArr = str.toCharArray();
        if (charArr.length == 0) {
            return false;
        }
        if (charArr.length == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : charArr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // Stack should not be empty
                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return true;
    }

}
