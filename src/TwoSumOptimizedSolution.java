import java.util.Arrays;
import java.util.HashMap;

public class TwoSumOptimizedSolution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(tracker.containsKey(nums[i])){
                int left = tracker.get(nums[i]);
                return new int[]{left, i};
            } else
                tracker.put(target - nums[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] result1 = twoSum(new int[] {2, 7, 11, 15}, 9);
        int[] result2 = twoSum(new int[] {3, 2, 4}, 6);
        int[] result3 = twoSum(new int[] {3, 3}, 6);
        System.out.println("Result 1 is " + Arrays.toString(result1));
        System.out.println("Result 2 is " + Arrays.toString(result2));
        System.out.println("Result 3 is " + Arrays.toString(result3));
    }
}
