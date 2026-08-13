class Solution {
    public int thirdMax(int[] nums) {
        long largest = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largest) {
                third = second;
                second = largest;
                largest = nums[i];
            }
            else if(nums[i] > second && nums[i] != largest) {
                third = second;
                second = nums[i];
            }
            else if(nums[i] > third && nums[i] != second && nums[i] != largest) {
                third = nums[i];
            }
        }

        if(third == Long.MIN_VALUE) {
            return (int)largest;
        }

        return (int)third;
    }
}