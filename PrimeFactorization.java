package grace.shuati;
import java.util.*;

/**
 * Prime factorize a given integer.
 */

public class PrimeFactorization {
    public List<Integer> primeFactorization(int num) {
        List<Integer> res = new ArrayList<>();

        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                res.add(i);
                num = num / i;
            }
        }

        if (num != 1) {
            res.add(num);
        }

        return res;
    }
}
