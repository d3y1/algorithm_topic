package topic.dp;

import java.util.Arrays;

/**
 * LC322 零钱兑换
 * @author d3y1
 */
public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[i]表示凑成金额i所需的最少硬币个数
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<=amount; j++){
                if(j >= coins[i]){
                    if(dp[j-coins[i]] != Integer.MAX_VALUE){
                        dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                    }
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
