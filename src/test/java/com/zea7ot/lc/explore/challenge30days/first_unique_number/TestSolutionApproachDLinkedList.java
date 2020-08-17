package com.zea7ot.lc.explore.challenge30days.first_unique_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolutionApproachDLinkedList {
    @Test
    void testExample1() {
        SolutionApproachDLinkedList solution = new SolutionApproachDLinkedList(new int[] { 2, 3, 5 });
        solution.add(3);
        assertEquals(2, solution.showFirstUnique());

        solution.add(2);
        assertEquals(5, solution.showFirstUnique());

        solution.add(5);
        assertEquals(-1, solution.showFirstUnique());
    }

    @Test
    void testExample2() {
        SolutionApproachDLinkedList solution = new SolutionApproachDLinkedList(new int[] { 7, 7, 7, 7, 7, 7 });
        assertEquals(-1, solution.showFirstUnique());

        solution.add(3);
        solution.add(3);
        solution.add(7);
        solution.add(17);
        assertEquals(17, solution.showFirstUnique());
    }

    @Test
    void testExample13() {
        SolutionApproachDLinkedList solution = new SolutionApproachDLinkedList(new int[] { 70, 80, 434, 460, 432, 473,
                165, 251, 941, 21, 867, 311, 973, 739, 723, 309, 254, 738, 450, 531, 258, 72, 174, 331, 761, 211, 413,
                302, 752, 552, 28, 693, 879, 878, 703, 907, 676, 653, 584, 430, 21, 486, 738, 975, 564, 945, 529, 643,
                83, 103, 183, 915, 180, 381, 505, 322, 317, 435, 583, 472, 714, 114, 761, 623, 340, 916, 2, 570, 419,
                826, 965, 461, 85, 460, 260, 80, 659, 900, 993, 72, 732, 643, 85, 261, 295, 609, 569, 835, 684, 496,
                729, 220, 724, 721, 566, 885, 584, 256, 581, 828, 184, 194, 990, 861, 966, 309, 552, 766, 601, 706, 162,
                108, 143, 755, 809, 84, 913, 306, 802, 532, 223, 434, 869, 266, 37, 283, 966, 179, 506, 284, 591, 541,
                902, 823, 309, 897, 143, 661, 256, 143, 839, 924, 352, 606, 732, 638, 348, 331, 265, 265, 601, 731, 791,
                72 });
        solution.add(274);
        solution.add(386);
        assertEquals(70, solution.showFirstUnique());
    }
}