import java.util.*;

/**
 * Given two words (start and end), and a dictionary,
 * find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int num = 1;
        while (!queue.isEmpty()) {
            ++num;
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                String str = queue.poll();
                for (char c = 'a'; c <= 'z'; ++c) {
                    for (int j = 0; j < str.length(); ++j) {
                        if (str.charAt(j) == c) {
                            continue;
                        }
                        char[] chars = str.toCharArray();
                        chars[j] = c;
                        String newString = String.valueOf(chars);
                        if (dict.contains(newString)) {
                            queue.offer(newString);
                            dict.remove(newString);
                        }
                        if(newString.equals(end)){
                            return num;
                        }
                    }
                }

            }
        }
        return 0;
    }

}
