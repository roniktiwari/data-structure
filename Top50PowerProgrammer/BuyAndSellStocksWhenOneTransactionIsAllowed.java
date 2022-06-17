package Top50PowerProgrammer;

public class BuyAndSellStocksWhenOneTransactionIsAllowed  {


    public static void main(String[] args) {
        // below array contain prices of different stocks on multiple days
        int []  prices = { 7, 1, 5, 3, 6, 4 };
        int lsf = Integer.MAX_VALUE ;
        int overAllProfit  =  0 ;
        int profitOnEachDay =  0 ;

        for(int i = 0 ; i< prices.length ; i++){

            if(prices[i]<lsf){
                lsf = prices[i];
            }
            profitOnEachDay =  prices[i]- lsf ;
            if(overAllProfit<profitOnEachDay){
                overAllProfit = profitOnEachDay ;
            }
        }

        System.out.println(overAllProfit);

    }
}

