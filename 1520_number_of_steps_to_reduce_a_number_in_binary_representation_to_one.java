class Solution {
    public int numSteps(String s) {
        s=s.trim();
        int t=0;
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>1){
            int l=sb.length()-1;
            if(sb.charAt(l)=='0'){
                sb.deleteCharAt(l);
            }
            else{
                int i=l;
                while(i>=0 && sb.charAt(i)=='1'){
                    sb.setCharAt(i, '0');
                    i--;
                }
                if(i>=0){
                    sb.setCharAt(i,'1');
                }
                else{
                    sb.insert(0,'1');
                }
            }
            t++;
        }
        return t;
    }
}