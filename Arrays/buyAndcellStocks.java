public class buyAndcellStocks {
    public static int buyandcellstocks(int prices[]) {
    int buyprices = Integer.MAX_VALUE;
    int maxprofit = 0;

    for(int i=0; i<prices.length; i++) {
      if(buyprices < prices[i]) {
        int profit = prices[i] - buyprices;
        maxprofit = Math.max(maxprofit,profit);
      }
      else {
        buyprices = prices[i];
      }
    }
    return maxprofit;
  }
   public static void main(String[] args) {
       int prices[] = {3,6,8,15,18,21};

       System.out.println(buyandcellstocks(prices));
   }
}
