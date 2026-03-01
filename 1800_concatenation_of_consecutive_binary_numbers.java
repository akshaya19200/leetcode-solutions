class Solution {
    public int concatenatedBinary(int n) {
        long mod=1000000007L;
        long r=0L;
        int b=0;
        for(int i=1;i<=n;i++){
            if((i & (i-1))==0){
                b++;
            }
            r=((r << b) + i) % mod;
        }
        return (int) r;
    }
}