/**
 * @author: Leon
 * 
 */
package com.zea7ot.algorithm.summary.search.binary_search;

public class DemoBinarySearch {
    private static final int[] oddArrWithoutDup = new int[]{1,3,4,5,6,7,9};
    private static final int[] evenArrWithoutDup = new int[]{1,3,4,5,6,7,9,10};

    private static final int[] numsWithDuplicates = new int[]{1,3,3,3,3,3,3,3,4,5,6,7,7,7,9,9,9,9,9,9};

    private static final int lowerTarget = 3;
    private static final int upperTarget = 7;

    private static final int lowerInBoundMiss = 2;
    private static final int upperInBoundMiss = 8;

    private static final int lowerOutBoundMiss = 0;
    private static final int upperOutBoundMiss = 11;

    private BinarySearch template;

    public DemoBinarySearch(){
        this.template = new BinarySearch();
    }

    //#region: to search a lower target with (flooring vs ceiling) mid in arrays of (odd vs even) length
    public void searchLowerTargetWithFlooringMidInOddArr(){
        System.out.println();
        System.out.println("******* searchLowerTargetWithFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("lowerTarget:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(oddArrWithoutDup, lowerTarget));
        System.out.println("*******");
    }

    public void searchLowerTargetWithCeilingMidInOddArr(){
        System.out.println();
        System.out.println("******* searchLowerTargetWithCeilingMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("lowerTarget2:");
        System.out.println("result: " + template.binarySearchWithCeilingMid(oddArrWithoutDup, lowerTarget));
        System.out.println("*******");
    }

    public void searchLowerTargetWithFlooringMidInEvenArr(){
        System.out.println();
        System.out.println("******* searchLowerTargetWithFlooringMidInEvenArr *******");
        System.out.println("original length of the array: " + evenArrWithoutDup.length);
        System.out.println("lowerTarget:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(evenArrWithoutDup, lowerTarget));
        System.out.println("*******");
    }

    public void searchLowerTargetWithCeilingMidInEvenArr(){
        System.out.println();
        System.out.println("******* searchLowerTargetWithCeilingMidInOddArr *******");
        System.out.println("original length of the array: " + evenArrWithoutDup.length);
        System.out.println("lowerTarget2:");
        System.out.println("result: " + template.binarySearchWithCeilingMid(evenArrWithoutDup, lowerTarget));
        System.out.println("*******");
    }
    //#endregion

    //#region: to search the upper target with (flooring vs ceiling) mid in arrays of (even vs odd) length
    public void searchUpperTargetWithFlooringMidInOddArr(){
        System.out.println();
        System.out.println("******* searchUpperTargetWithFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("upperTarget2:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(oddArrWithoutDup, upperTarget));
        System.out.println("*******");
    }

    public void searchUpperTargetWithCeilingMidInOddArr(){
        System.out.println();
        System.out.println("******* searchUpperTargetWithCeilingMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("upperTarget:");
        System.out.println("result: " + template.binarySearchWithCeilingMid(oddArrWithoutDup, upperTarget));
        System.out.println("*******");
    }

    public void searchUpperTargetWithFlooringMidInEvenArr(){
        System.out.println();
        System.out.println("******* searchUpperTargetWithFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + evenArrWithoutDup.length);
        System.out.println("upperTarget:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(evenArrWithoutDup, upperTarget));
        System.out.println("*******");
    }

    public void searchUpperTargetWithCeilingMidInEvenArr(){
        System.out.println();
        System.out.println("******* searchUpperTargetWithCeilingMidInOddArr *******");
        System.out.println("original length of the array: " + evenArrWithoutDup.length);
        System.out.println("upperTarget:");
        System.out.println("result: " + template.binarySearchWithCeilingMid(evenArrWithoutDup, upperTarget));
        System.out.println("*******");
    }
    //#endregion


    public void lowerInBoundMissWithFlooringMidInOddArr(){
        System.out.println();
        System.out.println("******* lowerInBoundMissWithFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("lowerInBoundMiss:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(oddArrWithoutDup, lowerInBoundMiss));
        System.out.println("*******");
    }

    public void lowerOutBoundMissWithFlooringMidInOddArr(){
        System.out.println();
        System.out.println("******* lowerOutBoundMissWithFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("lowerOutBoundMiss:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(oddArrWithoutDup, lowerOutBoundMiss));
        System.out.println("*******");
    }

    public void upperInBoundMissWithFlooringMidInOddArr(){
        System.out.println();
        System.out.println("******* upperInBoundMissWithFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("upperInBoundMiss:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(oddArrWithoutDup, upperInBoundMiss));
        System.out.println("*******");
    }

    public void upperOutBoundMissWIthFlooringMidInOddArr(){
        System.out.println();
        System.out.println("******* upperOutBoundMissWIthFlooringMidInOddArr *******");
        System.out.println("original length of the array: " + oddArrWithoutDup.length);
        System.out.println("upperOutBoundMiss:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(oddArrWithoutDup, upperOutBoundMiss));
        System.out.println("*******");
    }



    public void leftmostTarget(){
        System.out.println();
        System.out.println("*******");
        System.out.println("original length of the array: " + numsWithDuplicates.length);
        System.out.println("leftmostTarget:");
        System.out.println("result: " + template.binarySearchWithFlooringMid(numsWithDuplicates, lowerTarget));
        System.out.println("*******");
    }
}