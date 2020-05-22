/**
 * @author: Leon
 * 
 */
package com.polyg7ot.algorithm.template.search;

public class DemoApp {
    public static void main(String[] args){
        DemoBinarySearch demo = new DemoBinarySearch();

        // hitting the target
        // flooring mid vs ceiling mid
        System.out.println("flooring mid vs ceiling mid");
        // demo.searchLowerTargetWithFlooringMidInOddArr();
        // demo.searchLowerTargetWithCeilingMidInOddArr();
        demo.searchLowerTargetWithFlooringMidInEvenArr();
        demo.searchLowerTargetWithCeilingMidInEvenArr();

        // demo.searchUpperTargetWithFlooringMidInOddArr();
        // demo.searchUpperTargetWithCeilingMidInOddArr();
        // demo.searchUpperTargetWithCeilingMidInEvenArr();
        // demo.searchUpperTargetWithCeilingMidInEvenArr();

        // demo.lowerInBoundMiss();
        // demo.lowerOutBoundMiss();

        // demo.upperTarget();
        // demo.upperTarget2();
        // demo.upperInBoundMiss();
        // demo.upperOutBoundMiss();

        // demo.leftmostTarget();
    }
}