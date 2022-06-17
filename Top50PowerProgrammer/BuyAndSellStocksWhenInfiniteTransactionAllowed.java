package Top50PowerProgrammer;

public class BuyAndSellStocksWhenInfiniteTransactionAllowed {

    public static void main(String[] args) {

        int []  prices = { 1 , 3 , 2 , 8 , 4 , 9 };
        int bs = 0 ;
        int ss = 0 ;
        int profit = 0 ;
        for(int i = 1 ; i< prices.length ; i++) {
            if (prices[i] > prices[i - 1] ) {
                ss++;
            } else {
                profit +=  prices[ss] - prices[bs] ;
                bs = i;
                ss = i;
            }
        }
        profit+= (prices[ss] - prices[bs] ) ;
        System.out.println(profit);
    }

}
