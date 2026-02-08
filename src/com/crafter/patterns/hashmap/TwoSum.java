package com.crafter.patterns.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    /*
        TWO SUM – HOW THIS WORKS (Quick Note)

        Goal:
        Find two numbers in the list whose sum equals the target.

        Approach:
        - We iterate through the list once.
        - For each number, we calculate:
            extra = target - currentNumber
        - 'extra' represents the number needed to form the target sum.

        Logic:
        - If 'extra' is already present in the HashMap,
        it means we have seen that number before,
        and together they form the target sum.
        - If not present, we store the current number
        and its index in the map for future checks.

        HashMap usage:
        - Key   -> number from the list
        - Value -> index of that number

        Why this works:
        - HashMap lookup is O(1)
        - Entire solution runs in O(n) time
        - Avoids nested loops (O(n²))

        Example:
        target = 9
        current = 5
        extra = 4
        If 4 is already in the map → pair found
    */
    public static void main(String[] args) {
        System.out.println("Hello");

        // ------------TWO SUM PROBLEM-----------

        List<Integer> list = new ArrayList<>();
        int target = 9;
        list = Arrays.asList(1, 2, 4, 5, 6);

        HashMap<Integer, Integer> map = new HashMap<>();
        int extra = 0;
        for (int i = 0; i < list.size(); i++) {
            extra = target - list.get(i);
            System.out.println("---------------------------------------------------------");
            System.out.println("Extra: " + extra);
            if (map.containsKey(extra)) {

                System.out.println("Two sum value found on : " + i + " and " + map.get(extra) + " index");
                break;
            }
            map.put(list.get(i), i);

            System.out.println("MAP : " + map);
        }

    }



}
