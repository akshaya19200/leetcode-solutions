class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set <String> c = new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String sub=s.substring(i,i+k);
            c.add(sub);
        }
        return c.size()==(1<<k);
    }
}