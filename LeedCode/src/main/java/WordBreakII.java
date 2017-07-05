import java.util.ArrayList;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces
 * in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(!isWordBreak(s, dict)){
            return new ArrayList<String>();
        }
        ArrayList<String>[] arrayLists = new ArrayList[s.length()+1];
        arrayLists[0] = new ArrayList<String>();
        arrayLists[0].add("");
        for (int i = 0; i < s.length(); ++i){
            for (int j = i; arrayLists[i] != null && j < s.length(); ++j) {
                String str = s.substring(i, j + 1);
                if(dict.contains(str)){
                    if(arrayLists[j + 1] == null){
                        arrayLists[j + 1] = new ArrayList<String>();
                    }
                    for (String s1 : arrayLists[i]){
                        if("".equals(s1)){
                            arrayLists[j + 1].add(str);
                        }else {
                            arrayLists[j + 1].add(s1 + " " + str);
                        }
                    }
                }
            }
        }
        return arrayLists[s.length()];
    }



    public boolean isWordBreak(String s, Set<String> dict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i=0; i< s.length(); ++i) {
            for (int j=i; dp[i] && j < s.length(); ++j) {
                if(dict.contains(s.substring(i, j+1))) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
