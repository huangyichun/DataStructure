import org.junit.Test;


public class Manacher {


    @Test
    public void test(){
        String s = "aba";
        s = "abc1234321ab";
        manacher(s);
    }
    public void manacher(String str){
        if(str == null)
            return;

        char[] chars = new char[str.length()*2 + 1];
        int j=0;
        for(int i=0; i<chars.length; i++){//添加#号
            if((i & 1) == 0)
                chars[i] = '#';
            else
                chars[i] = str.charAt(j++);
        }

        int[] p = new int[chars.length];
        int pos = -1;
        int maxRight = -1;
        /**
         * 当 i > maxRight时，搜索i左右两边确定pos位置和maxRight位置
         * 当 i<= maxRight时:
         *  先令：p[i] = min(p[2 * pos -i], maxRight-i)
         *  再判断 i + p[i]， i-p[i] 位置左右两边是否相同
         */
        for(int i=0; i<chars.length; i++){
            if(i > maxRight){
                pos = i;
                p[i] = 0; //半径

                while(i - p[i] -1 >=0 && i + p[i] + 1 <= chars.length-1){
                    if(chars[i - p[i] -1] == chars[i + p[i] + 1])
                        ++p[i];
                    else
                        break;
                }
               maxRight = pos + p[i]; //最右侧
            }else {
                p[i] = Math.min(p[2 * pos -i], maxRight -i);
                if(i + p[i] == maxRight){//当i加上i的半径已经等于maxRight时
                    while(i + p[i] + 1<= chars.length-1 && i -p[i] -1 >= 0){
                        if(chars[i+p[i] + 1] == chars[i-p[i]-1])
                            ++p[i];
                        else
                            break;
                    }
                    pos = i;
                    maxRight = i + p[i];
                }
            }
        }

        int max = 0;
        for(int i=0; i<p.length; i++){
            if(p[i] > max)
                max = p[i];
        }
        System.out.println(max);
    }
}
