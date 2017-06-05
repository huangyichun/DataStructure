import org.junit.Assert;
import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/5.
 */
public class TestLeedCode_3 {

    @Test
    public void inputOnePointShouldReturn1(){
        Point[] points = new Point[1];
        Point point = new Point(3, 5);
        points[0] = point;
        LeetCode_3 leedCode_3 = new LeetCode_3();
        int num = leedCode_3.maxPoints(points);
        Assert.assertEquals(num, 1);
    }

    @Test
    public void inputThreePointInSameLineShouldReturn3(){
        Point[] points = new Point[3];
        Point point1 = new Point(3, 5);
        Point point2 = new Point(3, 5);
        Point point3 = new Point(3, 5);
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        LeetCode_3 leedCode_3 = new LeetCode_3();
        int num = leedCode_3.maxPoints(points);
        Assert.assertEquals(num, 3);
    }
}
