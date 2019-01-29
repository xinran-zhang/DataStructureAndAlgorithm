package grace.shuati;
// Shuffle a set of numbers without duplicates.


public class Shuffleanarray {
    public int[] nums;

    public Shuffleanarray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */

    // swap the ith element with the element of the randomly generated index
    public int[] shuffle() {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++) rand[i] = nums[i];
        for (int i = 0; i < nums.length; i++){
            int r = (int) (Math.random() * (i+1));
            int tmp = rand[i];
            rand[i] = rand[r];
            rand[r] = tmp;
        }
        return rand;
    }
}
