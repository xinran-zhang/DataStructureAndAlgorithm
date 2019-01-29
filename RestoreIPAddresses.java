package grace.shuati;
import java.util.*;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, res);
        return res;
    }

    private void dfs(String s, int startIndex, List<String> list, List<String> res) {
        if (list.size() == 4) {
            if (startIndex != s.length()) {
                return;
            }
            StringBuilder str = new StringBuilder();
            for (String string: list) {
                str.append(Integer.parseInt(string));
                str.append(".");
            }
            str.deleteCharAt(str.length() - 1);
            res.add(str.toString());
            return;
        }

        for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
            String tmp = s.substring(startIndex, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                dfs(s, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int digit = Integer.parseInt(str);
        return digit >= 0 && digit <= 255;
    }
}
