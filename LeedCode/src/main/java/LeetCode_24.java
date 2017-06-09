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
public class LeetCode_24 {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        HashSet<String> traverSet = new HashSet<>();//保存已遍历过的字符串
        traverSet.add(start);

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int num = 1;
        while (!queue.isEmpty()) {
            ++num;
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                String str = queue.poll();
                for (String s : getNextWords(str, dict, traverSet)) {
                    if (s.equals(end)) {
                        return num;
                    }
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public List<String> getNextWords(String str, HashSet<String> dict, HashSet<String> traverSet) {
        List<String> newWordsList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == c) {
                    continue;
                }
                char[] chars = str.toCharArray();
                chars[i] = c;
                String newString = String.valueOf(chars);
                if (dict.contains(newString) && !traverSet.contains(newString)) {
                    newWordsList.add(newString);
                    traverSet.add(newString);
                }
            }
        }
        return newWordsList;
    }
}
