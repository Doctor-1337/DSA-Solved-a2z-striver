package topic.array.medium;

public class StockBuyAndSell {

    //Always forget this question
    //Make sure we only need to take care of two things, lowest purchasing price, and profit at each day with the lowest purchasing price
    //Calc the profit at each day with the last lowest purchasing price, if it is greater update
    //then check if current purchase price is lower than last lowest  purchase price
//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int price = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            //Calc the profit by selling at the last purchased Lowest price
            int profitIfSoldToday = prices[i] - price;
            if (profit < profitIfSoldToday) {
                profit = profitIfSoldToday;
            }
            //Check if current buy price is lower than the last lowest purchase price
            if (price > prices[i])
                price = prices[i];
        }
        return profit;
    }
}
