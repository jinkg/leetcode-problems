package com.kinglloy.leetcode;

public class GasStation_134 {
    public static void main(String[] args) {
//        int[] gas = new int[]{4, 5, 2, 6, 5, 3};
//        int[] cost = new int[]{3, 2, 7, 3, 2, 9};
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(new GasStation_134().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int curGas = 0;
        int startPosition = 0;
        for (int i = 0; i < gas.length; i++) {
            int fuel = gas[i] - cost[i];
            totalGas += fuel;
            curGas += fuel;
            if (curGas < 0) {
                curGas = 0;
                startPosition = i + 1;
            }
        }

        return totalGas >= 0 ? startPosition : -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int gasLeft = gas[i];
            int j = (i + 1) % gas.length;
            for (; j != i; j = (j + 1) % gas.length) {
                int cIndex = j - 1 < 0 ? gas.length - 1 : j - 1;
                int co = cost[cIndex];
                if (gasLeft < co) {
                    break;
                }

                gasLeft = gasLeft + gas[j] - co;
            }
            int cIndex = j - 1 < 0 ? gas.length - 1 : j - 1;
            if (j == i && gasLeft >= cost[cIndex]) {
                return i;
            }
        }
        return -1;
    }
}
