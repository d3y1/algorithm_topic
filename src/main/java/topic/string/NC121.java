package topic.string;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * NC121 字符串的排列
 * @author d3y1
 */
public class NC121 {
    private int N;
    private HashSet<String> set = new HashSet<>();

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return string字符串ArrayList
     */
    public ArrayList<String> Permutation (String str) {
        return solution(str);
    }

    /**
     * 字符串 + 递归
     * @param str
     * @return
     */
    private ArrayList<String> solution(String str){
        N = str.length();

        dfs(str.toCharArray(), 0);

        return new ArrayList<>(set);
    }

    /**
     * 递归
     * @param chars
     * @param idx
     */
    private void dfs(char[] chars, int idx){
        set.add(String.valueOf(chars));

        for(int j=idx; j<N; j++){
            swap(chars, idx, j);
            dfs(chars, idx+1);
            swap(chars, idx, j);
        }
    }

    /**
     * 交换
     * @param chars
     * @param i
     * @param j
     */
    private void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}