package Dynamic_Programming.Stock;

public class DP121_Best_Time_to_Buy_and_Sell_Stock {
    /*
    最简单的股票问题
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;  // memo[]可以优化成一个int

        for(int p : prices){
            if(p < min){
                min = p;
            }else{
                profit = Math.max(profit, p - min);
            }
        }

        return profit;
    }
}
