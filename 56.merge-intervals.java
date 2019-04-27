import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (32.17%)
 * Total Accepted:    201.2K
 * Total Submissions: 625.4K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 * 
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals.size() == 0)
            return list;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                int one = a.start;
                int two = b.start;
                return one.compareTo(b.start);
            }
        });
        int head = intervals.get(0).start;
        int tail = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (tail < intervals.get(i).start) {
                list.add(new Interval(head, tail));
                head = intervals.get(i).start;
                tail = intervals.get(i).end;
            } else {
                head = head < intervals.get(i).start ? head : intervals.get(i).start;
                tail = tail > intervals.get(i).end ? tail : intervals.get(i).end;
            }
        }
        list.add(new Interval(head, tail));
        return list;
    }
}
