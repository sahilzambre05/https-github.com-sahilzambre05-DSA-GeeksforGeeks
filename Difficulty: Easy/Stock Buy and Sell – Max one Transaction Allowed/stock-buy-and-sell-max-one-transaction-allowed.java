class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int leastp = Integer.MAX_VALUE; //least profit
        int pist = 0; //profit if sold today
        int op=0; //old profit
        for(int i=0;i<prices.length;i++){
            if(prices[i]<leastp){
                leastp = prices[i];
            }
            pist = prices[i]-leastp;
            if(pist>op){
                op = pist;
            }
        }
        return op;
        
    }
}