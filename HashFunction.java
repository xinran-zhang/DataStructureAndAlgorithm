package grace.shuati;

public class HashFunction {
    public int hashCode(char[] key, int HASH_SIZE) {
        long hashValue = 0;
        for (int i = 0; i < key.length; i++) {
            hashValue = (33 * hashValue + key[i]) % HASH_SIZE;
        }
        return (int)hashValue % HASH_SIZE;
    }
}
