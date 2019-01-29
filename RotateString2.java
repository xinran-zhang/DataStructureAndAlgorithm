package grace.shuati;

public class RotateString2 {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        reverse(str, 0, str.length - offset % str.length - 1);
        reverse(str, str.length - offset % str.length, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private void reverse(char[] str, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}
