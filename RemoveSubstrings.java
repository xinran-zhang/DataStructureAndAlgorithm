package grace.shuati;
import java.util.*;

public class RemoveSubstrings {
    public int minLength(String s, Set<String> dict) {
        // put string s to the queue, pop it, and find the next one
        // defination of next one: remove the substring in the dict
        // use a hashset to record the string
        // use minLen to find the shortest length of the new string
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int minLen = s.length();

        queue.offer(s);
        set.add(s);

        while (!queue.isEmpty()) {
            String str = queue.poll();
            for (String sub: dict) {
                int foundIndex = str.indexOf(sub);
                while (foundIndex != -1) {
                    String newStr = str.substring(0, foundIndex) + str.substring(foundIndex + sub.length());
                    if (!set.contains(newStr)) {
                        queue.offer(newStr);
                        set.add(newStr);
                        if (newStr.length() < minLen) {
                            minLen = newStr.length();
                        }
                    }
                    foundIndex = str.indexOf(sub, foundIndex + 1);
                }
            }
        }

        return minLen;
    }
}
