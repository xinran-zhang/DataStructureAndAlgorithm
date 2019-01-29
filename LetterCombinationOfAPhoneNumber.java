package grace.shuati;
import java.util.*;

public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, String[]> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            res.add("");
            return res;
        }
        map.put('2', new String[] {"a", "b", "c"});
        map.put('3', new String[] {"d", "e", "f"});
        map.put('4', new String[] {"g", "h", "i"});
        map.put('5', new String[] {"j", "k", "l"});
        map.put('6', new String[] {"m", "n", "o"});
        map.put('7', new String[] {"p", "q", "r", "s"});
        map.put('8', new String[] {"t", "u", "v"});
        map.put('9', new String[] {"w", "x", "y", "z"});

        StringBuilder combination = new StringBuilder();
        dfs(digits, combination, map, res);
        return res;
    }

    private void dfs(String digits, StringBuilder combination, Map<Character, String[]>map, List<String> res) {
        if (combination.length() == digits.length()) {
            res.add(new StringBuilder(combination).toString());
            return;
        }

        for (String s: map.get(digits.charAt(combination.length()))) {
            combination.append(s);
            dfs(digits, combination, map, res);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
