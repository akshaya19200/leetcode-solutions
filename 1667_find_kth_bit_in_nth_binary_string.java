class Solution {
    public char findKthBit(int n, int k) {
        String s="0";
        for(int i=2;i<=n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=s.length()-1;j>=0;j--){
                sb.append(s.charAt(j)=='0'?'1':'0');
            }
            s=s+"1"+sb.toString();
        }
        return s.charAt(k-1);
    }
}