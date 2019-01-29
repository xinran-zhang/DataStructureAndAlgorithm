package grace.shuati;


public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] diff = new int[prices.length];
        diff[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            diff[i] = prices[i] - prices[0];
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < diff.length - 1; j++) {
            for (int k = j + 1; k < diff.length; k++) {
                max = Math.max(diff[k] - diff[j], max);
            }
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }
}
