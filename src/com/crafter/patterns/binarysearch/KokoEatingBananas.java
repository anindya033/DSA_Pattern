package com.crafter.patterns.binarysearch;
/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour,
 she chooses some pile of bananas and eats k bananas from that pile.
  If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
*/

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = new int[] { 3, 6, 7, 11 };
        int h = 8;
        int k = 4;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        System.out.println("Minimum speed: " +
                getKokoEatingSpeed(piles, h, 1, max));
    }

    static int getKokoEatingSpeed(int[] piles, int targetHours, int i, int j){

        int left = i;
        int right = j;
        if (left > right) {
            return left; // final answer
        }

        int mid = (left+right)/2;
        int speedOfEating = mid;
        boolean result = canFinish(piles, speedOfEating, targetHours);
        System.out.println("Can finish? " + result);
        if(result){
            return getKokoEatingSpeed(piles,targetHours, left, mid-1);
        }else{
            return getKokoEatingSpeed(piles, targetHours, mid+1, right);
        }
        
    }

    static boolean canFinish(int[] piles, int speedOfEating, int targetHours) {

        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            int bananas = piles[i];
            if (bananas < speedOfEating) {
                totalHours++;
            } else {
                int result = bananas / speedOfEating;
                int pending = bananas % speedOfEating;
                totalHours = totalHours + result;
                if (pending > 0) {
                    totalHours++;
                }

            }
        }
        if (totalHours <= targetHours) {
            return true;
        }
        return false;
    }

}
