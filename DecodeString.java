package grace.shuati;
import java.util.*;

public class DecodeString {
    public String expressionExpand(String s) {
         String result = "";
         Stack<Integer> countStack = new Stack<>();
         Stack<String> resStack = new Stack<>();
         int index = 0;

         while (index < s.length()) {
             if (Character.isDigit(s.charAt(index))) {
                 int count = 0;
                 while (Character.isDigit(s.charAt(index))) {
                     count = count * 10 + (s.charAt(index) - '0');
                     index++;
                 }
                 countStack.push(count);
             } else if (s.charAt(index) == '[') {
                 resStack.push(result);
                 result = "";
                 index++;
             } else if (s.charAt(index) == ']') {
                 StringBuilder sb = new StringBuilder(resStack.pop());
                 int repeat = countStack.pop();
                 for (int i = 0; i < repeat; i++) {
                     sb.append(result);
                 }
                 result = sb.toString();
                 index++;
             } else {
                 result += s.charAt(index++);
             }
         }
         return result;
    }
}
