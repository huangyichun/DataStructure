/**
 * 环形路线上有N个加油站，每个加油站有汽油gas[i]，从每个加油站到下一站消耗汽油cost[i]，
 * 问从哪个加油站出发能够回到起始点，如果都不能则返回-1（注意，解是唯一的）。
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || (gas.length != cost.length)) {
            throw new IllegalArgumentException("参数错误");
        }
        int supTotal = 0, conTotal = 0, diff = 0, index = 0;
        for (int i = 0; i < gas.length; ++i) {
            if(diff < 0) {
                index = i;
                diff = gas[i] - cost[i];
            }else {
                diff += gas[i] - cost[i];
            }
           supTotal += gas[i];
           conTotal += cost[i];
        }
        if(supTotal < conTotal)
            return -1;
        return index;
    }
}
