package grace.shuati;


// maintain 3 pointers
public class SortColorsOnePass {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int leftPointer = 0, rightPointer = nums.length - 1, i = 0;
        while (i <= rightPointer) {
            if (nums[i] == 0) {
                int tmp = nums[leftPointer];
                nums[leftPointer] = nums[i];
                nums[i] = tmp;
                leftPointer++;
                i++;
            }
            else if (nums[i] == 1) {
                i++;
            } else {
                int tmp = nums[rightPointer];
                nums[rightPointer] = nums[i];
                nums[i] = tmp;
                rightPointer--;
            }
        }
    }
}
