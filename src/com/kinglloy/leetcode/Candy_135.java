package com.kinglloy.leetcode;

public class Candy_135 {
    public static void main(String[] args) {
//        int[] rations = new int[]{1, 2, 3, 5, 4, 3, 2, 1, 4, 3, 2, 1, 3, 2, 1, 1, 2, 3, 4};
        int[] rations = new int[]{1, 3, 4, 5, 2};
        System.out.println(new Candy_135().candy2(rations));
    }

    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;


        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                count[i] = Math.min(1, count[i - 1] - 1);
            } else if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }

        for (int i = 1; i < count.length + 1; i++) {
            if ((i == count.length || count[i] > count[i - 1]) && count[i - 1] < 1) {
                int j = i - 1;
                int abs = 1 - count[i - 1];
                count[j] += abs;
                for (int k = j - 1; k >= 0; k--) {
                    if (ratings[k] >= ratings[k + 1] && count[k] <= count[k + 1]) {
                        count[k] = count[k + 1] + 1;
                    } else {
                        break;
                    }
                }

                for (int k = j + 1; k < count.length; k++) {
                    if (ratings[k] > ratings[k - 1] && count[k] <= count[k - 1]) {
                        count[k] = count[k - 1] + 1;
                    } else {
                        break;
                    }
                }
            }
        }

        int sum = 0;
        for (int i : count) {
            sum += i;
        }
        return sum;
    }

    public int candy2(int[] ratings) {
        int[] count = new int[ratings.length];
        count[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }
        int sum = count[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (i == ratings.length - 2) {
                    count[i] = Math.max(count[i], 2);
                } else {
                    count[i] = Math.max(count[i], count[i + 1] + 1);
                }
            } else {
                count[i] = Math.max(1, count[i]);
            }

            sum += count[i];
        }

        return sum;
    }
}
