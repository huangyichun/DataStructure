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
public class LeetCode_25 {
    ArrayList<ArrayList<String>> letters = new ArrayList<>(); //存放结果
    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        if(!dict.contains(end)){
            return letters;
        }
        dict.add(start);
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();


        bfs(start,end, dict, map, distance);
        dfs(map, start, end, distance, new ArrayList<>());
        return letters;
    }

    public ArrayList<String> extend(String currentStr, Set<String> dict) {
        ArrayList<String> ArrayList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int j = 0; j < currentStr.length(); ++j) {
                char[] chars = currentStr.toCharArray();
                if (chars[j] == c) {
                    continue;
                }
                chars[j] = c;
                if(dict.contains(String.valueOf(chars))) {
                    ArrayList.add(String.valueOf(chars));
                }
            }
        }
        return ArrayList;
    }

    public void bfs(String start, String end, Set<String> dict, Map<String, ArrayList<String>> nextMap, Map<String, Integer> distance) {
        for (String s : dict) {
            nextMap.put(s, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            boolean isEnd = false;
            for (int i = queue.size(); i > 0; --i) {
                String currentStr = queue.poll();
                ArrayList<String> ArrayList = extend(currentStr, dict);
                int distant = distance.get(currentStr);
                for (String next : ArrayList) {
                    nextMap.get(currentStr).add(next);
                    if (!distance.containsKey(next)) {
                        distance.put(next, distant + 1);
                        if (next.equals(end)) {
                            isEnd = true;
                        }else {
                            queue.offer(next);
                        }
                    }
                }
            }
            if (isEnd) {
                break;
            }
        }
    }


    public void dfs (Map<String, ArrayList<String>> map, String current,
                     String end, Map<String, Integer> distance, ArrayList<String> path) {
        path.add(current);
        if(end.equals(current)) {
            letters.add(new ArrayList<>(path));
        }else {
            for (String next : map.get(current)) {
                if (distance.get(next) == distance.get(current) + 1) {
                    dfs(map, next, end, distance, path);
                }
            }
        }
        path.remove(path.size()-1);
    }
}
