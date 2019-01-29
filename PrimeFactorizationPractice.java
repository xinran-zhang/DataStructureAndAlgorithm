package grace.shuati;
import java.util.*;

public class PrimeFactorizationPractice {
    public List<Integer> primeFactorization(int num) {
        List<Integer> result = new ArrayList<>();
        int up = (int) Math.sqrt(num);
        for (int i = 2; i <= up && num > 1; i++) {
            while (num % i == 0) {
                result.add(i);
                num /= i;
            }
        }

        if (num > 1) {
            result.add(num);
        }

        return result;
    }
}
