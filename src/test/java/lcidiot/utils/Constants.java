package test.java.lcidiot.utils;

public class Constants {

    public static class Matrix {
        public static final int[][] ROW_COLUMN_INTEGRALLY_SORTED = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
                { 23, 30, 34, 50 } };

        public static final int[][] ROW_COLUMN_SEPARATELY_SORTED = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };

        public static final int[][] SHORT = { { 1, 2, 3 } };

        public static final int[][] LEAN = { { 1 }, { 2 }, { 3 } };

        public static final int[][] TINY = { { 1 } };

        public static final int[][] EMPTY = { {} };
    }

    public static class Array {
        public static final int[] NULL = null;
        public static final int[] EMPTY = {};
        public static final int[] RANDOM = new int[] { 2, 3, 1, 2, 4, 3 };

        public static final int[] SINGLE_ELE = new int[] { 1 };
        public static final int[] SINGLE_ELE_WITH_DUPLICATES = new int[] { 1, 1 };

        public static final int[] ROTATED_SORTED = new int[] { 3, 4, 5, 1, 2 };
        public static final int[] ROTATED_SORTED_01 = new int[] { 1, 3 };
        public static final int[] ROTATED_SORTED_02 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        public static final int[] ROTATED_SORTED_03 = new int[] { 3, 1 };
        public static final int[] ROTATED_SORTED_04 = new int[] { 3, 5, 1 };
        public static final int[] ROTATED_SORTED_WITH_DUPLICATES = new int[] { 2, 5, 6, 0, 0, 1, 2 };
        public static final int[] ROTATED_SORTED_WITH_DUPLICATES_01 = new int[] { 3, 1, 1 };
        public static final int[] ROTATED_SORTED_WITH_DUPLICATES_02 = new int[] { 1, 1, 3 };
        public static final int[] ROTATED_SORTED_WITH_DUPLICATES_03 = new int[] { 3, 1, 1, 3 };
        public static final int[] ROTATED_SORTED_WITH_DUPLICATES_04 = new int[] { 1, 1, 1, 1 };
        public static final int[] ROTATED_SORTED_WITH_DUPLICATES_05 = new int[] { 1, 3, 1, 1, 1, 1 };

        public static final int[] SORTED = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        public static final int[] SORTED01 = new int[] { 1, 3, 5 };

    }
}