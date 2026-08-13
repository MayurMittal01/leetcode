class Solution {
    public int singleNumber(int[] nums) {
        int jaat =0;
        for(int i=0;i<nums.length;i++){
            jaat ^=nums[i];
 }
 return jaat;
    }
}