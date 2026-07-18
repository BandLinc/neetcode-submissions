class NumArray {

    List<Integer> prefixSum;

    public NumArray(int[] nums) {
        //Store the sum in a list
        prefixSum = new ArrayList <> ();

        int total = 0;

        for (int n : nums) {
            total += n;
            prefixSum.add(total);
        }
        
    }
    
    public int sumRange(int left, int right) {
        
        int rightRange = prefixSum.get(right);
        int leftRange = left > 0 ? prefixSum.get(left-1) : 0;
        return rightRange-leftRange;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */