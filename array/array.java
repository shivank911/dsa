package array;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class array {
    public static void main(String[] args) {
        int arr[] = {13,4,2,2,3,4,1,8,3,7,7,7,1,6,3};
        System.out.println(minimumOperationsToMakeEqual(26,1));
    }

    public static int missingInteger(int[] nums) {
        if(nums.length ==1){
            return nums[0]+1;
        }
        int max = 0;
        int count = 1;
        int max_sum = 0;
        int max_no = nums[0];
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                sum+=nums[i];
                count++;
            }else{
                if(count>max){
                    max = count;
                    max_sum = sum;
                    count = 0;
                    sum = 0;
                }
            }
            max_no = Math.max(max_no,nums[i]);
            set.add(nums[i]);
        }
        max_sum = Math.max(max_sum, sum);
        while(max_sum<=max_no){
            if(set.contains(max_sum)){
                 max_sum++;
            }
            else{
                 return max_sum++;
            }
        }
        return max_sum;
        
    }
    public static int smallestMissing(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= sum + 1) {
                sum += nums[i];
            } else {
                return sum + 1;
            }
        }

        return sum + 1;
    }
    public static int minimumOperationsToMakeEqual(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>(); // int[]: {current, operations}
        Set<Integer> visited = new HashSet<>();

        queue.offer(new int[]{x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] currentPair = queue.poll();
            int current = currentPair[0];
            int operations = currentPair[1];

            if (current == y) {
                return operations;
            }

            // Perform the four allowed operations
            int[] nextValues = {current % 11 == 0?current/11:current, current % 5==0?current/5:current, current - 1, current + 1};

            for (int nextVal : nextValues) {
                if (nextVal!=current && nextVal > 0 && !visited.contains(nextVal)) {
                    visited.add(nextVal);
                    queue.offer(new int[]{nextVal, operations + 1});
                }
            }
        }

        return -1; // If no solution is found
    }
}
