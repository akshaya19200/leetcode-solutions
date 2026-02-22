class Solution {
    public int binaryGap(int n) {
        int l=-1;
        int s=0;
        int t=0;
        while(n>0){
            if((n&1)==1){
                if(l!=-1){
                    s=Math.max(s,t-l);
                }
                l=t;
            }
            t++;
            n>>=1;
        }
        return s;
    }
}