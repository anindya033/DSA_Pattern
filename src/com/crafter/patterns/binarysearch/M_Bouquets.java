package com.crafter.patterns.binarysearch;

public class M_Bouquets {

    public static void main(String[] args) {

        int[] bloomDay = new int[] { 1, 10, 3, 10, 2 };

        // total bouquets needed
        int mBouquet = 2;

        // flowers needed for each bouquet
        int numberOfFlower = 2;

        int answer = getMinimumDays(bloomDay, mBouquet, numberOfFlower);

        System.out.println("Minimum days : " + answer);
    }

    private static int getMinimumDays(int[] bloomDay,
                                      int mBouquet,
                                      int numberOfFlower){

        // total flowers needed
        int totalFlowerNeeded = mBouquet * numberOfFlower;

        // if flowers needed is greater than available flowers,
        // bouquet creation is impossible
        if(totalFlowerNeeded > bloomDay.length){
            return -1;
        }

        // minimum possible day
        int minDay = Integer.MAX_VALUE;

        // maximum possible day
        int maxDay = Integer.MIN_VALUE;

        // find search space
        for(int day : bloomDay){
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        return searchMinimumDays(bloomDay,
                mBouquet,
                numberOfFlower,
                minDay,
                maxDay);
    }

    private static int searchMinimumDays(int[] bloomDay,
                                         int mBouquet,
                                         int numberOfFlower,
                                         int minDay,
                                         int maxDay){

        // when search space ends,
        // minDay points to minimum valid answer
        if(minDay > maxDay){
            return minDay;
        }

        // middle day to check
        int mid = (minDay + maxDay) / 2;

        // check if bouquet can be created on mid day
        boolean result = canMakeBouquets(
                bloomDay,
                mBouquet,
                numberOfFlower,
                mid
        );

        if(result){

            // if bouquet can be created,
            // try finding smaller valid day
            return searchMinimumDays(
                    bloomDay,
                    mBouquet,
                    numberOfFlower,
                    minDay,
                    mid - 1
            );

        }else{

            // if bouquet cannot be created,
            // need more days
            return searchMinimumDays(
                    bloomDay,
                    mBouquet,
                    numberOfFlower,
                    mid + 1,
                    maxDay
            );
        }
    }

    private static boolean canMakeBouquets(int[] bloomDay,
                                           int mBouquet,
                                           int numberOfFlower,
                                           int givenDay) {

        int currentBouquet = 0;
        int currentFlower = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            // check if flower is bloomed on given day
            if(givenDay >= bloomDay[i]){

                // pick flower and increase count
                currentFlower++;

                // if enough flowers collected,
                // create bouquet and reset flower count
                if(currentFlower == numberOfFlower){
                    currentBouquet++;
                    currentFlower = 0;
                }

            }else{

                // sequence breaks if flower is not bloomed
                currentFlower = 0;
            }
        }

        // if required bouquets can be created,
        // then given day is valid
        if(currentBouquet >= mBouquet){
            return true;
        }

        return false;
    }
}