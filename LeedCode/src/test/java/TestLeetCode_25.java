import org.junit.Test;

import java.util.*;

/**
 * Created by huangyichun on 2017/6/10.
 */
public class TestLeetCode_25 {

    /**
     * start ="hit"
     * end ="cog"
     * dict =["hot","dot","dog","lot","log"]
     */
    @Test
    public void test() {
        String[][] strings = new String[][]{{"qa","ba","be","se","sq"},{"qa","ba","bi","si","sq"},
                {"qa","ba","br","sr","sq"},{"qa","ca","cm","sm","sq"},{"qa","ca","co","so","sq"},
                {"qa","la","ln","sn","sq"},
        {"qa","la","lt","st","sq"},{"qa","ma","mb","sb","sq"},{"qa","pa","ph","sh","sq"},
        {"qa","ta","tc","sc","sq"},{"qa","fa","fe","se","sq"},{"qa","ga","ge","se","sq"},
        {"qa","ha","he","se","sq"},{"qa","la","le","se","sq"},{"qa","ma","me","se","sq"},
        {"qa","na","ne","se","sq"},{"qa","ra","re","se","sq"},{"qa","ya","ye","se","sq"},
        {"qa","ca","ci","si","sq"},{"qa","ha","hi","si","sq"},{"qa","la","li","si","sq"},
        {"qa","ma","mi","si","sq"},{"qa","na","ni","si","sq"},{"qa","pa","pi","si","sq"},
        {"qa","ta","ti","si","sq"},{"qa","ca","cr","sr","sq"},{"qa","fa","fr","sr","sq"},
        {"qa","la","lr","sr","sq"},{"qa","ma","mr","sr","sq"},{"qa","fa","fm","sm","sq"},
        {"qa","pa","pm","sm","sq"},{"qa","ta","tm","sm","sq"},{"qa","ga","go","so","sq"},
        {"qa","ha","ho","so","sq"},{"qa","la","lo","so","sq"},{"qa","ma","mo","so","sq"},
        {"qa","na","no","so","sq"},{"qa","pa","po","so","sq"},{"qa","ta","to","so","sq"},
        {"qa","ya","yo","so","sq"},{"qa","ma","mn","sn","sq"},{"qa","ra","rn","sn","sq"},
        {"qa","ma","mt","st","sq"},{"qa","pa","pt","st","sq"},{"qa","na","nb","sb","sq"},
        {"qa","pa","pb","sb","sq"},{"qa","ra","rb","sb","sq"},{"qa","ta","tb","sb","sq"},
        {"qa","ya","yb","sb","sq"},{"qa","ra","rh","sh","sq"},{"qa","ta","th","sh","sq"}};

      /*  List<List<String>> lists = new ArrayList<>();
        for (int i=0; i<strings.length; ++i) {
            List<String> list = new ArrayList<>();
            for (int j=0; j < strings[0].length; ++j) {
                list.add(strings[i][j]);
            }
            lists.add(list);
        }

        Collections.sort(lists, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                for (int i=0; i<o1.size(); ++i) {
                    if(o1.get(i).equals(o2.get(i)))
                        continue;
                    return o1.get(i).compareTo(o2.get(i));
                }
                return 0;
            }
        });

*/
        String start = "qa";
        String end = "sq";
        ArrayList<String> dict = new ArrayList<>();
        String[] str = new String[] {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci",
                "ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn",
                "au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co",
                "ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st",
                "er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        for (int i = 0; i < str.length; ++i) {
            dict.add(str[i]);
        }
        LeetCode_25 leetCode_25 = new LeetCode_25();
        ArrayList<ArrayList<String>> lists = leetCode_25.findLadders(start, end, dict);
        lists.forEach(list -> {
            list.forEach(x -> System.out.printf(x + " "));
            System.out.println();
        });
    }
}
