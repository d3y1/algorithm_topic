package topic.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * @author d3y1
 */
public class HJ101 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            Integer[] nums = new Integer[n];
            for(int i=0; i<n; i++){
                nums[i] = in.nextInt();
            }

            int order = in.nextInt();
            if(order == 0){
                Arrays.sort(nums);
            }else if(order == 1){
                Arrays.sort(nums, (o1,o2) -> (o2-o1));
                // Arrays.sort(nums, Comparator.comparingInt(o -> (int)o).reversed());
            }

            for(int i=0; i<n; i++){
                System.out.print(nums[i]+" ");
            }
        }
    }
}