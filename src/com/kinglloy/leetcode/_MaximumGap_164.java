package com.kinglloy.leetcode;

public class _MaximumGap_164 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9, 1};
        System.out.println(new _MaximumGap_164().maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;


        int mini = nums[0];
        int maxi = nums[0];
        for (int num : nums) {
            if (mini > num) {
                mini = num;
            }
            if (maxi < num) {
                maxi = num;
            }
        }

        int bucketSize = Math.max(1, (maxi - mini) / (nums.length - 1));        // bucket size or capacity
        int bucketNum = (maxi - mini) / bucketSize + 1;                         // number of buckets

        Bucket[] buckets = new Bucket[bucketNum];

        for (int num : nums) {
            int bucketIdx = (num - mini) / bucketSize;                          // locating correct bucket
            if (buckets[bucketIdx] == null) {
                buckets[bucketIdx] = new Bucket();
            }
            buckets[bucketIdx].minVal = Math.min(num, buckets[bucketIdx].minVal);
            buckets[bucketIdx].maxVal = Math.max(num, buckets[bucketIdx].maxVal);
        }

        int prevBucketMax = mini, maxGap = 0;
        for (Bucket bucket : buckets) {
            if (bucket == null)
                continue;

            maxGap = Math.max(maxGap, bucket.minVal - prevBucketMax);
            prevBucketMax = bucket.maxVal;
        }

        return maxGap;
    }

    private static class Bucket {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
    }
}
