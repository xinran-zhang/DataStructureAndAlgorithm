package grace.shuati;
import java.util.*;

public class PermutationIndex {
    public long permutationIndex(int[] A) {
        if (A.length <= 1) {
            return 1;
        }
        long result = 0;
        for (int i = 0; i < A.length; i++) {
            int smallCount = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    smallCount++;
                }
            }
            result += smallCount * factorial(A.length - i - 1);
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
