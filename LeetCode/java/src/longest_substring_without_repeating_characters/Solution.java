package longest_substring_without_repeating_characters;

import java.util.*;

/**
 * Created by Xiaotian on 6/28/17.
 */
public class Solution {
    // sliding window
    // tag: str, hash
    // time: O(n), at most 2n steps for i and j
    // space: O(1)
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] S = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()) {
            if (!set.contains(S[r])) {
                set.add(S[r]);
                max = Math.max(max, set.size());
                r++;
            }
            else {
                set.remove(S[l]);
                l++;
            }
        }
        return max;
    }
}

class SolutionII {
    // Same as Solution
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        boolean[] ascii = new boolean[256]; // ascii2isShown
        int max = Integer.MIN_VALUE;
        int l, r;
        for (l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && ascii[s.charAt(r)] == false) {
                ascii[s.charAt(r)] = true;
                r++;
            }
            max = Math.max(max, r - l);
            ascii[s.charAt(l)] = false;
        }
        return max;
    }
}

class SolutionIII {
    public int lengthOfLongestSubstring(String s) {
        int[] charCnt = new int[256];
        char[] S = s.toCharArray();

        int maxLen = 0;
        int l, r;
        for (l = 0, r = 0; r < s.length(); l++) {
            while (r < s.length() && charCnt[S[r]] == 0) {
                charCnt[S[r]]++;
                r++;
            }
            maxLen = Math.max(maxLen, r - l);
            charCnt[S[l]]--;
        }
        return maxLen;
    }
}