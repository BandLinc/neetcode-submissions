class NumArray {

    int [] prefixSum;

    public NumArray(int[] nums) {
        //Store the sum in a list
        prefixSum = new int [nums.length];

        int total = 0;

        for (int i = 0; i<nums.length; i++) {
            total += nums[i];
            prefixSum[i] = total;
        }
        
    }
    
    public int sumRange(int left, int right) {
        
        int rightRange = prefixSum[right];
        int leftRange = left > 0 ? prefixSum[left-1] : 0;
        return rightRange-leftRange;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */