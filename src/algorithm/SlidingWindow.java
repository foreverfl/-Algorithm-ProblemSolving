package algorithm;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int target = 15;

        int[] subarrayIndices = findSubarraySum(nums, target);

        if (subarrayIndices != null) {
            int start = subarrayIndices[0];
            int end = subarrayIndices[1];
            System.out.println("연속된 부분 배열의 합이 목표값과 일치하는 경우가 있습니다.");
            System.out.println("첫 인덱스: " + start);
            System.out.println("끝 인덱스: " + end);
        } else {
            System.out.println("일치하는 부분 배열을 찾지 못했습니다.");
        }
    }

    public static int[] findSubarraySum(int[] nums, int target) {
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            while (windowSum > target) {
                windowSum -= nums[windowStart];
                windowStart++;
            }

            if (windowSum == target) {
                return new int[]{windowStart, windowEnd};
            }
        }

        return null;
    }
}
