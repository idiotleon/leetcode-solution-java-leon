package com.idiotleon.leetcode.lvl2.lc1618;

public class SolutionApproach0BinarySearch1 {
    public int maxFont(String text, int w, int h, int[] fonts, FakeFontInfo fontInfo) {
        final int N_FONTS = fonts.length;
        int lo = 0, hi = N_FONTS - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int fontSize = fonts[mid];

            if (isPossible(text, w, h, fontSize, fontInfo)) {
                ans = fontSize;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean isPossible(String text, int w, int h, int fontSize, FakeFontInfo fontInfo) {
        int width = 0;

        if (fontInfo.getHeight(fontSize) > h)
            return false;

        for (char ch : text.toCharArray()) {
            width += fontInfo.getWidth(fontSize, ch);

            if (width > w)
                return false;
        }

        return true;
    }
}
