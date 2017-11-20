package com.mystudy.algorithm;
/**
 * 股票的最大收益
 * 
 *
 */
public class MaxProfit {

	public static void main(String[] args) {
		int prices[] = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	/**
	 * 只能进行一次交易
	 * 在[0...i-1]天买入,第[i]天卖出,只能买一手,卖一手,要使收益最大
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices){
		int p = 0;
		int mn = prices[0];
		for(int i = 1; i<prices.length; i++){
			mn = Math.min(mn, prices[i-1]);//p[0...i-1]最小值
			p = Math.max(p, prices[i] - mn);
		}
		return p;
	}

}
