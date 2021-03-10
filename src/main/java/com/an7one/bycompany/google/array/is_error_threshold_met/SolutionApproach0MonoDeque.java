// /**
//  * 给一个server error rate list，Index表示时间，value是这个时间的 error rate。
//  *  问，给定一个targetTime和threshold，如果存在某个连续的时间段使得：
//  *  lengthOfTheTimePeriod * mininumErrorRateInThePeriod > threshold则return true.
//  *  targetTime必须包含在这个时间段内.
//  */
// package com.zea7ot.by_companies.google.array.is_error_threshold_met;

// // import java.util.ArrayDeque;
// // import java.util.Deque;
// // import java.util.List;

// public class SolutionApproach0MonoDeque {
//     // public boolean isErrorThresholdMet(int targetTime, double threshold,
//     // List<Log> logs) {
//     // // sanity check
//     // if (logs == null || logs.isEmpty())
//     // return false;

//     // final int SIZE = logs.size();

//     // int maxArea = 0;

//     // Deque<Integer> stack = new ArrayDeque<>();
//     // int idx = 0;

//     // while (idx <= SIZE) {
//     // int height = (idx == SIZE) ? 0 : heights[idx];
//     // if (stack.isEmpty() || height >= heights[stack.peek()]) {
//     // stack.push(idx++);
//     // } else {
//     // int top = stack.pop();
//     // maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? idx : idx - 1 -
//     // stack.peek()));
//     // }
//     // }

//     // return maxArea;
//     // }

//     private class Log {
//         private final int TIMESTAMP;
//         private final int ERROR_RATE;

//         private Log(final int TIMESTAMP, final int ERROR_RATE) {
//             this.TIMESTAMP = TIMESTAMP;
//             this.ERROR_RATE = ERROR_RATE;
//         }
//     }
// }
