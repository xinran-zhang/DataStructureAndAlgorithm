package grace.shuati;


/**
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 */


public class RotateString {
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0){
            return;
        }
        reverseString(str, 0, str.length - offset % str.length);
        reverseString(str, str.length - offset % str.length + 1, str.length - 1);
        reverseString(str, 0, str.length - 1);
    }

    public void reverseString(char[] str, int start, int end) {
        char temp;
        while (start <= end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
