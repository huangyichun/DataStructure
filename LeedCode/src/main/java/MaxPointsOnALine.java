import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of
 * points that lie on the same straight line.
 */
public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int maxSameLine = 1;
        for (int i = 0; i < points.length; ++i) {
            int theSameLine = 1;
            Map<Double, Integer> slopeMap = new HashMap<>();
            for (int j=0; j < points.length; ++j){
                if (i != j) {
                    double offsetX = points[i].x - points[j].x;
                    double offsetY = points[i].y - points[j].y;
                    if (offsetX == 0 && offsetY == 0) {
                        ++ theSameLine;
                    }else if (offsetX == 0) {
                        int count = slopeMap.containsKey(Double.MAX_VALUE) ?
                            slopeMap.get(Double.MAX_VALUE) : 0;
                        slopeMap.put(Double.MAX_VALUE, count + 1);
                    }else {
                        double slope = offsetY / offsetX;
                        int count = slopeMap.containsKey(slope) ?
                                slopeMap.get(slope) : 0;
                        slopeMap.put(slope, count + 1);
                    }
                }

            }
            for(Map.Entry<Double, Integer> entry : slopeMap.entrySet()){
                if(entry.getValue() + theSameLine > maxSameLine){
                    maxSameLine = entry.getValue() + theSameLine;
                }
            }
            if(theSameLine > maxSameLine){
                maxSameLine = theSameLine;
            }
        }
        return maxSameLine;
    }
}
