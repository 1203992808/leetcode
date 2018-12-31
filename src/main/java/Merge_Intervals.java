/**
 * @author syz
 * @date 2018-12-31 13:41
 */

import javax.swing.event.InternalFrameEvent;
import java.util.*;

/**
 * leetcode 56 合并区间
 * 题目：

 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18]. （Hard）**/
public class Merge_Intervals {
    public static class Interval{
        int start;
        int end;
        Interval() {
            this.start = 0;
            this.end = 0;
        }
        Interval(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static List<Interval> f1 (List<Interval> intervals) {
        LinkedList<Interval> result = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (Interval i : intervals) {
            if (result.isEmpty()|| result.peekLast().end < i.start) {
                result.add(i);
            } else {
                result.peekLast().end = Math.max(result.peekLast().end,i.end);
            }
        }
        return result;
    }
}
