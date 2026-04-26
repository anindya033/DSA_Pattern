package com.crafter.patterns.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 11, 14, 26, 38, 54, 69 };
        int target = 11;
        int left = 0;
        int right = arr.length - 1;
        System.out.println(applyBinarySearch(arr, target, left, right));
    }

    private static String applyBinarySearch(int[] arr, int target, int left, int right) {
        // TODO Auto-generated method stub // Base condition
        if (left > right) {
            return "Not Found";
        }
        int mid = (left + right) / 2;
        try {
            if (arr[mid] == target) {
                return "Found";
            } else {
                if (target > arr[mid]) {
                   return applyBinarySearch(arr, target, mid + 1, right);
                } else {
                   return applyBinarySearch(arr, target, left, mid - 1);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return "Not Found";
    }

}
