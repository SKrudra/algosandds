package skrudra.alads;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i : arr) {
            currSum += i;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println(maxSum);
    }
}
