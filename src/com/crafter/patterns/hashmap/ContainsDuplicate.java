package com.crafter.patterns.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        checkDuplicate();
    }

    public static boolean checkDuplicate() {
        Set<Integer> seen = new HashSet<>();
        List<Integer> arr = Arrays.asList(1, 2, 3, 1);

        for (int num : arr) {
            if (!seen.add(num)) {
                System.out.println("Contains duplicate");
                return true;
            }
        }
        System.out.println("Doesn't contain duplicate");
        return false;
    }
}
