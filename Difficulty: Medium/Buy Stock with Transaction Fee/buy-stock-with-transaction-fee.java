
class Solution {
    public int maxProfit(int prices[], int fee) {
        // Code here
        int obsp = -prices[0];
        int ossp = 0;
        for(int i=1;i<prices.length;i++){
            int nbsp=0;
            int nssp=0;
            if(ossp-prices[i]>obsp){
                nbsp = ossp-prices[i];
            }else{
                nbsp = obsp;
            }

            if(prices[i]+obsp-fee>ossp){
                nssp = prices[i]+obsp-fee; 
            }else{
                nssp = ossp;
            }
            ossp = nssp;
            obsp = nbsp;
        }
        return ossp;
    }
}