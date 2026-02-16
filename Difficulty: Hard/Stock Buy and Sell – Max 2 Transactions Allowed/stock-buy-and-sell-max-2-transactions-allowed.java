class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int leastp = prices[0];
        int pist = 0;
        int dpleft[] = new int[prices.length];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<leastp){
                leastp = prices[i];
            }
            pist = prices[i]-leastp;
            if(pist>dpleft[i-1]){
                dpleft[i] = pist;
            }else{
                dpleft[i] = dpleft[i-1];
            }
        }

        int maxp = prices[prices.length-1];
        int maxpibt = 0;
        int dpright[] = new int[prices.length];
        for(int i=prices.length-2;i>=0;i--){
            if(maxp<prices[i]){
                maxp = prices[i];
            }

            maxpibt = maxp - prices[i];
            if(maxpibt>dpright[i+1]){
                dpright[i] = maxpibt;
            }else{
                dpright[i] = dpright[i+1];
            }
        }
        
        int op = 0;
        for(int i=0;i<prices.length;i++){
            if(dpleft[i]+dpright[i]>op){
                op = dpleft[i]+dpright[i];
            }
        }
        return op;
    }
}
