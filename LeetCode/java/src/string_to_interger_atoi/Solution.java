package string_to_interger_atoi;

/**
 * Created by Xiaotian on 7/1/17.
 */
public class Solution {
    // str preprocessing:
    // - remove leading/trailing whitespaces
    // - handle plus or minus sign
    // - out of range case/overflow
    // tag: str, ptr, math
    // time: O(n)
    // space: O(1)
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] S = s.toCharArray();
        int n = s.length();
        int i = 0;
        int sign = 1;
        int num = 0;
        // Remove leading spaces
        while (S[i] == ' ' && i < n) i++;
        // Handle signs
        if (S[i] == '+' || S[i] == '-') {
            sign = S[i] == '+' ? 1 : -1;
            i++;
        }
        // Convert to number and avoid overflow
        while (i < n) {
            int digit = S[i] - '0';
            if (digit < 0 || digit > 9) break; // trailing spaces handled here
            if (Integer.MAX_VALUE / 10 < num
                || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = 10 * num + digit;
            i++;
        }
        return sign * num;
    }
}