class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int idx = 0;
        int right = nums.length - 1;

        while (idx <= right) {
            if (nums[idx] == 0) {
                int temp = nums[idx];
                nums[idx] = nums[left];
                nums[left] = temp;

                left++;
                idx++;
            } else if (nums[idx] == 1) {
                idx++;
            } else {
                int temp = nums[idx];
                nums[idx] = nums[right];
                nums[right] = temp;

                right--;
            }
        }
    }
}