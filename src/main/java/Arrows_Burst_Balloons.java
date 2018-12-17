/**
 * @author syz
 * @date 2018-12-17 20:29
 */

import java.util.Arrays;
import java.util.Comparator;

/****
 * leetcode 452 用最少的箭射击气球
 *
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。

 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

 Example:

 输入:
 [[10,16], [2,8], [1,6], [7,12]]

 输出:
 2

 解释:
 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 *
 * ***/
public class Arrows_Burst_Balloons {
    public static class Point{
        int first;
        int second;
        public Point(){

        }
        public Point(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int f1(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                return o1.first - o2.first;
            }
        });
        int shoot_begin = points[0].first;
        int shoot_end = points[0].second;
        int shoot_num = 1;
        for (int i = 1; i < points.length ; i++) {
            if (points[i].first <= shoot_end) {
                shoot_begin = points[i].first;
                if (shoot_end > points[i].second) {
                    shoot_begin = points[i].second;
                }
            } else {
                shoot_num++;
                shoot_begin = points[i].first;
                shoot_end = points[i].second;
            }

        }
        return shoot_num;
    }

    public static void main(String[] args) {
        Point p1 = new Point(10,16);
        Point p2 = new Point(2,8);
        Point p3 = new Point(1,6);
        Point p4 = new Point(7,12);
        Point[] points = {p1,p2,p3,p4};
        System.out.println(f1(points));
    }
}
