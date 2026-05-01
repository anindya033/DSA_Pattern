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

/*
💡 HOW TO THINK (Very Important)

This is NOT a normal binary search on array.

👉 We are NOT searching inside the piles array.
👉 We are searching for the ANSWER (k = eating speed).

--------------------------------------

🧠 Step 1: Understand the goal
We need to find the MINIMUM speed (k) so that Koko can finish all bananas within h hours.

--------------------------------------

🧠 Step 2: Define search range
- Minimum speed = 1 (she must eat at least 1 banana/hour)
- Maximum speed = max pile (finish biggest pile in 1 hour)

So our search space is: [1 → max]

--------------------------------------

🧠 Step 3: Try a middle value (Binary Search)
Pick a speed (mid) and check:
👉 "Can Koko finish all bananas with this speed?"

--------------------------------------

🧠 Step 4: Feasibility check (canFinish)
- Calculate total hours needed if Koko eats at this speed
- If hours <= h → this speed works ✅
- If hours > h → too slow ❌

--------------------------------------

🧠 Step 5: Move search space
- If it works → try smaller speed (to find minimum)
- If not → try bigger speed

--------------------------------------

🧠 Step 6: Final Answer
When search ends, left will point to the minimum valid speed.

--------------------------------------

🔥 Key Idea:
If a speed works, all bigger speeds will also work.
This is why Binary Search is possible (MONOTONIC behavior).
*/