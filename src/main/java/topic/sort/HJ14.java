package topic.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ14 字符串排序
 * @author d3y1
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // in.nextLine();
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            strs[i] = in.next();
        }

        Arrays.sort(strs);

        for(int i=0; i<n; i++){
            System.out.println(strs[i]);
        }
    }
}