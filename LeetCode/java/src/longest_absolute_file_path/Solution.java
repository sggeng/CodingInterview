package longest_absolute_file_path;

/**
 * Created by Xiaotian on 1/23/18.
 */
public class Solution {
    // tag: str, dp
    // time: O(n)
    // space: O(n)
    /*
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;

        int res = 0;
        // path[i]: records curr path for i depth
        // path[0]: len("")
        // path[1]: path[0] + len("dir/")
        // path[2]: path[1] + len("subdir/")
        // path[i]: path[i-1] + len("...")
        int[] path = new int[input.length()+1];
        for (String line : input.split("\n")) {
            String dirOrFile = line.replaceAll("(\t)+", "");
            int depth = line.length() - dirOrFile.length();
            if (dirOrFile.contains(".")) { // file
                res = Math.max(res, path[depth] + dirOrFile.length());
            }
            else { // dir
                path[depth + 1] = path[depth] + dirOrFile.length() + 1; // 1 denotes '/' in file path
            }
        }
        return res;
    }
}

class SolutionII {
    // Same as Solution
    // used an array to record the current dir length (at depth i)
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        // path[i]: curr path in depth i
        // e.g. "": depth 0, "dir/": depth 1, "dir/subdir/" depth2
        int[] path = new int[tokens.length + 1];
        int maxLen = 0;
        for (String token : tokens) {
            String fileOrDir = token.replaceAll("(\t)+", "");
            int depth = token.length() - fileOrDir.length();
            if (fileOrDir.contains(".")) { // file
                maxLen = Math.max(maxLen, path[depth] + fileOrDir.length());
            }
            else { // dir
                path[depth + 1] = path[depth] + fileOrDir.length() + 1; // 1 refers to '/'
            }
        }
        return maxLen;
    }
}
