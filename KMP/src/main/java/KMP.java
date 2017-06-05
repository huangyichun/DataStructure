import org.junit.Test;


public class KMP {

    @Test
    public void test(){
        String pattern = "ABCDABD";
        String str = "BBC ABCDAB ABCDABCDABDE";
        boolean isMatcher = KMP(str,pattern);
        System.out.println(isMatcher);
    }
    //移动位数 = 已匹配的字符数 - 对应的部分匹配值
    public boolean KMP(String str, String pattern){
        if(str == null || pattern == null)
            return false;
        int[] next = new int[pattern.length()];
        setNext(pattern, next);

        for(int i=0; i<str.length(); ++i){
            int index = 0;
            while (index < pattern.length() && i < str.length()
                    && str.charAt(i) == pattern.charAt(index)){
                ++i;
                ++index;
            }
            if(index == pattern.length())
                return true;
            if(index != 0){//移动位数
                i += index - next[index-1];
            }
        }
        return false;
    }

    /**
     * 设置next移动具体
     * @param pattern
     * @param next
     */
    public void setNext(String pattern ,int[] next){
       int i =1;
        while(i<next.length){
            int index = 0;
            while(i < next.length && pattern.charAt(i) == pattern.charAt(index)){
                if(index == 0)
                    next[i] = 1;
                else
                     next[i] = next[i-1] + 1;
                ++i;
                ++index;
            }
            if(index == 0)
                ++i;
        }
    }
}
