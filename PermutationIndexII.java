package grace.shuati;
import java.util.*;

public class PermutationIndexII {
    public long permutationIndexII(int[] A) {
        if (A.length <= 1) {
            return 1;
        }
        long result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            int smallCount = 0;
            int duplicate = 1;
            map.put(A[i], map.get(A[i]) - 1);
            for (int n: map.keySet()) {
                duplicate *= factorial(map.get(n));
            }
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    smallCount++;
                }
            }
            result += smallCount * factorial(A.length - i - 1) / duplicate;
        }
        return result + 1;
    }

    private long factorial (int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }
}
